package Excepciones;

public class TelefonoInvalido extends Exception {
    static String mensaje = "El telefono no es correcto debe de tener nueve digitos";
    public TelefonoInvalido(){
        super(mensaje);
    }
}
