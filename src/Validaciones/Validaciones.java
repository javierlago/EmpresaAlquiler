package Validaciones;

import Interfaces.Bufferreader;

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
    public static boolean lOr(char letra){
        if (letra == 'L') return true;
        if (letra=='R') return true;
        return false;
    }


}
