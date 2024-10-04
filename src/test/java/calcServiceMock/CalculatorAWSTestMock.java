package calcServiceMock;

import calcService.CalcService;
import calcService.CalculatorAWS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CalculatorAWSTestMock {

    //Step 2
    CalcService calcService = Mockito.mock(CalcService.class);

    @Test
    public void verifyFact(){
        //step3
        Mockito.when(calcService.mul(1,1)).thenReturn(1);
        Mockito.when(calcService.mul(1,2)).thenReturn(2);
        Mockito.when(calcService.mul(2,3)).thenReturn(6);
        //step4 **
        CalculatorAWS calculatorAWS = new CalculatorAWS();
        calculatorAWS.setCalcService(calcService);
        Assertions.assertEquals(6,calculatorAWS.getFact(3),"ERROR el factorial esta mal");
        // step5
        Mockito.verify(calcService).mul(1,1);
        Mockito.verify(calcService).mul(1,2);
        Mockito.verify(calcService).mul(2,3);
    }
}
