package banco2Test;

import bancoStatic.AfpServiceGlobal;
import bancoStatic.AsfiServiceGlobal;
import bancoStatic.BancoUPB2;
import bancoStatic.SegipServiceGlobal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class Banco2TestParam {

    @ParameterizedTest
    @CsvSource({
            "'se le puede realizar el prestamo: 3000', true, true, 1000, 888999, 3000",
            "'debe revisar su carnet de identidad', false, false, 0, 8889998, 3000",
            "'usted no esta habilitado para prestamos', true, false, 1000, 888999, 3000"
    })
    public void verifyTheUser(String expected, boolean isRealPerson, boolean isAbleToGetCredit, int afpAmount, int id, int requestedAmount) {

        try (MockedStatic<SegipServiceGlobal> mockedSegipServiceGlobal = Mockito.mockStatic(SegipServiceGlobal.class);
             MockedStatic<AsfiServiceGlobal> mockedAsfiServiceGlobal = Mockito.mockStatic(AsfiServiceGlobal.class);
             MockedStatic<AfpServiceGlobal> mockedAfpServiceGlobal = Mockito.mockStatic(AfpServiceGlobal.class)) {

            mockedSegipServiceGlobal.when(() -> SegipServiceGlobal.isRealPerson(id)).thenReturn(isRealPerson);
            mockedAsfiServiceGlobal.when(() -> AsfiServiceGlobal.isAbleToGetCredit(id)).thenReturn(isAbleToGetCredit);
            mockedAfpServiceGlobal.when(() -> AfpServiceGlobal.getAmount(id)).thenReturn(afpAmount);

            BancoUPB2 bancoUPB2 = new BancoUPB2();

            Assertions.assertEquals(expected,
                    bancoUPB2.getAmountMoney(id, requestedAmount),
                    "ERROR en la solicitud del préstamo");
        }
    }
}

