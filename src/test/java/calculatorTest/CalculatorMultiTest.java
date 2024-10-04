package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CalculatorMultiTest {

    @Disabled
    @Test
    public void verifyDiv() {
        Calculator calculator = new Calculator();
        int expectedResult = 3;
        int actualResult = calculator.mult(9,3);
        Assertions.assertEquals(expectedResult,actualResult, "Error! la multiplicacion es incorrecta");
    }
}
