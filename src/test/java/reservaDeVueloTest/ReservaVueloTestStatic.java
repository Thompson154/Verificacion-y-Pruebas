package reservaDeVueloTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import reservaDeVuelosStatic.ExistenPasajesStatic;
import reservaDeVuelosStatic.FechaReservaStatic;
import reservaDeVuelosStatic.ReservaDeVuelo2;

public class ReservaVueloTestStatic {

    @Test
    public void existenPasajesTestStatic() {

        try (MockedStatic<ExistenPasajesStatic> existenPasajesStatic = Mockito.mockStatic(ExistenPasajesStatic.class);
             MockedStatic<FechaReservaStatic> fechaReservaStatic = Mockito.mockStatic(FechaReservaStatic.class)) {

            existenPasajesStatic.when(() -> ExistenPasajesStatic.existenPasajes("La Paz", 2)).thenReturn(true);
            fechaReservaStatic.when(() -> FechaReservaStatic.getDay(29, 5, 2023)).thenReturn("Lunes");
            fechaReservaStatic.when(() -> FechaReservaStatic.getMoth(29, 5, 2023)).thenReturn("Mayo");

            ReservaDeVuelo2 reservaDeVuelo2 = new ReservaDeVuelo2();

            Assertions.assertEquals("el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
                    reservaDeVuelo2.reservaVuelo("La Paz", 2, 29, 5, 2023),
                    "ERROR al reservar un vuelo");
        }
    }

    @Test
    public void existenPasajesTestFailStatic() {
        try (MockedStatic<ExistenPasajesStatic> existenPasajesStatic = Mockito.mockStatic(ExistenPasajesStatic.class);
             MockedStatic<FechaReservaStatic> fechaReservaStatic = Mockito.mockStatic(FechaReservaStatic.class)) {

            existenPasajesStatic.when(() -> ExistenPasajesStatic.existenPasajes("La Paz", 2)).thenReturn(false);
            fechaReservaStatic.when(() -> FechaReservaStatic.getDay(29, 5, 2023)).thenReturn("Lunes");
            fechaReservaStatic.when(() -> FechaReservaStatic.getMoth(29, 5, 2023)).thenReturn("Mayo");

            ReservaDeVuelo2 reservaDeVuelo2 = new ReservaDeVuelo2();

            Assertions.assertEquals("no existen suficientes pasajes para La Paz",
                    reservaDeVuelo2.reservaVuelo("La Paz", 2, 29, 5, 2023),
                    "ERROR al reservar un vuelo");
        }

    }
}
