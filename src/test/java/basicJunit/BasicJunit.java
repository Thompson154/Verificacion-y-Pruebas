package basicJunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicJunit {

    @BeforeEach
    public void setup(){
        System.out.println("Setup");
    }

    @AfterEach
    public void cleanup(){
        System.out.println("Cleanup");
    }

    @Test //poner para ejecutar automaticamente
    public void verifySomething() {
        //logic
        //verification
        System.out.println("Verify Something");
    }

    @Test
    @DisplayName("Verificar el siguiente flujo....")
    public void verifySomethingElse() {
        System.out.println("VerifySomethingElse");
    }
}
