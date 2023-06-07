package Productos;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.EntradaNull;
import Excepciones.NombreCorrecto;
import Interfaces.Bufferreader;

import java.io.IOException;
import java.util.ArrayList;

import static Validaciones.Validaciones.*;
import static Validaciones.Validaciones.floatNoNegativo;

public class ProductoVenta extends Producto implements Bufferreader {


    float precioVenta;
    public ProductoVenta(String marca, String modelo, String nombreEmpresa, float precioVenta, ArrayList<Empresa> Listado) {
        super(marca, modelo, nombreEmpresa);
        this.precioVenta = precioVenta;
        setCodigo("V"+String.format("%03d",getNumeroCodigo()));
        setCif(MetodosEmpresa.cifSegunEmpresa(nombreEmpresa,Listado));
    }

    public ProductoVenta() throws IOException {
        super();
        setCodigo("V"+String.format("%03d",getNumeroCodigo()));
        do {
            System.out.println("Introducir la marca del producto");
            this.marca=br.readLine();
            try{
                if(!InputEmpty(marca))throw new EntradaNull();
                if(!validarNombre(marca))throw new NombreCorrecto();

            }catch (EntradaNull | NombreCorrecto e){
                System.err.println(e.getMessage());
            }
        }while(!InputEmpty(marca)|| !validarNombre(marca));
        do{
            System.out.println("Introducir el nombre de la modelo");
            this.modelo=br.readLine();
            try{
                if(!InputEmpty(modelo))throw new EntradaNull();
                if(!validarNombre(modelo))throw new NombreCorrecto();

            }catch (EntradaNull | NombreCorrecto e){
                System.err.println(e.getMessage());
            }
        }while(!InputEmpty(modelo)|| !validarNombre(modelo));

        do{
            boolean bandera=false;
            do{
                System.out.println("Introducir el precio de venta");
                String precioDia=br.readLine();
                if(isFloat(precioDia)){this.precioVenta=Float.parseFloat(precioDia);
                    bandera=true;
                }
            }while(!bandera);
        }while (!floatNoNegativo(precioVenta)||!InputEmpty(String.valueOf(precioVenta)));

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



