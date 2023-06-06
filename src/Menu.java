import java.io.IOException;
import java.util.ArrayList;

import ByCode.*;
import EmpresaColeccion.Empresa;
import Productos.ProductoAlquiler;
import EmpresaColeccion.MetodosEmpresa;
public class Menu {


    public static void main(String[] args) throws IOException {
        AnadirPorCodigo a = new AnadirPorCodigo();
        a.anadirEmpresas();
        ArrayList<Empresa> listaDo = a.getListadoEmpresas();
        ProductoAlquiler p = new ProductoAlquiler(listaDo);
        // TODO: Cambiar la manera de setear el CIF del producto segun a la empresa que se va a añadir el producto
        MetodosEmpresa.anadirProductoAempresa(listaDo,"Pontevedra",p);
        for (Empresa emp : listaDo
        ) {
            System.out.println(emp.getListadoProductos().toString());
        }

    }

}
