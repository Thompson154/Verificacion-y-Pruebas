package schoolTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import school.School;

public class SchoolTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "-1,ingrese nuevamente la nota!",
                    "0,necesitas poner mas atencion a las clases",
                    "1,necesitas poner mas atencion a las clases",
                    "24,necesitas poner mas atencion a las clases",
                    "25,necesitas poner mas atencion a las clases",
                    "26,necesitas poner mas atencion a las clases",
                    "58,necesitas poner mas atencion a las clases",
                    "59,necesitas poner mas atencion a las clases",
                    "60,necesitas estudiar mas",
                    "62,necesitas estudiar mas",
                    "63,necesitas estudiar mas",
                    "64,necesitas estudiar mas",
                    "69,necesitas estudiar mas",
                    "70,necesitas estudiar mas",
                    "71,muy bien hecho",
                    "72,muy bien hecho",
                    "73,muy bien hecho",
                    "74,muy bien hecho",
                    "79,muy bien hecho",
                    "80,muy bien hecho",
                    "81,gano media beca",
                    "83,gano media beca",
                    "84,gano media beca",
                    "85,gano media beca",
                    "89,gano media beca",
                    "90,gano media beca",
                    "91,gano beca",
                    "94,gano beca",
                    "95,gano beca",
                    "96,gano beca",
                    "99,gano beca",
                    "100,gano beca",
                    "101,ingrese nuevamente la nota!"
            }
    )

    public void verifyGetMessage(int nota, String expectedResult) {
        School school = new School();
        Assertions.assertEquals(expectedResult,school.getMessage(nota),"ERROR en la nota que se ingreso");
    }
}
