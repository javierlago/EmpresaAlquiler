package Menus;

import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;
import Validaciones.Validaciones;

import java.io.IOException;
import java.util.ArrayList;

public class MenuModificaciones implements Bufferreader {

    public static void Modificaciones(ArrayList<Empresa> Listado) throws IOException {
        String empresa;
        String respuesta;
        String codigo;
        MetodosEmpresa.PrintearEmpresas(Listado);
        do{
         empresa = br.readLine();
        }while(MetodosEmpresa.empresaExiste(Listado,empresa));
        System.out.println();
        System.out.println("Que gestion desea realizar\n" +
                "1->Modificcar un precio de venta\n" +
                "2->Modificar el precio de alquiler por dia\n" +
                "3->Dar de baja un producto de alquiler");

        do{
        respuesta= br.readLine();
        try{
            Validaciones.isInt(respuesta);
            if(!Validaciones.isInt(respuesta)||Integer.parseInt(respuesta)<1||Integer.parseInt(respuesta)>3||respuesta.isEmpty()){
                throw new OpcionMenu();
            }
        }catch (OpcionMenu e){
            System.err.println(e.getMessage());
        }
        }while(!Validaciones.isInt(respuesta)||Integer.parseInt(respuesta)<1||Integer.parseInt(respuesta)>3||respuesta.isEmpty());


        switch (Integer.parseInt(respuesta)) {

            case 1 -> {
                MetodosEmpresa.printearProductosVenta(Listado, empresa);
                System.out.println("Introducir codigo de producto a modificar");
                do{
                    codigo=br.readLine();
                    }while(!Validaciones.validarCodigoAVenta(codigo)|| !MetodosEmpresa.codigoExiste(Listado,empresa,codigo));


            }





        }
    }


}
