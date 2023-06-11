import java.io.IOException;
import java.util.ArrayList;

import ByCode.*;
import EmpresaColeccion.Empresa;
import Menus.MenuPrincipal;

public class Principal {


    public static void main(String[] args) throws IOException {
        ArrayList<Empresa> Listado  =new ArrayList<>();
        AnadirPorCodigo.anadirEmpresas(Listado);
        System.out.println("Bienvenidos a Patinetes Galica SL");
       /* ProductoVenta pv = new ProductoVenta();
       ProductoAlquiler pa = new ProductoAlquiler();
        ProductoAlquiler pa11 = new ProductoAlquiler();
        //ProductoVenta pv1 = new ProductoVenta();
       // ProductoAlquiler pa1 = new ProductoAlquiler();

        //MetodosEmpresa.anadirProductoAempresa(Listado,pv);
       MetodosEmpresa.anadirProductoAempresa(Listado,pa);
        MetodosEmpresa.anadirProductoAempresa(Listado,pa11);
        //MetodosEmpresa.anadirProductoAempresa(Listado,pv1);
        //MetodosEmpresa.anadirProductoAempresa(Listado,pa1);

        for (Empresa emp : Listado
        ) {
            System.out.println(emp.getListadoProductos().toString());
        }

    }*/

        MenuPrincipal.PrimerMenu(Listado);

    System.out.println("Gracias y hasta pronto");
    }

}