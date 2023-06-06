package Productos;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;

import java.util.ArrayList;

public class ProductoVenta extends Producto {


    float precioVenta;
    public ProductoVenta(String marca, String modelo, String nombreEmpresa, float precioVenta, ArrayList<Empresa> Listado) {
        super(marca, modelo, nombreEmpresa);
        this.precioVenta = precioVenta;
        setCodigo("V"+String.format("%03d",numeroCodigo));
        setCif(MetodosEmpresa.cifSegunEmpresa(nombreEmpresa,Listado));
    }




    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "\nProductoVenta{" +
                "precioVenta=" + precioVenta +
                ", codigo='" + codigo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cif='" + cif + '\'' +
                '}';
    }
}



