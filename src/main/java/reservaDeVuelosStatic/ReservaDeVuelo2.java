package reservaDeVuelosStatic;

public class ReservaDeVuelo2 {

    public ReservaDeVuelo2(){

    }
    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int year) {
        String diaReserva;
        String mesReserva;
        if (ExistenPasajesStatic.existenPasajes(destino, cantidad)) {
            diaReserva = FechaReservaStatic.getDay(dia, mes, year);
            mesReserva = FechaReservaStatic.getMoth(dia, mes, year);
            return "el dia " + diaReserva + " " + dia + " " + mesReserva + " " + year + " existen " + cantidad +" pasajes para " + destino;
        } else {
            return "no existen suficientes pasajes para " + destino;
        }
    }
}
