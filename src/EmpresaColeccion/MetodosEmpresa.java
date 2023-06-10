package EmpresaColeccion;


import Interfaces.Bufferreader;
import Productos.Producto;

import java.io.IOException;
import java.util.ArrayList;

public class MetodosEmpresa implements Bufferreader {

    public static Empresa encotrarEmpresa(ArrayList<Empresa>Listado, String Nombreempresa){
        Empresa empresa = null;
        for (Empresa emp: Listado
             ) { if(emp.getNombreEmpresa().compareToIgnoreCase(Nombreempresa)==0){
                 empresa=emp;
        }

        }
        return empresa;
    }



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
           }while(!empresaExiste(Listado,nombreEmpresa));

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

       }
       return bandera;
   }


}

