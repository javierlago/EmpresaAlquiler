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

public class CreateFile implements Bufferreader {
 /* public static void main(String[] args) throws IOException {
       newFile newFile = new newFile();
       newFile.createXMLfile("Automatico");
       newFile.createDatFile("Automatico");
       newFile.createJsontFile("Automatico");
       newFile.createTxtFile("Automatico");
       newFile.createTxtFile();
       newFile.createXMLfile();
       newFile.createDatFile();
       newFile.createJsonFile();
   }*/


    public  String directoryPath= "Ficheros\\",endData=".dat",endJson=".json",endXml=".xml",endTxt=".txt",date=String.valueOf(LocalDate.now());


    public  File createXMLfile(String fileName) throws IOException {
        File fileXML= new File(directoryPath+fileName+endXml);
        if(!fileXML.exists())fileXML.createNewFile();
        return fileXML;
    }
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




    public File createJsontFile(String fileName) throws IOException {
        File fileJson= new File(directoryPath+fileName+endJson);
        if(!fileJson.exists())fileJson.createNewFile();
        return fileJson;
    }

    public File createJsonFile()  {
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

    public static void trackInfo(File file,String mensaje) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        writer.write(mensaje);
        writer.close();

    }

    public void crearListadoEmpresarGson(ListadoEmpresas listado)throws IOException,FileNotFoundException{
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();

        try (FileWriter writer = new FileWriter(createJsonFile())) {
            gson.toJson(listado, writer);
            String json = gson.toJson(listado);
            System.out.printf(json);
        }catch(FileNotFoundException e){
            System.err.println(e.getMessage());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void pasarAxml(XStream xstream, ListadoEmpresas Lista , File archivoXML) throws FileNotFoundException {
        xstream.alias("ListadoEmpresas", ListadoEmpresas.class);
        xstream.alias("Empresa",Empresa.class);
        xstream.alias("ProductoAlquiler", ProductoAlquiler.class);
        xstream.alias("ProductoVenta", ProductoVenta.class);
        xstream.alias("Uso", Usos.class);
        xstream.toXML(Lista,new FileOutputStream(archivoXML));

        String Listado = xstream.toXML(Lista);
        System.out.printf(Listado);
        System.out.println("\nSe ha creado xml");

    }
    public static void pasarUnaEmpresaAxml(XStream xstream, Empresa empresa , File archivoXML) throws FileNotFoundException {
        xstream.alias("Empresa",Empresa.class);
        xstream.alias("ProductoAlquiler", ProductoAlquiler.class);
        xstream.alias("ProductoVenta", ProductoVenta.class);
        xstream.alias("Uso", Usos.class);
        xstream.toXML(empresa,new FileOutputStream(archivoXML));
        String Listado = xstream.toXML(empresa);

    }


}
