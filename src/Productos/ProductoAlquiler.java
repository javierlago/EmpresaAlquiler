package Productos;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.EntradaNull;
import Excepciones.NombreCorrecto;
import Interfaces.Bufferreader;
import Validaciones.Validaciones;

import java.io.IOException;
import java.util.ArrayList;

import static Validaciones.Validaciones.*;

public class ProductoAlquiler extends Producto implements Bufferreader {

float precioDia;
char estado;

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

    public ProductoAlquiler( String marca, String modelo,String nombreEmpresa,float precioDia,char estado, ArrayList<Empresa> Listado) {
        super(marca, modelo,nombreEmpresa);
        this.precioDia=precioDia;
        this.estado=estado;
        setCodigo("A"+ String.format("%03d",numeroCodigo));
        setCif(MetodosEmpresa.cifSegunEmpresa(nombreEmpresa,Listado));
    }

public ProductoAlquiler(ArrayList<Empresa> Listado) throws IOException {
        setCodigo("A"+ String.format("%03d", Producto.numeroCodigo++));
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
        }
        }while(!bandera);
    }while (!floatNoNegativo(precioDia)||!InputEmpty(String.valueOf(precioDia)));
    String nombreEmpresa;
    do{
        System.out.println("Indique el nombre de la empresa");
         nombreEmpresa=br.readLine();
        try{
            if(!validarNombre(nombreEmpresa))throw new NombreCorrecto();
            if (!InputEmpty(nombreEmpresa)) throw new EntradaNull();
        }catch (NombreCorrecto|EntradaNull e){
            System.err.println(e.getMessage());

        }

    }while(!validarNombre(nombreEmpresa) || !InputEmpty(nombreEmpresa));

    this.cif=MetodosEmpresa.cifSegunEmpresa(nombreEmpresa,Listado);



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
