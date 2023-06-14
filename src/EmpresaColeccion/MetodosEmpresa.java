package EmpresaColeccion;


import Interfaces.Bufferreader;
import Productos.MetodosProducto;
import Productos.Producto;

import java.io.IOException;
import java.util.ArrayList;

import static Productos.MetodosProducto.tieneProductoAlquilerConUsos;

/**
 * @author Javier Lago Amoedo
 */
public class MetodosEmpresa implements Bufferreader {
    /**
     * Metoso para encontrar el nombre de una empresa segun su CIF
     * @param Cif  String Cif de la empresa
     * @param listado ArrayList que contiene un listado de empresas
     * @return Devuelve el nombre de la empresa que tenga el Cif indicado
     */
    public static String getNameEmpresaByCif(String Cif,ArrayList<Empresa> listado){
        String nombreAbuscar=null;
        for (Empresa empresa : listado
             ) { if(empresa.getCif().compareToIgnoreCase(Cif)==0){
                 nombreAbuscar=empresa.getNombreEmpresa();
        }

        }
        return nombreAbuscar;
    }


    /**
     * Metodo para econtrar una empresa segun el nombre de la empresa
     * @param Listado ArrayList que contiene un listado de empresas.
     * @param Nombreempresa String nombre de empresa que deseamos encontrar
     * @return Devuelve un objeto Empresa cullo nombre coindcida con el @param NombreEmpresa
     */
    public static Empresa encotrarEmpresa(ArrayList<Empresa>Listado, String Nombreempresa){
        Empresa empresa = null;
        for (Empresa emp: Listado
             ) { if(emp.getNombreEmpresa().compareToIgnoreCase(Nombreempresa)==0){
                 empresa=emp;
        }

        }
        return empresa;
    }


    /**
     * Metodo que nos devuelve el CIF de una empresa segun el nombre de la empresa que pasemos por parametro.
     * @param nombreEmpresa nombre de la empresa que desmos saber el CIF.
     * @param lista  Listado  de empresas de las que deseamos obtener el CIG.
     * @return Devuelve el CIF de la empresa que coincida con el parametro nombreEmpresa.
     */
    public static String cifSegunEmpresa(String nombreEmpresa,ArrayList<Empresa> lista){
        String cifAbuscar=null;
        for (Empresa empresa: lista
             ) {if(nombreEmpresa.compareToIgnoreCase(empresa.getNombreEmpresa())==0){
                 cifAbuscar=empresa.getCif();
        }

        }
        return cifAbuscar;
    }


    /**Metodo en el que se añade un producto a una empresa,por teclado, segun las empresas existentes.
     *
     * @param Listado Listasdo de empresa
     * @param producto Objeto producto generado anteriomente y pasado como parametro
     * @throws IOException
     */
    public static void anadirProductoAempresa(ArrayList<Empresa> Listado,  Producto producto) throws IOException {
        String nombreEmpresa;
        PrintearEmpresas(Listado);
           do{
            nombreEmpresa=br.readLine();
           }while(!empresaExiste(Listado,nombreEmpresa));

        for (Empresa empresa: Listado
             ) {if(empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa)==0){
                 producto.setCif(empresa.getCif());
                    empresa.getListadoProductos().add(producto);
            System.out.println("Se ha añaddido el producto "+producto.mySpecialPrint());

        }
        }


    }

    /**
     * Metodo que printea el nombre de todasl las empresas del listado
     * @param Listado Listado de empresas de las que deseamos printear el nombre
     */
    public static void PrintearEmpresas(ArrayList<Empresa> Listado){

        System.out.println("¿En que empresa desea realizar la gestion?\n" +
                "Empresas existentes\n");
        for (Empresa empresa: Listado
        )
            System.out.println("->" + empresa.getNombreEmpresa() +"\n");


    }

    /**
     * Este metodo solo printeara aquellas empresa que tengan a disposicion productos de alquiler libres.
     * @param Listado Listado de empresas que recorremos buscando productos libres
     */
    public static void PrintearEmpresasConProductosLibres(ArrayList<Empresa> Listado){

        System.out.println("¿En que empresa desea realizar la gestion?\n" +
                "Empresas existentes\n");
        for (Empresa empresa: Listado
        )
            if(MetodosProducto.tieneProductoAlquilerLibres(empresa)){
                System.out.println("->" + empresa.getNombreEmpresa() +"\n");
            }



    }

    /**
     * Metodo para printear empresa en las que existen productos de alquilero y que su listado de usos no  este vacio
     * @param Listado Listado de empresas
     */
    public static void PrintearEmpresasConProductosAlquilerConUsos(ArrayList<Empresa> Listado){

        System.out.println("¿En que empresa desea realizar la gestion?\n" +
                "Empresas existentes\n");
        for (Empresa empresa: Listado
        )
            if(tieneProductoAlquilerConUsos(empresa)){
                System.out.println("->" + empresa.getNombreEmpresa() +"\n");
            }



    }


    /**
     * Metodo que comprueba que el nombre de la empresa que se pasa por parametro existe en el listado
     * @param Listado
     * @param empresaAbuscar
     * @return Devuelve true si el nombre existe en listado.
     */

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

    /**
     * Metodo que comprueba que la empressa pasada por parametro existe en una lista de empresas con productoslibres.
     * * @param Listado
     * @param empresaAbuscar
     * @return
     */
    public static boolean empresaPrroductosLibresExiste(ArrayList<Empresa> Listado,String empresaAbuscar){
        boolean bandera=false;
        for (Empresa empresa: Listado
        ) {if(empresa.getNombreEmpresa().compareToIgnoreCase(empresaAbuscar)==0&& MetodosProducto.tieneProductoAlquilerLibres(empresa)){
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

