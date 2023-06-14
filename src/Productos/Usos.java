package Productos;
import Interfaces.Bufferreader;
import com.google.gson.annotations.Expose;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

import static Fechas.MetodosFechas.convertiFecha;
import static java.time.temporal.ChronoUnit.*;

public class Usos implements Bufferreader, Serializable {


    LocalDate fechaInicioAlquiler;

    LocalDate fechaFinEntrega;
    @Expose
    public float importeApagar;
    @Expose
    public String codigoProducto;
    @Expose
    public String claveAlquiler;
    @Expose
    String InicioAlqu,FinAlqu;

    private LocalDate getFechaInicioAlquiler() {
        return fechaInicioAlquiler;
    }

    public void setFechaInicioAlquiler(LocalDate fechaInicioAlquiler) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
    }

    public LocalDate getFechaFinEntrega() {
        return fechaFinEntrega;
    }

    public void setFechaFinEntrega(LocalDate fechaFinEntrega) {
        this.fechaFinEntrega = fechaFinEntrega;
    }

    public float getImporteApagar() {
        return importeApagar;
    }

    public void setImporteApagar(LocalDate diaInicio,LocalDate diaFinal,ProductoAlquiler productoAlquiler) {
        long day = DAYS.between(diaInicio,diaFinal);
        this.importeApagar = day*productoAlquiler.getPrecioDia();
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getClaveAlquiler() {
        return claveAlquiler;
    }

    public void setClaveAlquiler(String claveAlquiler) {
        this.claveAlquiler = claveAlquiler;
    }


    // Constructores

    public Usos(LocalDate fechaInicioAlquiler, LocalDate fechaFinEntrega, ProductoAlquiler producto) {
        this.fechaInicioAlquiler = fechaInicioAlquiler;
        this.fechaFinEntrega = fechaFinEntrega;
        setCodigo(producto);
        setImporteApagar(fechaInicioAlquiler, fechaFinEntrega,producto);
        setClaveAlquiler(producto, fechaInicioAlquiler);
        InicioAlqu=String.valueOf(fechaInicioAlquiler);
        FinAlqu=String.valueOf(fechaFinEntrega);
    }

    public Usos(ProductoAlquiler productoAlquiler) throws IOException {
        setClaveAlquiler(productoAlquiler, fechaInicioAlquiler);
        String fecha=null;
        do{
            System.out.println("Indique la fecha de  inicio del alquiler");
            fecha=br.readLine();
        }while(convertiFecha(fecha)==null);
        setFechaInicioAlquiler(convertiFecha(fecha));
        do{
            System.out.println("Indique la fecha del  fin del alquiler");
            fecha=br.readLine();
        }while(convertiFecha(fecha)==null);
        setFechaFinEntrega(convertiFecha(fecha));
        setCodigo(productoAlquiler);
        setImporteApagar(this.fechaInicioAlquiler,this.fechaFinEntrega,productoAlquiler);
        setClaveAlquiler(productoAlquiler, fechaInicioAlquiler);
        InicioAlqu=String.valueOf(fechaInicioAlquiler);
        FinAlqu=String.valueOf(fechaFinEntrega);
    }




    @Override
    public String toString() {
        return "Usos{" +
                "fechaAlquiler=" + fechaInicioAlquiler +
                ", fechaEntrega=" + fechaFinEntrega +
                ", importeApagar=" + importeApagar +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", claveAlquiler='" + claveAlquiler + '\'' +
                '}';
    }

    public void setCodigo(Producto producto){
        this.codigoProducto=producto.getCodigo();

    }
    public void setClaveAlquiler(Producto producto,LocalDate FechaAlquiler){
        this.claveAlquiler=producto.getCodigo()+"-"+String.valueOf(FechaAlquiler);
    }

}



