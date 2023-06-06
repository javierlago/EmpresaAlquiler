package EmpresaColeccion;

import Excepciones.EntradaNull;
import Interfaces.Bufferreader;
import Validaciones.Validaciones;

import java.io.IOException;
import java.util.ArrayList;

public class MetodosEmpresa implements Bufferreader {

    public ArrayList<Empresa> ListadoEmpresas = new ArrayList<>();
    //TODO: Metodo en el que se muestra las empresas registradas y se obtiene el cif segun la que has indicado
    public String cifSegunEmpresabyUseer() throws IOException {
        String empresaSeleccionada;
        Empresa emp = null;
        for (Empresa empresa : this.ListadoEmpresas
        ) {
            System.out.println("->" + empresa.getNombreEmpresa() + "\n");
        }
        System.out.println("En que empresa desea registrar el producto ");
        boolean bandera = true;
        do {
            empresaSeleccionada = br.readLine();
            try {
                for (Empresa empresa : this.ListadoEmpresas
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


}