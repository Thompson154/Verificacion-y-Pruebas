package reservaDeVuelos;

public class ReservaDeVuelo {

    private ExistenPasajes existenPasajes;
    private FechaReserva fechaReserva;


    public ReservaDeVuelo() {
        existenPasajes = new ExistenPasajes();
        fechaReserva = new FechaReserva();
    }

    public void setExistenPasajes(ExistenPasajes existenPasajes) {
        this.existenPasajes = existenPasajes;
    }

    public void setFechaReserva(FechaReserva fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int year) {
        String diaReserva;
        String mesReserva;
        if (existenPasajes.existenPasajes(destino, cantidad)) {
            diaReserva = fechaReserva.getDay(dia, mes, year);
            mesReserva = fechaReserva.getMoth(dia, mes, year);
            return "el dia " + diaReserva + " " + dia + " " + mesReserva + " " + year + " existen " + cantidad +" pasajes para " + destino;
        } else {
            return "no existen suficientes pasajes para " + destino;
        }
    }
}
