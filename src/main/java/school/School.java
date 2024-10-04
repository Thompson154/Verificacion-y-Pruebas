package school;

public class School {

    public String getMessage(int nota){
        String message = "";
        if (nota >= 0 && nota <= 59 )
            return "necesitas poner mas atencion a las clases";
        if (nota >= 60 && nota <= 70 )
            return "necesitas estudiar mas";
        if (nota >= 71 && nota <= 80 )
            return "muy bien hecho";
        if (nota >= 81 && nota <= 90 )
            return "gano media beca";
        if (nota >= 91 && nota <= 100)
            return "gano beca";

        return "ingrese nuevamente la nota!";
    }
}
