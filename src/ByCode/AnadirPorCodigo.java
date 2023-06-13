package ByCode;


import CreacionFicheros.CreateFile;
import EmpresaColeccion.Empresa;
import Productos.Producto;
import Productos.ProductoAlquiler;
import Productos.ProductoVenta;
import Productos.Usos;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AnadirPorCodigo {
    public static void anadirEmpresas(ArrayList<Empresa> Listado, File file) throws IOException {

        Empresa Pontevedra = new Empresa("A12345678A", "PontevedraRent", "986102030",file);
        Listado.add(Pontevedra);
        Pontevedra.getListadoProductos().add(new ProductoVenta("Combarro", "Small", "PontevedraRent", 1200, Listado,file));
        Pontevedra.getListadoProductos().add(new ProductoVenta("Combarro", "Medium", "PontevedraRent", 1500, Listado,file));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Comabarro", "Small", "PontevedraRent", 15, 'L', Listado,file));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Comabarro", "Medium", "PontevedraRent", 25, 'L', Listado,file));
        Empresa Ourense = new Empresa("A12345678A", "OurenseRent", "986102030",file);
        Listado.add(Ourense);
        Ourense.getListadoProductos().add(new ProductoVenta("Leiro", "Small", "OurenseRent", 1200, Listado,file));
        Ourense.getListadoProductos().add(new ProductoVenta("Leiro", "Medium", "OurenseRent", 1500, Listado,file));
        Ourense.getListadoProductos().add(new ProductoAlquiler("Beran", "Medium", "OurenseRent", 25, 'L', Listado,file));
        Ourense.getListadoProductos().add(new ProductoAlquiler("Beran", "Big", "OurenseRent", 50, 'L', Listado,file));
        ProductoAlquiler p = new ProductoAlquiler("Beran","Extra","OurenseRent",10,'L',Listado,file);
        p.getListadoUsuos().add(new Usos(LocalDate.of(2000,1,3),LocalDate.of(2000,2,2),p));
        p.getListadoUsuos().add(new Usos(LocalDate.of(2001,1,1),LocalDate.of(2001,2,1),p));
        Ourense.getListadoProductos().add(p);
    }
}