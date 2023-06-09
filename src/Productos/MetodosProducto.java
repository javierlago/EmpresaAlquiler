package Productos;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.MayorQueCero;
import Interfaces.Bufferreader;
import Validaciones.Validaciones;

import java.io.IOException;
import java.util.ArrayList;

public class MetodosProducto implements Bufferreader{


    public static void setPrecioDia(ArrayList<Empresa> Listado, String empresa, String codigo) throws IOException {
            ProductoAlquiler pa=null;
        String  nuevoprecio;
        for (Empresa e: Listado
        ) {if(e.getNombreEmpresa().compareToIgnoreCase(empresa)==0){
            for (Producto producto : e.getListadoProductos()
            ) {if(producto instanceof ProductoAlquiler || producto.getCodigo().compareToIgnoreCase(codigo)==0){
                pa= (ProductoAlquiler) producto;
            }
            }
        }
        }
        System.out.println("Introducir nuevo precio de alquiler");
        do {
            nuevoprecio= Bufferreader.br.readLine();
            try {
                Validaciones.isFloat(nuevoprecio);
                Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio));
                if(!Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio))){
                    throw new MayorQueCero();
                }

            }catch (MayorQueCero e){
                System.err.println(e.getMessage());
            }
            if(!Validaciones.isFloat(nuevoprecio)|| !Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio))){
                System.err.println("Debes de intoducir un precio valido");
            }
        }while (!Validaciones.isFloat(nuevoprecio)|| !Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio)));

         pa.setPrecioDia(Float.parseFloat(nuevoprecio));


    }

    public static void mostrarUsuos(String nombreEmoresa,ArrayList<Empresa> Listado) throws IOException {
            Empresa emp= null;
            String codigo;
        ProductoAlquiler productoAlquiler=null;
        for (Empresa empresa:Listado
             ) {if(empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmoresa)==0){
                 emp=empresa;
        }

        }
        do{
        System.out.println("Introducir el codigo");
        codigo= Bufferreader.br.readLine();
        if(!Validaciones.validarCodigoAlquiler(codigo)) System.err.println("Intrduce un codigo valido para alquiler");
        }while(!Validaciones.validarCodigoAlquiler(codigo));


        for (Producto producto: emp.getListadoProductos()
             ) {if (producto.getCodigo().compareToIgnoreCase(codigo)==0)productoAlquiler= (ProductoAlquiler) producto;
        }
        for (Usos usos: productoAlquiler.getListadoUsuos()
             ) {
            System.out.println(usos.toString());

        }
        }

    public static void printearProductosVenta(ArrayList<Empresa> Listado, String empresa){
            Empresa emp = null;
        for (Empresa e: Listado
             ) {
            if(e.getNombreEmpresa().compareToIgnoreCase(empresa)==0){
                 emp=e;
        }

        }
        for (Producto p: emp.getListadoProductos()
             ) {
            if(p instanceof ProductoVenta){
                System.out.println(((ProductoVenta) p).myVentaPrint());
            }

        }


    }

    public static void printearProductosAlquiler(ArrayList<Empresa> Listado, String empresa){
            Empresa emp = null;
            for (Empresa e: Listado
            ) {
                if(e.getNombreEmpresa().compareToIgnoreCase(empresa)==0){
                    emp=e;
                }

            }
            for (Producto p: emp.getListadoProductos()
            ) {
                if(p instanceof ProductoAlquiler){
                    System.out.println(((ProductoAlquiler) p).myAlquilerPrint());
                }

            }


        }

    public static boolean codigoVentaExiste(ArrayList<Empresa> Listado , String empresa , String codigo ){
            boolean bandera=false;
        for (Empresa e: Listado
             ) {if(e.getNombreEmpresa().compareToIgnoreCase(empresa)==0){
            for (Producto producto : e.getListadoProductos()
                 ) {if (producto instanceof ProductoVenta && producto.getCodigo().compareToIgnoreCase(codigo)==0){
                     bandera=true;
            }
            }
        }
        }

            if(!bandera) System.err.println("Debes seleccionar un codigo de la lista");
           return bandera;
    }

    public static boolean codigoAlquilerExiste(ArrayList<Empresa> Listado , String empresa , String codigo ){
            boolean bandera=false;
            for (Empresa e: Listado
            ) {if(e.getNombreEmpresa().compareToIgnoreCase(empresa)==0){
                for (Producto producto : e.getListadoProductos()
                ) {if (producto instanceof ProductoAlquiler && producto.getCodigo().compareToIgnoreCase(codigo)==0){
                    bandera=true;
                }
                }
            }
            }

            if(!bandera) System.err.println("Debes seleccionar un codigo de la lista");
            return bandera;
        }

    public static void setPrecioVenta(ArrayList<Empresa> Listado , String empresa , String codigo ) throws IOException {
        ProductoVenta pv = null;
        String  nuevoprecio;
        for (Empresa e: Listado
        ) {if(e.getNombreEmpresa().compareToIgnoreCase(empresa)==0){
            for (Producto producto : e.getListadoProductos()
            ) {if(producto instanceof ProductoVenta || producto.getCodigo().compareToIgnoreCase(codigo)==0){
                pv= (ProductoVenta) producto;
            }
            }
        }
        }

        System.out.println("Introducir nuevo precio de venta");
        do {
            nuevoprecio= Bufferreader.br.readLine();
            try {
                Validaciones.isFloat(nuevoprecio);
                Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio));
                if(!Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio))){
                  throw new MayorQueCero();
                }

            }catch (MayorQueCero e){
                System.err.println(e.getMessage());
            }
            if(!Validaciones.isFloat(nuevoprecio)|| !Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio))){
                System.err.println("Debes de intoducir un precio valido");
            }
        }while (!Validaciones.isFloat(nuevoprecio)|| !Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio)));


        if (pv != null) {
            pv.setPrecioVenta(Float.parseFloat(nuevoprecio));
        }
    }

    public static void borrarUnProducto(ArrayList<Empresa> Listado,String empresa,String codigo) throws IOException {
     Empresa emp = null;
     int num = -1;
        for (Empresa e: Listado
             ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                emp = e;
            }
        }
        for(int i=0;i<emp.getListadoProductos().size();i++){
       if(emp.getListadoProductos().get(i).getCodigo().compareToIgnoreCase(codigo)==0){
           num=i;
           break;
       }
        }
        emp.getListadoProductos().remove(num);




    }




}
