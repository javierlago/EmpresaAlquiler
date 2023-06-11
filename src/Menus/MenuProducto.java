package Menus;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;
import Productos.MetodosProducto;
import Productos.Producto;
import Productos.ProductoAlquiler;
import Productos.ProductoVenta;
import Validaciones.Validaciones;

import java.io.IOException;
import java.util.ArrayList;

import static EmpresaColeccion.MetodosEmpresa.anadirProductoAempresa;
import static Validaciones.Validaciones.*;


public class MenuProducto implements Bufferreader {

    public static void escogerProducto(ArrayList<Empresa> Listado) throws IOException {
        do {

            String respuesta;
            boolean bandera = true;
            do {
                System.out.println("Que tipo de producto desea registrar\n" +
                        "1->Registrar un Prodyucto para venta\n" +
                        "2->Registrar un Prouducto para alquiler\n" +
                        "3->Mostrar los usos de un producto en alquiler\n" +
                        "0->Volver al menu principal");
                respuesta = br.readLine();
                try {
                    if (!isInt(respuesta) || Integer.parseInt(respuesta) < 0 || Integer.parseInt(respuesta) > 3) {
                        throw new OpcionMenu();
                    }
                    bandera=true;



                } catch (OpcionMenu e) {
                    System.err.println(e.getMessage());
                    bandera = false;
                }
            } while (!bandera);

            switch (Integer.parseInt(respuesta)) {

                case 1 -> {
                    ProductoVenta productoVenta = new ProductoVenta();
                    anadirProductoAempresa(Listado, productoVenta);


                }
                case 2 -> {
                    ProductoAlquiler productoAlquiler = new ProductoAlquiler();
                    anadirProductoAempresa(Listado, productoAlquiler);


                }
                case 3 -> {

                    String nombreEmpresa;
                    do {
                        MetodosEmpresa.PrintearEmpresas(Listado);
                        System.out.println("Introduce el nombre de la empresa");
                        nombreEmpresa = br.readLine();
                    } while (!MetodosEmpresa.empresaExiste(Listado, nombreEmpresa));


                    System.out.println("Seleccione uno de los productos de alquiler que desea ver la lista de usos");
                    for (Empresa empresa : Listado
                    ) {
                        if (empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa) == 0) {
                            for (Producto producto : empresa.getListadoProductos()
                            ) {
                                if (producto instanceof ProductoAlquiler && !((ProductoAlquiler) producto).getListadoUsuos().isEmpty()) {
                                    System.out.println("Codigo->"+producto.getCodigo()+" Marca->"+producto.getMarca()+" Modelo->"+producto.getModelo()+"\n");
                                }

                            }
                        }
                    }
                    MetodosProducto.mostrarUsuos(nombreEmpresa,Listado);

                }
                case 0 -> {
                    MenuPrincipal.PrimerMenu(Listado);
                }
            }

        } while (Validaciones.repetirProceso("Deseas realizar otra operacion S-s/N-n"));

    }

}
