package CreacionFicheros;

import EmpresaColeccion.Empresa;
import Excepciones.EntradaNull;

import Interfaces.Bufferreader;
import Productos.ProductoAlquiler;
import Productos.ProductoVenta;
import Productos.Usos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Javier Lago Amoedo
 * @apiNote
 * Clase en la que se encuentran metodos en los que se pueden crear archivos de tipo XML,Json,txt,dat;
 */
public class CreateFile implements Bufferreader {



    public static String directoryPath= "Ficheros\\",endData=".dat",endJson=".json",endXml=".xml",endTxt=".txt",date=String.valueOf(LocalDate.now());

    /**
     * Metodo para crear un archivo XML con el nombre que se le pase por parametro,este archivo solo se creara si no existe.
     * @param fileName Nombre que tendra el archivo creado
     * @return Devuelve un archivo con extension xml y el nombre del parametri fileName
     * @throws IOException
     */
    public  File createXMLfile(String fileName) throws IOException {
        File fileXML= new File(directoryPath+fileName+endXml);
        if(!fileXML.exists())fileXML.createNewFile();
        return fileXML;
    }
    /**
     * Metodo para crear un archivo XML con el nombre que se le pase por parametro
     *
     *@return
     * @throws IOException
     */
    public  File createXMLfile()  {
        boolean flag = false;
        File fileXML = null;
        do {
            try {
                System.out.println("Introducir el nombre del archivo");
                String fileName = br.readLine();
                fileXML = new File(directoryPath + fileName + endXml);
                if (!fileXML.exists()) fileXML.createNewFile();
                flag=true;
                if (fileName.equals(""))throw new EntradaNull();
            } catch (EntradaNull e) {
                System.err.println("Debes introducir un nombre");
                flag=false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!flag);
        return fileXML;
    }

    public File createDatFile(String fileName) throws IOException {
        File fileDat= new File(directoryPath+fileName+endData);
        if(!fileDat.exists())fileDat.createNewFile();
        return fileDat;
    }

    public  File createDatFile()  {
        boolean flag = false;
        File fileDat = null;
        do {
            try {
                System.out.println("Introducir el nombre del archivo");
                String fileName = br.readLine();
                fileDat = new File(directoryPath + fileName + endData);
                if (!fileDat.exists()) fileDat.createNewFile();
                flag=true;
                if (fileName.equals(""))throw new EntradaNull();
            } catch (EntradaNull e) {
                System.err.println("Debes introducir un nombre");
                flag=false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!flag);

       return fileDat;
    }


    /**
     * Metodo para crear un archivo Json con el nombre que se le pasa por parametro y solo se creara si no existia previamente.
     * @param fileName
     * @return Devuelve un File con el nombre indicado por parameteo.
     * @throws IOException
     */

    public static File createJsontFile(String fileName) throws IOException {
        File fileJson= new File(directoryPath+fileName+endJson);
        if(!fileJson.exists())fileJson.createNewFile();
        return fileJson;
    }

    public static File createJsonFile()  {
        boolean flag = false;
        File jsonFile = null;
        do {
            try {
                System.out.println("Introducir el nombre del archivo");
                String fileName = br.readLine();
                jsonFile = new File(directoryPath + fileName + endJson);
                if (!jsonFile.exists()) jsonFile.createNewFile();
                flag=true;
                if (fileName.equals(""))throw new EntradaNull();
            } catch (EntradaNull e) {
                System.err.println("Debes introducir un nombre");
                flag=false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!flag);
        return jsonFile;
    }


    /**
     * Metodo usado para crear un archivo de tipo txt.
     * @param fileName Nombre que se le quiere dar al archivo
     * @return Devuelve un archivo con extension txt
     * @throws IOException
     */
    public  File createTxtFile(String fileName) throws IOException {
        File fileTxt= new File(directoryPath+fileName+endTxt);
        if(!fileTxt.exists())fileTxt.createNewFile();
        return fileTxt;
    }

    public  File createTxtFile()  {
        boolean flag = false;
        File txtFile = null;
        do {
            try {
                System.out.println("Introducir el nombre del archivo");
                String fileName = br.readLine();
                txtFile = new File(directoryPath + fileName + endTxt);
                if (!txtFile.exists()) txtFile.createNewFile();
                flag=true;
                if (fileName.equals(""))throw new EntradaNull();
            } catch (EntradaNull e) {
                System.err.println("Debes introducir un nombre");
                flag=false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!flag);
        return txtFile;
    }

    /**
     * Metodo usado para crear un seguimiento los movimientos realizados en la aplicacion
     * @param file Archivo en el que queremos que se guarde la informacion.
     * @param mensaje Mensaje que queremos guardar en el archivo que pasamos por parametro
     * @throws IOException
     */
    public static void trackInfo(File file,String mensaje) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        writer.write("------------------------------------\n"+mensaje+"\n-------------------------------------------------------------------------");
        writer.close();

    }

    /**
     * Metodo en el que se genera un archivo tipo Json con el nombre "ListadoDeEmpresa"
     * @param listado Listado de las empresas que queremos almacenar en el archibdvo
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void crearListadoEmpresarGson(ListadoEmpresas listado)throws IOException,FileNotFoundException{
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        try (FileWriter writer = new FileWriter(createJsontFile("ListadoDeEmpresas"))) {
            gson.toJson(listado, writer);
           gson.toJson(listado);

        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Metodo en el que generamos un archivo tipo Json de una empresa indica el usuario por teclado
     * @param empresa Empresa que queremos guardar en el archibo
     * @param nombreEmpresa Nombre de la empresa a guardar que le dara nombre al archivo.
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void crearListadoEmpresarGson(Empresa empresa,String nombreEmpresa)throws IOException,FileNotFoundException{
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        try (FileWriter writer = new FileWriter(createJsontFile(nombreEmpresa))) {
            gson.toJson(empresa, writer);
           gson.toJson(empresa);

        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    /**
     * Metodo para guardar en un archivo XML un listado de emoresa
     * @param xstream Metodo para convertir archivos a XML
     * @param Lista Listado de empresas a guardar
     * @param archivoXML Parametro de tipo File en el que se almacenara el listado
     * @throws FileNotFoundException
     */
    public static void pasarAxml(XStream xstream, ListadoEmpresas Lista , File archivoXML) throws FileNotFoundException {
        xstream.alias("ListadoEmpresas", ListadoEmpresas.class);
        xstream.alias("Empresa",Empresa.class);
        xstream.alias("ProductoAlquiler", ProductoAlquiler.class);
        xstream.alias("ProductoVenta", ProductoVenta.class);
        xstream.alias("Uso", Usos.class);
        xstream.toXML(Lista,new FileOutputStream(archivoXML));

       xstream.toXML(Lista);


    }


    /**
     * Metodo para almacenar una empresa en un archivo XML
     * @param xstream Metodo para pasar obejos a XML
     * @param empresa Parametro de tipo Empresa que deseamos guarda
     * @param archivoXML Parametro de tipo file donde queremos almacenar esa empresa
     * @throws FileNotFoundException
     */
    public static void pasarUnaEmpresaAxml(XStream xstream, Empresa empresa , File archivoXML) throws FileNotFoundException {
        xstream.alias("Empresa",Empresa.class);
        xstream.alias("ProductoAlquiler", ProductoAlquiler.class);
        xstream.alias("ProductoVenta", ProductoVenta.class);
        xstream.alias("Uso", Usos.class);
        xstream.toXML(empresa,new FileOutputStream(archivoXML));
        xstream.toXML(empresa);

    }


}
