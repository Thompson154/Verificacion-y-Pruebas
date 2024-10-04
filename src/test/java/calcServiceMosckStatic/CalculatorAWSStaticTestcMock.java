package calcServiceMosckStatic;

import calcServiceStatic.CalcServiceStatic;
import calcServiceStatic.CalculatorAWS2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class CalculatorAWSStaticTestcMock {

    @Test
    public void verifyFact(){
        //step 2
        MockedStatic<CalcServiceStatic> serviceStaticMockedStatic = Mockito.mockStatic(CalcServiceStatic.class);
        //step 3
        serviceStaticMockedStatic.when(()-> CalcServiceStatic.mult(1,1)).thenReturn(1);
        serviceStaticMockedStatic.when(()-> CalcServiceStatic.mult(1,2)).thenReturn(2);
        serviceStaticMockedStatic.when(()-> CalcServiceStatic.mult(2,3)).thenReturn(6);
        serviceStaticMockedStatic.when(()-> CalcServiceStatic.mult(6,4)).thenReturn(24);

        CalculatorAWS2 aws2 = new CalculatorAWS2();
        int actualResult = aws2.getFact(4);
        int expectedResult = 24;
        Assertions.assertEquals(expectedResult,actualResult,"ERROR el factorial es incorrecto!");
    }
}
