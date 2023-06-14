package EmpresaColeccion;

import CreacionFicheros.CreateFile;
import Excepciones.CifInvalido;
import Excepciones.EntradaNull;
import Excepciones.NombreCorrecto;
import Excepciones.TelefonoInvalido;
import Interfaces.Bufferreader;
import Productos.*;
import com.google.gson.annotations.Expose;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import static Validaciones.Validaciones.*;

public class Empresa implements Serializable,Bufferreader {
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNumTelfono() {
        return numTelfono;
    }

    public void setNumTelfono(String numTelfono) {
        this.numTelfono = numTelfono;
    }

    public ArrayList<Producto> getListadoProductos() {
        return ListadoProductos;
    }

    public void setListadoProductos(ArrayList<Producto> listadoProductos) {
        ListadoProductos = listadoProductos;
    }
    @Expose
    String cif, nombreEmpresa, numTelfono;
    @Expose
    ArrayList<Producto> ListadoProductos = new ArrayList<>();

    public Empresa(String cif, String nombreEmpresa, String numTelfono, File file) throws IOException {
        this.cif = cif;
        this.nombreEmpresa = nombreEmpresa;
        this.numTelfono = numTelfono;
        CreateFile.trackInfo(file,"Se ha creado la "+toString()+"\n");
    }

    public Empresa() throws IOException {
        do {
            System.out.println("Indique nombre de la empresa");
            this.nombreEmpresa = br.readLine();
            try {


                if (!validarNombre(nombreEmpresa)) throw new NombreCorrecto();
                if (!InputEmpty(nombreEmpresa)) throw new EntradaNull();


            } catch (NombreCorrecto | EntradaNull e) {
                System.err.println(e.getMessage());
            }
        } while (!validarNombre(nombreEmpresa) || !InputEmpty(nombreEmpresa));


        do {
            System.out.println("Introducir el CIF de la empresa");
            this.cif = br.readLine();
            try {
                if (!InputEmpty(cif)) throw new EntradaNull();
                if (!validateCIF(cif)) throw new CifInvalido();


            } catch (EntradaNull | CifInvalido in) {
                System.err.println(in.getMessage());
            }
        } while (!InputEmpty(cif) || !validateCIF(cif));

        do {
            System.out.println("Introducir el telefono de la empresa");
            this.numTelfono = br.readLine();
            try {
                if (!InputEmpty(numTelfono)) throw new EntradaNull();
                if (!validaTlf(numTelfono)) throw new TelefonoInvalido();


            } catch (EntradaNull | TelefonoInvalido e) {
                System.err.println(e.getMessage());
            }
        } while (!InputEmpty(numTelfono) || !validaTlf(numTelfono));


        System.out.println("Empresa registrada con existo");
    }

    @Override
    public String toString() {
        return "Empresa->"+nombreEmpresa+" Numero de telefono->"+numTelfono+" CIF->"+cif;
    }
}

