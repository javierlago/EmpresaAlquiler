package Validaciones;

import Interfaces.Bufferreader;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Validaciones implements Bufferreader {
    /*public static void main(String[] args) throws IOException {
        String caca = br.readLine();
        System.out.println(InputEmpty(caca));
    }*/

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
        return codigo.matches("^A\\d{3}$");
    }
    public static boolean validarCodigoAVenta(String codigo){
        return codigo.matches("^V\\d{3}$");
    }



    public static LocalDate convertiFecha(String fecha){
        String formato = "dd/MM/yyyy";
         DateTimeFormatter formatter =DateTimeFormatter.ofPattern(formato);
         try {
             LocalDate fechaConvertida = LocalDate.parse(fecha,formatter);
             return fechaConvertida;

         }catch (DateTimeParseException e){
             System.err.println("El formato de la fecha debe de ser "+formato);
             return null;
         }



    }


}
