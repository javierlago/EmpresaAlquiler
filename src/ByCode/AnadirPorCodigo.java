package ByCode;


import EmpresaColeccion.Empresa;
import Productos.Producto;
import Productos.ProductoAlquiler;
import Productos.ProductoVenta;

import java.util.ArrayList;

public class AnadirPorCodigo {
    public static void anadirEmpresas(ArrayList<Empresa> Listado) {

        Empresa Pontevedra = new Empresa("A12345678A", "PontevedraRent", "986102030");
        Listado.add(Pontevedra);
        Pontevedra.getListadoProductos().add(new ProductoVenta("Combarro", "Small", "PontevedraRent", 1200, Listado));
        Pontevedra.getListadoProductos().add(new ProductoVenta("Combarro", "Medium", "PontevedraRent", 1500, Listado));
        Pontevedra.getListadoProductos().add(new ProductoVenta("Combarro", "Big", "PontevedraRent", 1800, Listado));
        Pontevedra.getListadoProductos().add(new ProductoVenta("Redondela", "Small", "PontevedraRent", 1200, Listado));
        Pontevedra.getListadoProductos().add(new ProductoVenta("Redondela", "Medium", "PontevedraRent", 1500, Listado));
        Pontevedra.getListadoProductos().add(new ProductoVenta("Redondela", "Big", "PontevedraRent", 1800, Listado));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Comabarro", "Small", "PontevedraRent", 15, 'L', Listado));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Comabarro", "Medium", "PontevedraRent", 25, 'L', Listado));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Comabarro", "Medium", "PontevedraRent", 50, 'L', Listado));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Redondela", "Small", "PontevedraRent", 15, 'L', Listado));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Redondela", "Medium", "PontevedraRent", 25, 'L', Listado));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Redondela", "Medium", "PontevedraRent", 50, 'L', Listado));


        Empresa Ourense = new Empresa("A12345678A", "OurenseRent", "986102030");
        Ourense.getListadoProductos().add(new ProductoVenta("Leiro", "Small", "OurenseRent", 1200, Listado));
        Ourense.getListadoProductos().add(new ProductoVenta("Leiro", "Medium", "OurenseRent", 1500, Listado));
        Ourense.getListadoProductos().add(new ProductoVenta("Leiro", "Big", "OurenseRent", 1800, Listado));
        Ourense.getListadoProductos().add(new ProductoVenta("Beran", "Small", "OurenseRent", 1200, Listado));
        Ourense.getListadoProductos().add(new ProductoVenta("Beran", "Medium", "OurenseRent", 1500, Listado));
        Ourense.getListadoProductos().add(new ProductoVenta("Beran", "Big", "OurenseRent", 1800, Listado));
        Ourense.getListadoProductos().add(new ProductoAlquiler("Leiro", "Small", "OurenseRent", 15, 'L', Listado));
        Ourense.getListadoProductos().add(new ProductoAlquiler("Leiro", "Medium", "OurenseRent", 25, 'L', Listado));
        Ourense.getListadoProductos().add(new ProductoAlquiler("Leiro", "Big", "OurenseRent", 50, 'L', Listado));
        Ourense.getListadoProductos().add(new ProductoAlquiler("Beran", "Small", "OurenseRent", 15, 'L', Listado));
        Ourense.getListadoProductos().add(new ProductoAlquiler("Beran", "Medium", "OurenseRent", 25, 'L', Listado));
        Ourense.getListadoProductos().add(new ProductoAlquiler("Beran", "Big", "OurenseRent", 50, 'L', Listado));


    }
}