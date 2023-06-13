import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import ByCode.*;
import CreacionFicheros.CreateFile;
import CreacionFicheros.ListadoEmpresas;
import EmpresaColeccion.Empresa;
import Menus.MenuPrincipal;
import com.thoughtworks.xstream.XStream;

import static Fechas.MetodosFechas.*;

public class Principal {


    public static void main(String[] args) throws IOException {
        XStream xStream=new XStream();
        CreateFile createFile = new CreateFile();
        File file = createFile.createTxtFile("Registro_"+formatearFechaHora(LocalDateTime.now()));
        ArrayList<Empresa> Listado  =new ArrayList<>();
        AnadirPorCodigo.anadirEmpresas(Listado,file);
        System.out.println("Bienvenidos a Patinetes Galica SL");
        MenuPrincipal.PrimerMenu(Listado,file);
        System.out.println("Gracias y hasta pronto");



    }

}