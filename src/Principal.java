import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ByCode.*;
import CreacionFicheros.CreateFile;
import EmpresaColeccion.Empresa;
import Menus.MenuPrincipal;

import static Fechas.MetodosFechas.*;

public class Principal {


    public static void main(String[] args) throws IOException {

        CreateFile CreateFile = new CreateFile();
        File file = CreateFile.createTxtFile("Registro_del_dia_"+formatearFechaHora(LocalDateTime.now()));
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

        MenuPrincipal.PrimerMenu(Listado,file);

    System.out.println("Gracias y hasta pronto");
    }

}