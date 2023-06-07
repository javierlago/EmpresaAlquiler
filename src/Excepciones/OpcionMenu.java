package Excepciones;

public class OpcionMenu extends Exception{

    static String mensaje="Debes elegir una de las opciones de el menu";
    public OpcionMenu(){
        super(mensaje);
    }
}
