package invertirNumeroTest;

import invertirNumero.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvertirNumTest {

    @Test
    public void testInvertirNumConNumeroValido() {
        Util util = new Util();

        int expectedResult = 54321;
        int actualResult = Integer.parseInt(util.invertirNum("12345"));
        Assertions.assertEquals(expectedResult, actualResult, "El se invertie bien");
    }

    @Test
    public void testInvertirNumConUnSoloDigito() {
        Util util = new Util();

        int expectedResult = 5;
        int actualResult = Integer.parseInt(util.invertirNum("5"));
        Assertions.assertEquals(expectedResult, actualResult, "Se comvierte en el mismo");
    }

    @Test
    public void testInvertirNumConLetras() {
        Util util = new Util();

        int expectedResult = 0;
        int actualResult = Integer.parseInt(util.invertirNum("abc"));
        Assertions.assertEquals(expectedResult, actualResult, "Para letras 0");
    }

    @Test
    public void testInvertirNumConNumerosNegativos() {
        Util util = new Util();

        int expectedResult = -54321;
        int actualResult = Integer.parseInt(util.invertirNum("-12345"));
        Assertions.assertEquals(expectedResult, actualResult, "Un string negativo a numero negativo");
    }

    @Test
    public void testInvertirNumConCero() {
        Util util = new Util();

        int expectedResult = 0;
        int actualResult = Integer.parseInt(util.invertirNum("0"));
        Assertions.assertEquals(expectedResult, actualResult, "De 0 a 0 ASKJ");
    }
}

