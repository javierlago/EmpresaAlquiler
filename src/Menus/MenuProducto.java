package Menus;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;
import Productos.ProductoAlquiler;
import Productos.ProductoVenta;
import Validaciones.Validaciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static EmpresaColeccion.MetodosEmpresa.anadirProductoAempresa;
import static Validaciones.Validaciones.*;



public class MenuProducto implements Bufferreader {

    public static void escogerProducto(ArrayList<Empresa> Listado) throws IOException {
    do{
        System.out.println("Que tipo de producto desea registrar\n" +
                "1->Registrar un Prodyucto para venta\n" +
                "2->Registrar un Prouducto para alquiler\n" +
                "0->Volver al menu principal");
        String respuesta;
        boolean bandera=true;
        do{
            respuesta=br.readLine();
            try{
                if(!isInt(respuesta)||Integer.parseInt(respuesta)<0||Integer.parseInt(respuesta)>3)throw new OpcionMenu();


            }catch(OpcionMenu e){
                System.err.println(e.getMessage());
                bandera=false;
            }
        }while(!bandera);

        switch (Integer.parseInt(respuesta)){

            case 1 ->{
                ProductoVenta productoVenta = new ProductoVenta();
                anadirProductoAempresa(Listado,productoVenta);


            }
            case 2 -> {
                ProductoAlquiler productoAlquiler = new ProductoAlquiler();
                anadirProductoAempresa(Listado,productoAlquiler);


            }
            case 3 ->{
                System.out.println("En que empresa desea realizar la consulta");
                MetodosEmpresa.PrintearEmpresas(Listado);



            }
            case 0 -> {
                Menu_Principal.PrimerMenu(Listado);
            }
        }

    }while(Validaciones.repetirProceso("Deseas añadir otro producto S-s/N-n"));

    }

}
