package Validaciones;

import Interfaces.Bufferreader;
import Productos.ProductoAlquiler;
import Productos.Usos;

import java.io.IOException;


import java.time.LocalDate;


public class Validaciones implements Bufferreader {

    public static boolean validarNombre(String nombre){return nombre.matches("^[A-Z][a-zA-Z]*$");}
    public static boolean InputEmpty(String string){return !string.isEmpty();}

    public static boolean validateCIF(String cif ){ return cif.matches("^[A-HJNP-SUW][0-9]{8}[0-9A-J]$");}

    public static boolean validaTlf(String telefono){ return telefono.matches("^\\d{9}$");}

    public static boolean floatNoNegativo(float num){return num>0;}

    public static boolean isFloat(String numero){
        try {
            Float.parseFloat(numero);
            return true;
        }catch (NumberFormatException e){
            return false;
        }


    }
        public static boolean isInt(String numero){
        try {
            Integer.parseInt(numero);
            return true;

        }catch (NumberFormatException e){
            return false;}


        }

        public static boolean numCorrecto(String numero){
            return(Integer.parseInt(numero)>=0 && Integer.parseInt(numero)<=6);


        }

        public static boolean repetirProceso(String mensaje) throws IOException {
        String respuesta;
        boolean bandera=true;
        do{
            System.out.println(mensaje);
            respuesta= br.readLine();
            if(respuesta.compareToIgnoreCase("s")!=0 && respuesta.compareToIgnoreCase("n")!=0){
                System.err.println("Introduce una respuesta correcta");
                bandera=false;}
        }while(!bandera);
            if(respuesta.compareToIgnoreCase("s")==0){
                return true;
            }else return false;

    }

    public static boolean validarCodigoAlquiler(String codigo){
        if(!codigo.matches("^A\\d{3}$")){
            System.err.println("Codigo incorrecto,debes introducir un codigo que empieze por 'A' seguido de tres digitos");
        }
        return codigo.matches("^A\\d{3}$");
    }
    public static boolean validarCodigoAVenta(String codigo){
        if(!codigo.matches("^V\\d{3}$")){
            System.err.println("Codigo incorrexto debe de comenzar por una 'V' seguida de tres digitos");
        }
        return codigo.matches("^V\\d{3}$");
    }






}
