package Menus;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Interfaces.Bufferreader;
import Productos.MetodosProducto;
import Validaciones.Validaciones;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Validaciones.Validaciones.*;

public class MenuModificaciones implements Bufferreader {

    public static void Modificaciones(ArrayList<Empresa> Listado, File file) throws IOException {
        String empresa;
        String respuesta;
        String codigo;
        do{
        do{
         MetodosEmpresa.PrintearEmpresas(Listado);
         empresa = br.readLine();
        }while(!MetodosEmpresa.empresaExiste(Listado,empresa));
        System.out.println();
        System.out.println(
                "Que gestion desea realizar\n" +
                "0->Volver al menu principal\n" +
                "1->Modificcar un precio de venta\n" +
                "2->Modificar el precio de alquiler por dia\n" +
                "3->Dar de baja un producto de alquiler");

        do{
        respuesta= br.readLine();
        }while(!opcionMenu(respuesta,3));


        switch (Integer.parseInt(respuesta)) {

            case 1 -> {

                if(MetodosProducto.tieneProductoVenta(MetodosEmpresa.encotrarEmpresa(Listado,empresa))) {
                    MetodosProducto.printearProductosVenta(Listado, empresa);
                    System.out.println("Introducir codigo de producto a modificar");
                    do {
                        codigo = br.readLine();
                    } while (!Validaciones.validarCodigoAVenta(codigo) || !MetodosProducto.codigoVentaExiste(Listado, empresa, codigo));

                    MetodosProducto.setPrecioVenta(Listado, empresa, codigo);


                }else System.err.println("La empresa que has seleccionado no tiene productos en Venta");

            }
            case 2 ->{

                if(MetodosProducto.tieneProductoAlquiler(MetodosEmpresa.encotrarEmpresa(Listado,empresa))){
                    MetodosProducto.printearProductosAlquiler(Listado,empresa);
                    System.out.println("Introducir el codigo del producto a modicicar");
                    do{
                        codigo=br.readLine();
                    }while(!Validaciones.validarCodigoAlquiler(codigo)||!MetodosProducto.codigoAlquilerExiste(Listado,empresa,codigo));
                    MetodosProducto.setPrecioDia(Listado,empresa,codigo);

                }else System.err.println("La empresa que has seleccionado no tiene ningun producto en alquiler");


            }
            case 3->{
                if(MetodosProducto.tieneProductoAlquiler(MetodosEmpresa.encotrarEmpresa(Listado,empresa))){
                do{
                    MetodosProducto.printearProductosAlquiler(Listado,empresa);
                    System.out.println("Introducir el codigo del producto a modicicar");
                    codigo=br.readLine();
                }while(!Validaciones.validarCodigoAlquiler(codigo)||!MetodosProducto.codigoAlquilerExiste(Listado,empresa,codigo));
                    MetodosProducto.borrarUnProducto(Listado,empresa,codigo,file);

                }else System.err.println("La empresa que has seleccionado no tiene ningun producto en alquiler");

            }
            case 0 -> {
                MenuPrincipal.PrimerMenu(Listado,file);
            }


        }
    }while (Validaciones.repetirProceso("Desea relizar otra operacion S-s/N-n"));
    }


}
