package EmpresaColeccion;

import ByCode.AnadirPorCodigo;
import Excepciones.EntradaNull;
import Interfaces.Bufferreader;
import Productos.Producto;
import Validaciones.Validaciones;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MetodosEmpresa implements Bufferreader {



        //Metodo para relacionar un producto con una empresa mediante el CIF
    public static String cifSegunEmpresa(String nombreEmpresa,ArrayList<Empresa> lista){
        String cifAbuscar=null;
        for (Empresa empresa: lista
             ) {if(nombreEmpresa.compareToIgnoreCase(empresa.getNombreEmpresa())==0){
                 cifAbuscar=empresa.getCif();
        }

        }
        return cifAbuscar;
    }


//Metodo en el que se añade un producto a una empresa,por teclado, segun las empresas existentes.
    public static void anadirProductoAempresa(ArrayList<Empresa> Listado,  Producto producto) throws IOException {
        boolean bandera=true;
        boolean encotrado=false;
        String nombreEmpresa;
        do{
            System.out.println("En que empresa quieres registrar el producto\n");
           PrintearEmpresas(Listado);
            nombreEmpresa=br.readLine();
        for (Empresa empresa: Listado
             ) {if(empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa)==0){
                 producto.setCif(empresa.getCif());
                    empresa.getListadoProductos().add(producto);
            System.out.println("Se ha añaddido el producoto "+producto.getModelo()+" a la empresa "+empresa.getNombreEmpresa());
            encotrado=true;
        }
        }
        if(!encotrado){
            System.err.println("Introduce un nombre de la lista");
            bandera=false;
        }

        }while(!bandera);

    }

    public static void PrintearEmpresas(ArrayList<Empresa> Listado){
        System.out.println("Empresas existentes");
        for (Empresa empresa: Listado
        )
            System.out.println("->" + empresa.getNombreEmpresa() +"\n");


    }

    public void mostrarUsosProducto(){

    }



}