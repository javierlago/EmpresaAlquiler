package Menus;

import CreacionFicheros.CreateFile;
import EmpresaColeccion.*;
import Interfaces.Bufferreader;
import Productos.MetodosProducto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Validaciones.Validaciones.*;

public class MenuPrincipal implements Bufferreader {

    public static   String menu=
            "Que operaccion desea realizar\n" +
            "1->Registrar una empresa\n" +
            "2->Gestionar productos\n" +
            "3->Modificar un producto existente\n" +
            "4->Alquiler de un producto\n" +
            "5->Presupuesto\n" +
            "6->Consulta de datos\n" +
            "7->Creacion de archivos\n" +
            "0->Salir";











    public static void PrimerMenu(ArrayList<Empresa> Listado, File file) throws IOException {
        boolean repetir=true;

        do{
        System.out.println(menu);
        String respuesta;
        do{
            respuesta = br.readLine();
        }while (!opcionMenu(respuesta,7));

        switch (Integer.parseInt(respuesta)){

            case 1 ->{
                Empresa empresa = new Empresa();
                Listado.add(empresa);
                CreateFile.trackInfo(file,"Se ha creado la "+empresa+"\n");

            }
            case 2 ->{

                MenuProducto.escogerProducto(Listado,file);

            }
            case 3 ->{

                MenuModificaciones.Modificaciones(Listado,file);


            }

            case 4 -> {
                       MetodosProducto.alquilarProducto(Listado,file);


            }
            case 5 ->{
                do{
               MetodosProducto.calcularPresupuesto(Listado,file);
                    }while(repetirProceso("Desea calcular el presupuesto de otro producto"));

            }

            case 6 ->{
                do{
                MenuListados.Listados(Listado,file);
                }while(repetirProceso("Desea visualizar algun dato mas S-s/N-n "));
            }
            case 7 ->{

                MenuArchivos.CrearArchivo(Listado);

            }

            case 0 ->{

                repetir=!repetirProceso("Seguro que desea salir S-s/N-n");

            }

        }


        }while(repetir);

    }



}
