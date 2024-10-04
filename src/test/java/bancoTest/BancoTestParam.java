package bancoTest;

import banco.AfpService;
import banco.AsfiService;
import banco.BancoUPBparam;
import banco.SegipService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BancoTestParam {

    @Mock
    private AfpService afpService;

    @Mock
    private AsfiService asfiService;

    @Mock
    private SegipService segipService;

    @InjectMocks
    private BancoUPBparam banco;

    @ParameterizedTest
    @CsvSource({
            "888999, true, true, 1000, se le puede realizar el prestamo: 3000",
            "8889998, false, true, 1000, debe revisar su carnet de identidad",
            "888999, true, false, 1000, usted no esta habilitado para prestamos"
    })
    public void verifyTheUserIsAble(int ci, boolean isRealPerson, boolean isAbleToGetCredit, int afpAmount, String expectedMessage) {

        when(segipService.isRealPerson(ci)).thenReturn(isRealPerson);
        lenient().when(asfiService.isAbleToGetCredit(ci)).thenReturn(isAbleToGetCredit);
        lenient().when(afpService.getAmount(ci)).thenReturn(afpAmount);

        String result = banco.getAmountMoney(ci, afpAmount);

        Assertions.assertEquals(expectedMessage, result, "ERROR en la verificación del préstamo");

        Mockito.verify(segipService).isRealPerson(ci);
        if (isRealPerson) {
            Mockito.verify(asfiService).isAbleToGetCredit(ci);
            if (isAbleToGetCredit) {
                Mockito.verify(afpService).getAmount(ci);
            }
        }
    }
}

