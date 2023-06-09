package EmpresaColeccion;


import Interfaces.Bufferreader;
import Productos.Producto;
import Productos.ProductoAlquiler;
import Productos.ProductoVenta;
import Productos.Usos;
import Validaciones.Validaciones;

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
        PrintearEmpresas(Listado);
           do{
            nombreEmpresa=br.readLine();
           }while(empresaExiste(Listado,nombreEmpresa));

        for (Empresa empresa: Listado
             ) {if(empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa)==0){
                 producto.setCif(empresa.getCif());
                    empresa.getListadoProductos().add(producto);
            System.out.println("Se ha añaddido el producoto "+producto.getModelo()+" a la empresa "+empresa.getNombreEmpresa());

        }
        }


    }

    public static void PrintearEmpresas(ArrayList<Empresa> Listado){

        System.out.println("¿En que empresa desea realizar la gestion?\n" +
                "Empresas existentes\n");
        for (Empresa empresa: Listado
        )
            System.out.println("->" + empresa.getNombreEmpresa() +"\n");


    }

   public static boolean empresaExiste(ArrayList<Empresa> Listado,String empresaAbuscar){
        boolean bandera=false;
       for (Empresa empresa: Listado
            ) {if(empresa.getNombreEmpresa().compareToIgnoreCase(empresaAbuscar)==0){
                bandera=true;
           break;
          }
       }
       if(!bandera){
           System.err.println("Por favor indique una de las empresas de la lista\n");
           PrintearEmpresas(Listado);
       }
       return bandera;
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
    codigo=br.readLine();
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

public static boolean codigoExiste(ArrayList<Empresa> Listado ,String empresa , String codigo ){
        boolean bandera=false;
    for (Empresa e: Listado
         ) {if(e.getNombreEmpresa().compareToIgnoreCase(empresa)==0){
        for (Producto producto : e.getListadoProductos()
             ) {if(producto.getCodigo().compareToIgnoreCase(codigo)==0){
                 bandera=true;
        }

        }

    }

    }

        if(!bandera) System.err.println("Debes seleccionar un codigo de la lista");
       return bandera;
}

    public static void setPrecioVenta(ArrayList<Empresa> Listado ,String empresa , String codigo ) throws IOException {
        ProductoVenta pv;
        String  nuevoprecio;
        for (Empresa e: Listado
        ) {if(e.getNombreEmpresa().compareToIgnoreCase(empresa)==0){
            for (Producto producto : e.getListadoProductos()
            ) {if(producto.getCodigo().compareToIgnoreCase(codigo)==0){
                pv= (ProductoVenta) producto;
            }

            }

        }

        }

        System.out.println("Introducir nuevo precio de venta");

        do {
            nuevoprecio=br.readLine();
            try {

            }

        }



    }










}

