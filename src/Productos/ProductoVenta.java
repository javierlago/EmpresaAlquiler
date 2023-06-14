package Productos;

import CreacionFicheros.CreateFile;
import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.EntradaNull;
import Excepciones.NombreCorrecto;
import Interfaces.Bufferreader;
import com.google.gson.annotations.Expose;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Validaciones.Validaciones.*;
import static Validaciones.Validaciones.floatNoNegativo;

public class ProductoVenta extends Producto implements Bufferreader {

    @Expose
    float precioVenta;

    /**
     * Constructor de un producto de venta paramentrizado
     * @param marca String que indica la marca del producto.
     * @param modelo String que indica el modelo de producto.
     * @param nombreEmpresa String Que indica el nombre de la empresa.
     * @param precioVenta Float en el que se indeca el precio de venta.
     * @param Listado ArrayList en el que se encuentran todas las empresas.
     * @param file Archivo en el que se guardara un registro de la creacion  del producto de la empresa.
     * @throws IOException -
     */
    public ProductoVenta(String marca, String modelo, String nombreEmpresa, float precioVenta, ArrayList<Empresa> Listado, File file) throws IOException {
        super(marca, modelo, nombreEmpresa);
        this.precioVenta = precioVenta;
        setCodigo("V"+String.format("%03d",getNumeroCodigo()));
        setCif(MetodosEmpresa.cifSegunEmpresa(nombreEmpresa,Listado));
        CreateFile.trackInfo(file,"Se ha añadido el producto->"+mySpecialPrint()+"a la empresa -> "+nombreEmpresa+"\n");
    }

    /**
     * Constuctor de un producto de venta en el que se le piden los datos al usuario.
     * @throws IOException
     */
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

    @Override
    public String mySpecialPrint() {
        return "Codigo->"+getCodigo()+" Marca->"+getMarca()+" Modelo->"+getModelo()+" Precio de venta->"+getPrecioVenta()+"\n";
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



