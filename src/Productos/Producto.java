package Productos;

public abstract class Producto {

    public Producto(){

    }


    Producto( String marca, String modelo, String nombreEmpresa) {

        this.marca = marca;
        this.modelo = modelo;
        numeroCodigo++;
    }


    static int numeroCodigo=000;
    String codigo,marca,modelo,cif;
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }



}
