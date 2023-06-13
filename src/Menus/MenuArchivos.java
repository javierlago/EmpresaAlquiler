package Menus;

import CreacionFicheros.CreateFile;
import CreacionFicheros.ListadoEmpresas;
import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.OpcionMenu;
import Interfaces.Bufferreader;
import Validaciones.Validaciones;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.util.ArrayList;

import static CreacionFicheros.CreateFile.crearListadoEmpresarGson;
import static CreacionFicheros.CreateFile.pasarUnaEmpresaAxml;

public class MenuArchivos implements Bufferreader {
    public static void CrearArchivo(ArrayList<Empresa> listado) throws IOException {
        ListadoEmpresas listadoEmpresas = new ListadoEmpresas();
        listadoEmpresas.setListadoEmpresas(listado);
        XStream xStream= new XStream();
        CreateFile cf = new CreateFile();
        String nombreEmpresa;
        String respuesta;
        Empresa empresa;
        empresa = null;
        do{
            System.out.println("Que tipo de archivo quieres generar" +
                    "1->Crear un archivo XML de una empresa" +
                    "2->Crear un archivo Json de una empresa" +
                    "3->Crear un archivo XML de todas las empresas" +
                    "4->Crear un archivo Json de todas las empresar" +
                    "0->Volver a al menu principal");
            respuesta=br.readLine();
            try {
                if(!Validaciones.isInt(respuesta)||Integer.parseInt(respuesta)<0||Integer.parseInt(respuesta)>4){
                    throw new OpcionMenu();
                }
            } catch (OpcionMenu e) {
                System.out.println(e.getMessage());
            }
        }while(!Validaciones.isInt(respuesta)||Integer.parseInt(respuesta)<0||Integer.parseInt(respuesta)>4);
        switch (Integer.parseInt(respuesta)){
            case 1->{
                System.out.println("De que empresa desea realizar el archivo");
                do{
                    MetodosEmpresa.PrintearEmpresas(listado);
                    System.out.println("->Todas");
                    nombreEmpresa=br.readLine();
                }while(!MetodosEmpresa.empresaExiste(listado,nombreEmpresa));

                for (Empresa e : listado
                ) {if(e.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa)==0){
                    empresa=e;
                    break;
                }

                }
                pasarUnaEmpresaAxml(xStream,empresa,cf.createXMLfile("Listado"+nombreEmpresa));



            }
            case 2->{
                System.out.println("De que empresa desea realizar el archivo");
                do{
                    MetodosEmpresa.PrintearEmpresas(listado);
                    System.out.println("->Todas");
                    nombreEmpresa=br.readLine();
                }while(!MetodosEmpresa.empresaExiste(listado,nombreEmpresa));
                for (Empresa e : listado
                ) {if(e.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa)==0){
                    empresa=e;
                    break;
                }

                }
                crearListadoEmpresarGson(empresa,nombreEmpresa);

            }
            case 3 ->{
                cf.pasarAxml(xStream,listadoEmpresas,cf.createXMLfile("ListadoEmpresas"));
            }
            case 4 ->{

                crearListadoEmpresarGson(listadoEmpresas);

            }

        }




    }
}
