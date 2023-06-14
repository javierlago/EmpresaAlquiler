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

public class ProductoAlquiler extends Producto implements Bufferreader {
    /**
     * Constructor para crear un producto de alquiler parametrizado.Este construtor setea el codigo del producto de forma automatica.
     * @param marca String que indica la marca del producto
     * @param modelo String que indica el modelo del producto
     * @param nombreEmpresa String que indica el nombre de la empresa
     * @param precioDia Float para indicar el precio por dia de alquiler del producto
     * @param estado Char que indicara si el producto esta libre (L) o reservado(R)
     * @param Listado ArrayList en el que se encuentran todas las empresas en las que se pueden añadir el producto
     * @param file Archivo en el que se guardara el registro de que se ha creado un producto de alquiler
     * @throws IOException -
     */
    public ProductoAlquiler(String marca, String modelo, String nombreEmpresa, float precioDia, char estado, ArrayList<Empresa> Listado, File file) throws IOException {
        super(marca, modelo,nombreEmpresa);
        this.precioDia=precioDia;
        this.estado=estado;
        setCodigo("A"+ String.format("%03d",getNumeroCodigo()));
        setCif(MetodosEmpresa.cifSegunEmpresa(nombreEmpresa,Listado));
        CreateFile.trackInfo(file,"Se ha añadido el producto->"+mySpecialPrint()+"a la empresa -> "+nombreEmpresa+"\n");


    }


    /**
     * Constructor para crear un producto de alquiler en el que se piden los datos por tecldo.
     * Este constructor setea el codigo del producto de forma automatia.
     * @throws IOException -
     */
    public ProductoAlquiler() throws IOException {

        setCodigo("A"+ String.format("%03d", getNumeroCodigo()));
        this.estado='L';
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
                System.out.println("Introducir el precio por dia");
                String precioDia=br.readLine();
                if(isFloat(precioDia)){this.precioDia=Float.parseFloat(precioDia);
                    bandera=true;
                }else System.err.println("Debes de introducir un precio correcto");
            }while(!bandera);
        }while (!floatNoNegativo(precioDia)||!InputEmpty(String.valueOf(precioDia)));






    }
    @Expose
    float precioDia;
    @Expose
    char estado;
    @Expose
    ArrayList<Usos> listadoUsuos= new ArrayList<>();

    public ArrayList<Usos> getListadoUsuos() {
        return listadoUsuos;
    }

    public float getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(float precioDia) {
        this.precioDia = precioDia;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }


    /**
     * Metodo de en el que se printean las caracteristicas de un Producto.
     * @return String con las caracteristicas del producto.
     */

    @Override
    public String mySpecialPrint() {
        return "Codigo->"+ getCodigo()+" Marca->"+getMarca()+" Precio dia->"+getPrecioDia()+"\n";
    }

    @Override
    public String toString() {
        return "\nProductoAlquiler{" +
                "precioDia=" + precioDia +
                ", estado=" + estado +
                ", codigo='" + codigo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cif='" + cif + '\'' +
                '}';
    }






}
