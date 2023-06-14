package Fechas;

import Productos.ProductoAlquiler;
import Productos.Usos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class MetodosFechas {
    /**
     * Metodo para convertir un String en un LocalDate con un formato especificado.
     * @param fecha String que debe ser convertido en un LocalDate
     * @return Devuelve un LocalDate que se genera al parseaar el String.
     */
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

    /**
     * Metodos para validar que una de las dos fechas va despues de la otra
     * @param fecha1 LocalDate
     * @param fecha2 LocalDate
     * @return devuelve true si fecha2 es mas adelante que fecha1
     */
    public static boolean isAfter(LocalDate fecha1,LocalDate fecha2){
        if(!fecha2.isAfter(fecha1)){
            System.err.println("Debes de introducir una fecha posterior a "+formatearFecha(fecha1));
        }
        return fecha2.isAfter(fecha1);
    }


    /**
     * Metoodo para calcular en dias la diferencia entre dos fechas.
     * @param fechainici LocalDate
     * @param fechaEntrega LocalDate
     * @return Devuelve un int con el numero de dias de diferencia.
     */
    public static int calculardias(LocalDate fechainici,LocalDate fechaEntrega){
        return (int) ChronoUnit.DAYS.between(fechainici,fechaEntrega);
    }

    /**
     * Formatea un LocalDate con un patron especificado
     * @param fecha LocalDate
     * @return Devuelve un String con la fecha formateada
     */
    public static String formatearFecha(LocalDate fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatter);
    }
    /**
     * Formatea un LocalDate con un patron especificado
     * @param fechaHora LocalDate
     * @return Devuelve un String con la fecha formateada
     */

    public static String formatearFechaHora(LocalDateTime fechaHora){
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("'dia'(dd-MM-yyyy)'hora'(HH'horas'-mm'min'-ss'seg')");

        return fechaHora.format(dateTimeFormatter);
    }

}
