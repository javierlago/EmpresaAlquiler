package Menus;

import CreacionFicheros.CreateFile;
import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;
import Productos.MetodosProducto;
import Productos.Producto;
import Productos.ProductoAlquiler;
import Productos.ProductoVenta;
import Validaciones.Validaciones;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static EmpresaColeccion.MetodosEmpresa.anadirProductoAempresa;
import static EmpresaColeccion.MetodosEmpresa.empresaExiste;
import static Validaciones.Validaciones.*;


public class MenuProducto implements Bufferreader {

    public static void escogerProducto(ArrayList<Empresa> Listado, File file) throws IOException {
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
                    String empresa= MetodosEmpresa.getNameEmpresaByCif(productoVenta.getCif(),Listado);
                    CreateFile.trackInfo(file,"Se ha añadido el producto->"+productoVenta.mySpecialPrint()+"a"+empresa);


                }
                case 2 -> {
                    ProductoAlquiler productoAlquiler = new ProductoAlquiler();
                    anadirProductoAempresa(Listado, productoAlquiler);


                }
                case 3 -> {

                    String nombreEmpresa;
                    boolean muestra = false;
                    do {
                        MetodosEmpresa.PrintearEmpresas(Listado);
                        System.out.println("Introduce el nombre de la empresa");
                        nombreEmpresa = br.readLine();
                    } while (!MetodosEmpresa.empresaExiste(Listado, nombreEmpresa));



                    for (Empresa empresa : Listado
                    ) {
                        if (empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa) == 0) {
                            System.out.println("Seleccione uno de los productos de alquiler que desea ver la lista de usos");
                            for (Producto producto : empresa.getListadoProductos()
                            ) {

                                if (producto instanceof ProductoAlquiler && !((ProductoAlquiler) producto).getListadoUsuos().isEmpty()&& !empresa.getListadoProductos().isEmpty()) {
                                    System.out.println("Codigo->"+producto.getCodigo()+" Marca->"+producto.getMarca()+" Modelo->"+producto.getModelo()+"\n");
                                    muestra=true;
                                }

                            }
                        }
                    }
                  if(muestra){ MetodosProducto.mostrarUsuos(nombreEmpresa,Listado);}else System.err.println("La empresa que has seleccionado no tiene producotos");


                }
                case 0 -> {
                    MenuPrincipal.PrimerMenu(Listado,file);
                }
            }

        } while (Validaciones.repetirProceso("Deseas realizar otra operacion S-s/N-n"));

    }

}
