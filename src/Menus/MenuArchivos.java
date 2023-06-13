package Menus;

import CreacionFicheros.CreateFile;
import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Interfaces.Bufferreader;
import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.util.ArrayList;

import static CreacionFicheros.CreateFile.pasarUnaEmpresaAxml;

public class MenuArchivos implements Bufferreader {
    public static void CrearArchivo(ArrayList<Empresa> listado) throws IOException {
        XStream xStream= new XStream();
        CreateFile cf = new CreateFile();
        String nombreEmpresa;
        Empresa empresa;
        empresa = null;
        System.out.println("De que empresa desea realizar el archivo");
        do{
            MetodosEmpresa.PrintearEmpresas(listado);
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
}
