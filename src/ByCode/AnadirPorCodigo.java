package ByCode;


import EmpresaColeccion.Empresa;
import Productos.Producto;
import Productos.ProductoAlquiler;
import Productos.ProductoVenta;

import java.util.ArrayList;

public class AnadirPorCodigo {



    public ArrayList<Empresa> ListadoEmpresas = new ArrayList<>();

    public  ArrayList<Empresa> getListadoEmpresas() {
        return ListadoEmpresas;
    }



    public  void anadirEmpresas(){

        Empresa Pontevedra = new Empresa("A12345678A","Pontevedra","986102030");
        ListadoEmpresas.add(Pontevedra);
        Pontevedra.getListadoProductos().add(new ProductoVenta("Combarro","Lite","Pontevedra",1200,ListadoEmpresas));
        Pontevedra.getListadoProductos().add(new ProductoVenta("Lonza","Strong","Pontevedra",1200,ListadoEmpresas));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Pontedeume","Weak","Pontevedra",50,'L',ListadoEmpresas));
        Pontevedra.getListadoProductos().add(new ProductoAlquiler("Cangas","Weak","Pontevedra",50,'L',ListadoEmpresas));

    }








}
