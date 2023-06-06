package Excepciones;



public class EntradaNull extends Exception{

      static String mensaje = "Debe de introducir un nombre";

    public EntradaNull() {
        super(mensaje);

    }
}
