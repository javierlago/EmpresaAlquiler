package Menus;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.MayorQueCero;
import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;
import Productos.MetodosProducto;
import Validaciones.Validaciones;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Validaciones.Validaciones.opcionMenu;

/**
 * @author Javier Lago Amoedo
 * @apiNote Con esta clase podremos gestionar los listados que deseamos consultar
 */

public class MenuListados implements Bufferreader {
    /**
     * Metodo para acceder a la visualizacion de los datos almacenados
     * @param listado Listado de empresas
     * @param file Archivo en el que se guardara el registro de las consultas realizadas
     * @throws IOException
     */
    public static void Listados(ArrayList<Empresa> listado, File file) throws IOException {
        String respuesta;
        String nombreEmpresa;

        System.out.println("Que operacion le gustaria realizar" +
                "\n1->Visualizar todas las empresar y sus productos" +
                "\n2->Visualizar la lista de productos de una empresa en concreto" +
                "\n0->Salir");


        do{
            respuesta=br.readLine();
        }while(!opcionMenu(respuesta,2));

        switch (Integer.parseInt(respuesta)){

            case 1 ->{
                for (Empresa empresa: listado
                     ) {
                    System.out.println("-------------------------------EMPRESA------------------------------");
                    System.out.println(empresa.toString());
                    System.out.println("--------------------------Productos Venta----------------------------");
                    MetodosProducto.printearProductosVenta(listado,empresa.getNombreEmpresa());
                    System.out.println("--------------------------Productos Alquiler-------------------------");
                    MetodosProducto.printearProductosAlquiler(listado,empresa.getNombreEmpresa());
                    System.out.println("---------------------------------------------------------------------");
                }





            }
            case 2 ->{
                do {
                    MetodosEmpresa.PrintearEmpresas(listado);
                    nombreEmpresa = br.readLine();
                } while (!MetodosEmpresa.empresaExiste(listado, nombreEmpresa));
                for (Empresa empresa: listado
                ) {

                    if(empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa)==0){

                        System.out.println(empresa.toString());
                        MetodosProducto.printearProductosVenta(listado,nombreEmpresa);
                        MetodosProducto.printearProductosAlquiler(listado,nombreEmpresa);


                    }


                }




            }


            case 0 ->{
                MenuPrincipal.PrimerMenu(listado,file);
            }
        }





    }
}
