package Menus;

import EmpresaColeccion.*;
import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;

import java.io.IOException;
import java.util.ArrayList;

import static Validaciones.Validaciones.*;

public class Menu_Principal implements Bufferreader {

    public static   String menu="Que operaccion desea realizar\n1->Registrar una empresa\n2->Gestionar productos\n3->Modificar un producto existente\n4->Alquiler de un producto\n5->Dar de baja un producto\n6->Creacion de ficheros\n0->Salir";











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
