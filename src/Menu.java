import java.io.IOException;
import java.util.ArrayList;

import ByCode.*;
import EmpresaColeccion.Empresa;

public class Menu {


    public static void main(String[] args) throws IOException {
        AnadirPorCodigo a = new AnadirPorCodigo();
        a.anadirEmpresas();
        ArrayList<Empresa> lista = a.getListadoEmpresas();
        for (Empresa emp: lista
             ) {
            System.out.println(emp.getNombreEmpresa());
            System.out.println(emp.getListadoProductos().toString());

        }

        }

    }


