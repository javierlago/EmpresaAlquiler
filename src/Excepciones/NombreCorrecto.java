package Excepciones;

public class NombreCorrecto extends Exception{
    static String mensaje= "El nombre debe comenzar por letra mayuscuala";
    public NombreCorrecto(){

       super(mensaje);
    }



}
