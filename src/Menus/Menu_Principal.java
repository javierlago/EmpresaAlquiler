package Menus;

import EmpresaColeccion.*;
import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;

import java.io.IOException;
import java.util.ArrayList;

import static Validaciones.Validaciones.*;

public class Menu_Principal implements Bufferreader {

    public static   String menu=
            "Que operaccion desea realizar\n" +
            "1->Registrar una empresa\n" +
            "2->Gestionar productos\n" +
            "3->Modificar un producto existente\n" +
            "4->Alquiler de un producto\n" +
            "5->Dar de baja un producto\n" +
            "6->Creacion de ficheros\n" +
            "0->Salir";











    public static void PrimerMenu(ArrayList<Empresa> Listado) throws IOException {
        System.out.println(menu);
        String respuesta;
        boolean bandera=true;
        do{
            respuesta = br.readLine();
        try{
            if(!isInt(respuesta)||!numCorrecto(respuesta)){throw new OpcionMenu();
            }
        }catch (OpcionMenu e){
            System.err.println(e.getMessage());
            bandera=false;
        }
        }while (!bandera);

        switch (Integer.parseInt(respuesta)){

            case 1 ->{
                Empresa empresa = new Empresa();
                Listado.add(empresa);
                MetodosEmpresa.PrintearEmpresas(Listado);
            }
            case 2 ->{

                MenuProducto.escogerProducto(Listado);

            }
            case 0 ->{
                System.out.println("Gracias y hasta pronto");
            }

        }

    }



}
