package banco2Test;

import banco.BancoUPB;
import bancoStatic.AfpServiceGlobal;
import bancoStatic.AsfiServiceGlobal;
import bancoStatic.BancoUPB2;
import bancoStatic.SegipServiceGlobal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class Banco2Test {

    MockedStatic<SegipServiceGlobal> mockedSegipServiceGlobal = Mockito.mockStatic(SegipServiceGlobal.class);
    MockedStatic<AsfiServiceGlobal> mockedAsfiServiceGlobal = Mockito.mockStatic(AsfiServiceGlobal.class);
    MockedStatic<AfpServiceGlobal> mockedAfpServiceGlobal = Mockito.mockStatic(AfpServiceGlobal.class);

    @Test
    public void verifyTheUserIsAble(){

        mockedSegipServiceGlobal.when(() -> SegipServiceGlobal.isRealPerson(888999)).thenReturn(true);
        mockedAsfiServiceGlobal.when(()  -> AsfiServiceGlobal.isAbleToGetCredit(888999)).thenReturn(true);
        mockedAfpServiceGlobal.when(() -> AfpServiceGlobal.getAmount(888999)).thenReturn(1000);

        BancoUPB2 bancoUPB2 = new BancoUPB2();
        Assertions.assertEquals("se le puede realizar el prestamo: 3000",
                bancoUPB2.getAmountMoney(888999,3000),
                "ERROR el prestamo es incorrecto");
    }

    @Test
    public void verifyTheUserIsNotAbleToRequest(){

        MockedStatic<SegipServiceGlobal> segipServiceGlobal = Mockito.mockStatic(SegipServiceGlobal.class);

        segipServiceGlobal.when(()-> SegipServiceGlobal.isRealPerson(8889998)).thenReturn(false);

        BancoUPB bancoUPB = new BancoUPB();
        Assertions.assertEquals("debe revisar su carnet de identidad",
                bancoUPB.getAmountMoney(8889998,3000),
                "ERROR el prestamo es incorrecto");

    }

    @Test
    public void verifyTheUserIsNotAbleAsfi(){

        MockedStatic<SegipServiceGlobal> segipServiceGlobal = Mockito.mockStatic(SegipServiceGlobal.class);
        MockedStatic<AsfiServiceGlobal> asfiServiceGlobal = Mockito.mockStatic(AsfiServiceGlobal.class);
        MockedStatic<AfpServiceGlobal> afpServiceGlobal = Mockito.mockStatic(AfpServiceGlobal.class);

        segipServiceGlobal.when(() -> SegipServiceGlobal.isRealPerson(888999)).thenReturn(true);
        asfiServiceGlobal.when(() -> AsfiServiceGlobal.isAbleToGetCredit(888999)).thenReturn(false);
        afpServiceGlobal.when(() -> AfpServiceGlobal.getAmount(888999)).thenReturn(1000);

        BancoUPB2 bancoUPB2 = new BancoUPB2();
        Assertions.assertEquals("usted no esta habilitado para prestamos",
                bancoUPB2.getAmountMoney(888999,3000),
                "ERROR el prestamo es incorrecto");
    }
}