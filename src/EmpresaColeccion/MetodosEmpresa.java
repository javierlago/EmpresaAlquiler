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


    public String cifSegunEmpresabyUseer(String empresaSeleccionada,ArrayList<Empresa> Listado) throws IOException {


        Empresa emp = null;
        for (Empresa empresa : Listado
        ) {
            System.out.println("->" + empresa.getNombreEmpresa() + "\n");
        }
        System.out.println("En que empresa desea registrar el producto ");
        boolean bandera = true;
        do {
            empresaSeleccionada = br.readLine();
            try {
                for (Empresa empresa : Listado
                ) {
                    if (empresaSeleccionada.compareToIgnoreCase(empresa.getNombreEmpresa()) == 0)
                        emp = empresa;
                }

                if (!Validaciones.InputEmpty(empresaSeleccionada)) {
                    bandera=false;
                    throw new EntradaNull();
                }
                if (emp == null) {
                    System.err.println("Debes seleccionar una de las empresas de la lista");
                    bandera = false;
                }

            } catch (EntradaNull e) {
                System.err.println(e.getMessage());
            }

        } while (!bandera);

        return emp.getCif();
    }

    public static String cifSegunEmpresa(String nombreEmpresa,ArrayList<Empresa> lista){
        String cifAbuscar=null;
        for (Empresa empresa: lista
             ) {if(nombreEmpresa.compareToIgnoreCase(empresa.getNombreEmpresa())==0){
                 cifAbuscar=empresa.getCif();
        }

        }
        return cifAbuscar;
    }



    public static void anadirProductoAempresa(ArrayList<Empresa> Listado, String nombreEmpresa, Producto producto){
        for (Empresa empresa: Listado
             ) {if(empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa)==0){
                    empresa.getListadoProductos().add(producto);
        }

        }


    }

}