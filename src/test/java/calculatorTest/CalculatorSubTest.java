package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class CalculatorSubTest {

    // positive / acceptance
    @Test
    public void verifySub() {
        Calculator calculator = new Calculator();
        int expectedResult = 3;
        int actualResult = calculator.subs(9, 6);
        Assertions.assertEquals(expectedResult, actualResult, "ERROR! la resta es incorrecta");
    }

    // performance
    @Test
    @Timeout(value = 2)
    public void verifySubTime() {
        Calculator calculator = new Calculator();
        int expectedResult = 3;
        int actualResult = calculator.subs(9, 6);
        Assertions.assertEquals(expectedResult, actualResult, "ERROR! la resta es incorrecta");
    }
}
