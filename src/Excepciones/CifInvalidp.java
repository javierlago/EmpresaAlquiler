package Excepciones;

public class CifInvalidp  extends Exception{
    static String mensaje= "El CIF es incorrecto" +
            "Debe de empezar por cualquier letra mayúscula excepto I,O,U seguido de ocho digitos y acabado en cualquier digito del 0 al 9" +
            " o una letra mayúscula de la A al J";
    public CifInvalidp(){
        super(mensaje);
    }


}
