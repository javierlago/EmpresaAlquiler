package Validaciones;

import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;

import java.io.IOException;

/**
 * Clase validaciones en las que se se validadn los datos introduciddos por teclado
 * @author Javier Lago Amoedo
 * **/

public class Validaciones implements Bufferreader {


    /**
     * Metodo para validar un nombre tanto de una empresa como de el modelo de un producto o de una marca
     * @param nombre
     * @return Devuelve <bold>True</bold> si el nombre cumple con el patron especificado que seria
     * cualquier letra mayudcula sequido de al menos cualquier letra minuscula
     */
    public static boolean validarNombre(String nombre){return nombre.matches("^[A-Z][a-zA-Z]*$");}

    /**
     * Metoodo para validar que la entrada por teclado no esta vacia
     * @param string Recive un string que introduce el usuario por teclado
     * @return Devuelve <bold>True</bold> si la entrada no esta vacia.
     */
    public static boolean InputEmpty(String string){return !string.isEmpty();}


    /**
     * Metodo para validar el CIF de una empresa
     * @param cif (String)Se introduce un CIF por teclado
     * @return Devuelve <bold>True</bold> en caso de que el <stron>CIF</stron> introducido por teclado cumpla con el patron especificado
     * que es cualquier letra mayúscula excepto I,O,U seguido de ocho digitos y acabado en cualquier digito del 0 al 9 o una letra mayúscula de la A al J
     */
    public static boolean validateCIF(String cif ){ return cif.matches("^[A-HJNP-SUW][0-9]{8}[0-9A-J]$");}

    /**
     * Metodo para validar un número de teléfono introducido por teclado cumpla con el patron especificado.
     * @param telefono (String) Introducido por teclado por el usuario
     * @return Devuelve <bold>True</bold> en caso de que el <bold>Telefono</bold> introducido este compuesto por nueve digitos
     */
    public static boolean validaTlf(String telefono){ return telefono.matches("^\\d{9}$");}

    /**
     * Metodo para verificar que el float que recive por teclado no tenga un valor negativo
     * @param num
     * @return Devuelve <bold>True</bold> en caso de que el float introducido por teclado sea mayor que 0
     */

    public static boolean floatNoNegativo(float num){return num>0;}

    /**
     * Metodo en el que se verifica que el String recivido por teclado se puede convertir en un Float
     * @param numero
     * @return Devuelve <bold>True</bold> si el el un dato de tipo String se puede convertie en Float
     */
    public static boolean isFloat(String numero){
        try {
            Float.parseFloat(numero);
            return true;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    /**
     * Metodo que valida que el Strin recivido por teclado se puede convertir en un entero
     * @param numero
     * @return Devuelve <bold>True</bold> si se puede convertir en entero
     */
        public static boolean isInt(String numero){
        try {
            Integer.parseInt(numero);
            return true;

        }catch (NumberFormatException e){
            System.err.println("Debes de introducir un numero");
            return false;}


        }

    /**
     * Metodo en el que se verifica si la opcion escogida por el usuario es una de las opciones del menu.
     * @param numero String que indica el numero que se va a comprobar.
     * @param max Int maximo que tiene el menu.
     * @return Devolvera true si el parametri numero se puede convertir en Int y este entre 0 y el parametro max;
     */

        public static boolean opcionMenu(String numero, int max){
           try {
               isInt(numero);
               if(Integer.parseInt(numero)<0|| Integer.parseInt(numero)>max){throw new OpcionMenu();
               }
               return true;

           } catch (NumberFormatException nfe){
               return false;
           } catch (OpcionMenu m) {
               System.err.println(m.getMessage());
               return false;
           }
        }


    /**
     * Metodo para preguntar al usuarios si desea repetir proceso.Este metodo tiene un bucle en el que
     * no se sale mientras las respuesta sea diferente a s/S o n/N
     * @param mensaje String con la pregunta que se desea realizar al usuario.
     * @return Devuelve true si la respuesta es una s/S y false si la respueste es una n/N.
     * @throws IOException -
     */
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

            return respuesta.compareToIgnoreCase("s") == 0;

    }

    /**
     * Metodo para validar un codigo de un Alquiler
     *
     * @param codigo String codigo del producto de alquiler
     * @return Devuelve true si coincide el codigo con el  patron.
     */
    public static boolean validarCodigoAlquiler(String codigo){
        if(!codigo.matches("^A\\d{3}$")){
            System.err.println("Codigo incorrecto,debes introducir un codigo que empieze por 'A' seguido de tres digitos");
        }
        return codigo.matches("^A\\d{3}$");
    }

    /**
     * Metodo para validar un codigo de un Alquiler
     *
     * @param codigo String codigo del producto de venta.
     * @return Devuelve true si coincide el codigo con el  patron.
     */
    public static boolean validarCodigoAVenta(String codigo){
        if(!codigo.matches("^V\\d{3}$")){
            System.err.println("Codigo incorrecto debe de comenzar por una 'V' seguida de tres digitos");
        }
        return codigo.matches("^V\\d{3}$");
    }






}
