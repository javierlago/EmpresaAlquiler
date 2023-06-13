package Fechas;

import Productos.ProductoAlquiler;
import Productos.Usos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class MetodosFechas {
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
    public void verificarDisponibilidad(ProductoAlquiler productoAlquiler){
        for (Usos usos : productoAlquiler.getListadoUsuos()
        ) { if(usos.getFechaFinEntrega().isBefore(LocalDate.now())){
            productoAlquiler.setEstado('L');
        }

        }
    }


    public static int calculardias(LocalDate fechainici,LocalDate fechaEntrega){
        return (int) ChronoUnit.DAYS.between(fechainici,fechaEntrega);
    }

    public static String formatearFecha(LocalDate fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formatter);
    }
    public static String formatearFechaHora(LocalDateTime fechaHora){
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("'dia'(dd-MM-yyyy)'hora'(HH'horas'-mm'min'-ss'seg')");

        return fechaHora.format(dateTimeFormatter);
    }

}
