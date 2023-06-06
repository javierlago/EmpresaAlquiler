package Excepciones;

public class MayorQueCero extends Exception{
   static String mensaje = "El numero introducido debe ser mayor que cero";


    public MayorQueCero(){
        super(mensaje);
    }
}
