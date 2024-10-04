package reservaDeVueloTest;

import banco.BancoUPB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import reservaDeVuelos.ExistenPasajes;
import reservaDeVuelos.FechaReserva;
import reservaDeVuelos.ReservaDeVuelo;

public class ReservaVueloTest {

    ExistenPasajes existenPasajes = Mockito.mock(ExistenPasajes.class);
    FechaReserva fechaReserva = Mockito.mock(FechaReserva.class);


    @Test
    public void verifyReservarVuelo(){
        Mockito.when(existenPasajes.existenPasajes("La Paz",2)).thenReturn(true);
        Mockito.when(fechaReserva.getDay(29,5,2023)).thenReturn("Lunes");
        Mockito.when(fechaReserva.getMoth(29,5,2023)).thenReturn("Mayo");

        ReservaDeVuelo reservaDeVuelo = new ReservaDeVuelo();

        reservaDeVuelo.setFechaReserva(fechaReserva);
        reservaDeVuelo.setExistenPasajes(existenPasajes);

        Assertions.assertEquals("el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz",
                reservaDeVuelo.reservaVuelo("La Paz",2,29,5,2023),
                "ERROR al reservar un vuelo");

        Mockito.verify(existenPasajes).existenPasajes("La Paz",2);
        Mockito.verify(fechaReserva).getDay(29,5,2023);

    }


    @Test
    public void verifyReservarVueloFail(){
        Mockito.when(existenPasajes.existenPasajes("La Paz",2)).thenReturn(false);
//        Mockito.when(fechaReserva.getDay(29,5,2023)).thenReturn("Lunes");
//        Mockito.when(fechaReserva.getMoth(29,5,2023)).thenReturn("Mayo");

        ReservaDeVuelo reservaDeVuelo = new ReservaDeVuelo();

        reservaDeVuelo.setFechaReserva(fechaReserva);
        reservaDeVuelo.setExistenPasajes(existenPasajes);

        Assertions.assertEquals("no existen suficientes pasajes para La Paz",
                reservaDeVuelo.reservaVuelo("La Paz",2,29,5,2023),
                "ERROR al reservar un vuelo");

        Mockito.verify(existenPasajes).existenPasajes("La Paz",2);
//        Mockito.verify(fechaReserva).getDay(29,5,2023);

    }

}
