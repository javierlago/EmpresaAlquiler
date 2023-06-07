package Productos;

import java.time.LocalDate;

public class Usos {


    LocalDate fechaAlquiler,fechaEntrega;
    float importeApagar;
    String codigoProducto;
    String claveAlquiler;

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public float getImporteApagar() {
        return importeApagar;
    }

    public void setImporteApagar(float importeApagar) {
        this.importeApagar = importeApagar;
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

    public Usos(LocalDate fechaAlquiler, LocalDate fechaEntrega) {
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
    }
}
