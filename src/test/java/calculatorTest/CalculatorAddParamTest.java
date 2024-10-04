package calculatorTest;

import calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorAddParamTest {

    @ParameterizedTest
    @CsvSource({
            "2,2,4", // dependiendo el numero de separaciones de comas que exista
                     // es el numero de parametros que se debe de colocar en orden
                     // dependiendo nuestras necesidades...
            "3,3,6",
            "4,5,9",
    })
    public void verifyAddPositiveNumber(int number1, int number2, int expectedResult) {
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(number1, number2);
        Assertions.assertEquals(expectedResult, actualResult, "Error la suma es incorrecta");
    }
}
