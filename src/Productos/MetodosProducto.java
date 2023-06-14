package Productos;

import CreacionFicheros.CreateFile;
import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.MayorQueCero;
import Interfaces.Bufferreader;
import Validaciones.Validaciones;

import static Fechas.MetodosFechas.*;
import static Validaciones.Validaciones.validarCodigoAlquiler;

import java.io.File;
import java.io.IOException;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Javier Lago Amoedo
 * @apiNote Clase en la que estan los metodos con las clases ProductoAlquier y productoVenta
 */
public class MetodosProducto implements Bufferreader {

    /**
     * Metodo en el que pasando por parametro un listado de empresas el nombre de una empresa y el codigo del producto
     * permite cambiar su precio por dia
     * @param Listado Listado de empresas ArrayList
     * @param empresa String nombre de la empresa
     * @param codigo codigo del producto que deseamos setear
     * @throws IOException -
     */
    public static void setPrecioDia(ArrayList<Empresa> Listado, String empresa, String codigo) throws IOException {
        String nuevoprecio;

        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                for (Producto producto : e.getListadoProductos()
                ) {
                    if (producto instanceof ProductoAlquiler && producto.getCodigo().compareToIgnoreCase(codigo) == 0) {
                        System.out.println("Introducir nuevo precio de alquiler");
                        do {
                            nuevoprecio = Bufferreader.br.readLine();
                            try {
                                Validaciones.isFloat(nuevoprecio);
                                if (!Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio))) {
                                    throw new MayorQueCero();
                                }

                            } catch (MayorQueCero mqo) {
                                System.err.println(mqo.getMessage());
                            }
                            if (!Validaciones.isFloat(nuevoprecio) || !Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio))) {
                                System.err.println("Debes de intoducir un precio valido");
                            }
                        } while (!Validaciones.isFloat(nuevoprecio) || !Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio)));


                        System.out.println("Se va a cambiar el precio por dia de " + ((ProductoAlquiler) producto).getPrecioDia() + " por " + nuevoprecio);


                        if (Validaciones.repetirProceso("Estas seguro? S-s/N-n")) {
                            ((ProductoAlquiler) producto).setPrecioDia(Float.parseFloat(nuevoprecio));
                            System.out.println("El nuevo precio de el producto con codigo " + producto.getCodigo() + " es de " + ((ProductoAlquiler) producto).getPrecioDia());
                        } else System.err.println("El producto no se ha actualizado");

                    }
                }
            }
        }


    }

    /**
     * Metodo que pasando por parametro el nombre de una empresa y un listado de empresas nos muestra por pantalla un
     * listado de usos que tiene ese producto
     * @param nombreEmpresa String nombre de la empresa
     * @param Listado Listado de empresas ArrayList
     * @throws IOException -
     */
    public static void mostrarUsuos(String nombreEmpresa, ArrayList<Empresa> Listado) throws IOException {
        Empresa emp = null;
        String codigo;
        ProductoAlquiler productoAlquiler = null;
        for (Empresa empresa : Listado
        ) {
            if (empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa) == 0) {
                emp = empresa;
            }

        }
        do {
            System.out.println("Introducir el codigo");
            codigo = Bufferreader.br.readLine();
            if (!validarCodigoAlquiler(codigo))
                System.err.println("Intrduce un codigo valido para alquiler");
        } while (!validarCodigoAlquiler(codigo));


        for (Producto producto : emp.getListadoProductos()
        ) {
            if (producto.getCodigo().compareToIgnoreCase(codigo) == 0) productoAlquiler = (ProductoAlquiler) producto;
        }
        for (Usos usos : productoAlquiler.getListadoUsuos()
        ) {
            System.out.println(usos.toString());

        }
    }

    /**
     * Metodo para mostrar por pantalla los productos de venta que tiene una empresa
     * @param empresa String nombre de la empresa
     * @param Listado Listado de empresas ArrayList
     */
    public static void printearProductosVenta(ArrayList<Empresa> Listado, String empresa) {
        Empresa emp = null;
        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                emp = e;
            }

        }
        for (Producto p : emp.getListadoProductos()
        ) {
            if (p instanceof ProductoVenta) {
                System.out.println(p.mySpecialPrint());
            }

        }


    }

    /**
     * Metodo que verifica que la empresa tiene productos de alquiler.
     * @param empresa Objeto de tipo Empresa
     * @return Devuelve true si tiene productod de alquiler
     */
    public static boolean tieneProductoAlquiler(Empresa empresa) {
        boolean tiene = false;
        for (Producto producto : empresa.getListadoProductos()
        )
            if (producto instanceof ProductoAlquiler) {
                tiene = true;
                break;
            }
        return tiene;
    }

    /**
     * Metodo que verifica que la empresa tiene productos de alquiler libres.
     * @param empresa Objeto de tipo Empresa
     * @return Devuelve true si la empresa tiene productos de alquiler libres
     */
    public static boolean tieneProductoAlquilerLibres(Empresa empresa) {
        boolean tiene = false;
        for (Producto producto : empresa.getListadoProductos()
        )
            if (producto instanceof ProductoAlquiler && ((ProductoAlquiler) producto).getEstado() == 'L') {
                tiene = true;
                break;
            }
        return tiene;
    }

    /**
     * Metodo que verifica que existen productos de alquiler con listado de usos
     * @param empresa Objeto de tipo Empresa
     * @return Devuelve true si tiene un producto con un listado de usos que no esta vacio
     */
    public static boolean tieneProductoAlquilerConUsos(Empresa empresa) {
        boolean tiene = false;
        for (Producto producto : empresa.getListadoProductos()
        )
            if (producto instanceof ProductoAlquiler && !((ProductoAlquiler) producto).getListadoUsuos().isEmpty()) {
                tiene = true;
                break;
            }
        return tiene;
    }

    /**
     * Método que verifica si la empresa tiene productod de venta.
     * @param empresa Objeto de tipo Empresa
     * @return Devuelve true si la empresa contiene productos de venta.
     */
    public static boolean tieneProductoVenta(Empresa empresa) {
        boolean tiene = false;
        for (Producto producto : empresa.getListadoProductos()
        )
            if (producto instanceof ProductoVenta) {
                tiene = true;
                break;
            }
        return tiene;
    }

    /**
     * Metodo que verica la existencia de productos de alquiler en la empresa indicada
     * @param Listado Listado de empresas
     * @param empresa Nombre de la empresa
     */
    public static void printearProductosAlquiler(ArrayList<Empresa> Listado, String empresa) {
        Empresa emp = null;
        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                emp = e;
            }

        }
        for (Producto p : emp.getListadoProductos()
        ) {
            if (p instanceof ProductoAlquiler) {
                System.out.println(p.mySpecialPrint());
            }

        }


    }

    /**
     * Método printea aquello productos que estan libre es una empresa determinada
     * @param Listado Listado de empresa
     * @param empresa nombre de la empresa
     */
    public static void printearProductosAlquilerLibres(ArrayList<Empresa> Listado, String empresa) {
        Empresa emp = null;
        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                emp = e;
            }

        }
        for (Producto p : emp.getListadoProductos()
        ) {
            if (p instanceof ProductoAlquiler && ((ProductoAlquiler) p).getEstado() == 'L') {
                System.out.println(p.mySpecialPrint());
            }

        }


    }

    /**
     * Método de que el codigo existe en una empresa.
     * @param Listado ArrayList de empresa
     * @param empresa nombre de la empresa
     * @param codigo Codigo
     * @return -
     */
    public static boolean codigoVentaExiste(ArrayList<Empresa> Listado, String empresa, String codigo) {
        boolean bandera = false;
        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                for (Producto producto : e.getListadoProductos()
                ) {
                    if (producto instanceof ProductoVenta && producto.getCodigo().compareToIgnoreCase(codigo) == 0) {
                        bandera = true;
                        break;
                    }
                }
            }
        }

        if (!bandera) System.err.println("Debes seleccionar un codigo de la lista");
        return bandera;
    }


    /**
     * Metodo usado para veficar que un codigo de alquiler existe
     * @param Listado ArrayList
     * @param empresa Nombre de empresa
     * @param codigo Cofigo
     * @return Devuelve true si el codigo existe
     */
    public static boolean codigoAlquilerExiste(ArrayList<Empresa> Listado, String empresa, String codigo) {
        boolean bandera = false;
        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                for (Producto producto : e.getListadoProductos()
                ) {
                    if (producto instanceof ProductoAlquiler && producto.getCodigo().compareToIgnoreCase(codigo) == 0) {
                        bandera = true;
                        break;
                    }
                }
            }
        }

        if (!bandera) System.err.println("Debes seleccionar un codigo de la lista");
        return bandera;
    }

    /**
     * Metodo para verifioar si un codigo de un producto de alquiler libre existe
     * @param Listado Listado de empresas
     * @param empresa Nombre de la empresa
     * @param codigo   Codigo que a buscar
     * @return Devuelve true si el codigo existe
     */
    public static boolean codigoAlquilerExisteLibre(ArrayList<Empresa> Listado, String empresa, String codigo) {
        boolean bandera = false;
        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                for (Producto producto : e.getListadoProductos()
                ) {
                    if (producto instanceof ProductoAlquiler && producto.getCodigo().compareToIgnoreCase(codigo) == 0 && ((ProductoAlquiler) producto).getEstado() == 'L') {
                        bandera = true;
                        break;

                    }
                }
            }
        }

        if (!bandera) System.err.println("Debes seleccionar un codigo de la lista");
        return bandera;
    }

    /**
     * Metodo para setear el precio de venta de un producto
     * @param Listado Arraylist de empresas
     * @param empresa Nombre de la empresa
     * @param codigo Codigo de el producto
     * @throws IOException -
     */
    public static void setPrecioVenta(ArrayList<Empresa> Listado, String empresa, String codigo) throws IOException {
        String nuevoprecio;
        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                for (Producto producto : e.getListadoProductos()
                ) {
                    if (producto instanceof ProductoVenta && producto.getCodigo().compareToIgnoreCase(codigo) == 0) {
                        System.out.println("Introducir nuevo precio de venta");
                        do {
                            nuevoprecio = Bufferreader.br.readLine();
                            try {
                                Validaciones.isFloat(nuevoprecio);
                                if (!Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio))) {
                                    throw new MayorQueCero();
                                }

                            } catch (MayorQueCero mqo) {
                                System.err.println(mqo.getMessage());
                            }
                            if (!Validaciones.isFloat(nuevoprecio) || !Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio))) {
                                System.err.println("Debes de intoducir un precio valido");
                            }
                        } while (!Validaciones.isFloat(nuevoprecio) || !Validaciones.floatNoNegativo(Float.parseFloat(nuevoprecio)));


                        System.out.println("Se va a cambiar el precio por venta de " + ((ProductoVenta) producto).getPrecioVenta() + " por " + nuevoprecio);


                        if (Validaciones.repetirProceso("Estas seguro? S-s/N-n")) {
                            ((ProductoVenta) producto).setPrecioVenta(Float.parseFloat(nuevoprecio));
                            System.out.println("El nuevo precio de el producto con codigo " + producto.getCodigo() + " es de " + ((ProductoVenta) producto).getPrecioVenta());

                        } else System.err.println("El producto no se ha actualizado");

                    }

                }

            }
        }
    }

    /**
     * Metodo para borrar un producto de alquiler de una empresa
     * @param Listado ArrayList de empresas
     * @param empresa Nombre de la empresa
     * @param codigo Codigo del producto a borrar
     * @param file Archivo en el que se va a guardar el registro de la eliminaciion del producto
     * @throws IOException -
     */
    public static void borrarUnProducto(ArrayList<Empresa> Listado, String empresa, String codigo, File file) throws IOException {
        Empresa emp = null;

        int num = -1;
        for (Empresa e : Listado
        ) {
            if (e.getNombreEmpresa().compareToIgnoreCase(empresa) == 0) {
                emp = e;
            }
        }
        for (int i = 0; i < emp.getListadoProductos().size(); i++) {
            if (emp.getListadoProductos().get(i) instanceof ProductoAlquiler && emp.getListadoProductos().get(i).getCodigo().compareToIgnoreCase(codigo) == 0) {
                num = i;
                break;
            }
        }

        System.out.println("Se va a eliminar el producto " + emp.getListadoProductos().get(num).mySpecialPrint());

        if (Validaciones.repetirProceso("Estas seguro? S-s/N-n")) {
            String mensaje = "Se ha borrado " + emp.getListadoProductos().get(num).mySpecialPrint();
            System.out.println(mensaje);
            CreateFile.trackInfo(file, mensaje);
            emp.getListadoProductos().remove(num);
        } else System.out.println("El producto no se ha borrado");

    }

    /**
     * Metodo para realizar el alquiler de un producto
     * @param listado ArrayList de empresas
     * @param file Archivo donde se va a guardar el resgistro del alquiler de el producto
     * @throws IOException -
     */
    public static void alquilarProducto(ArrayList<Empresa> listado, File file) throws IOException {
        String nombreEmpresa;
        String codigo;

        do {
            MetodosEmpresa.PrintearEmpresasConProductosLibres(listado);
            nombreEmpresa = br.readLine();
        } while (!MetodosEmpresa.empresaPrroductosLibresExiste(listado, nombreEmpresa));
        do {
            MetodosProducto.printearProductosAlquilerLibres(listado, nombreEmpresa);
            System.out.println("Introduce un codigo de la lista");
            codigo = br.readLine();
        } while (!validarCodigoAlquiler(codigo) && !codigoAlquilerExisteLibre(listado, nombreEmpresa, codigo));

        for (Empresa empresa : listado
        ) {
            if (empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa) == 0) {

                for (Producto producto : empresa.getListadoProductos()
                ) {
                    if (producto instanceof ProductoAlquiler && producto.getCodigo().compareToIgnoreCase(codigo) == 0) {
                        Usos uso = new Usos((ProductoAlquiler) producto);
                        System.out.println("Se va a registrar un alquiler para el producto " + producto.mySpecialPrint());
                        if (Validaciones.repetirProceso("Estas seguro? S-s/N-n")) {
                            ((ProductoAlquiler) producto).getListadoUsuos().add(uso);
                            ((ProductoAlquiler) producto).setEstado('R');
                            String mensje = "Se ha registrado un alquiler en el producto" + producto.mySpecialPrint() + "\nCon las siguientes caracteristicas\n" + uso+ "\n";
                            System.out.println(mensje);
                            CreateFile.trackInfo(file, mensje);
                        } else System.out.println("El producto no se a alquilado");

                    }

                }

            }

        }
    }


    /**
     * Metodo para solicitar un presupuesto pideiendole al usuario el codigo y las dos fechas
     * en las que se desea alquilar el producto
     * @param listado Listado de empresas
     * @param file Archivo en en el que se guarda el registro del alquiler realizado
     * @throws IOException -
     */
   public static void calcularPresupuesto(ArrayList<Empresa> listado, File file) throws IOException {
        String nombreEmpresa;
        String codigo;
        LocalDate fechaIncio, fechaEntrega;
        String fecha;
        do {
            MetodosEmpresa.PrintearEmpresasConProductosLibres(listado);
            nombreEmpresa = br.readLine();
        } while (!MetodosEmpresa.empresaPrroductosLibresExiste(listado, nombreEmpresa));
        do {
            MetodosProducto.printearProductosAlquiler(listado, nombreEmpresa);
            System.out.println("Introduce un codigo de la lista");
            codigo = br.readLine();
        } while (!validarCodigoAlquiler(codigo) && !codigoAlquilerExiste(listado, nombreEmpresa, codigo));
        for (Empresa empresa : listado
        ) {
            if (empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmpresa) == 0) {

                for (Producto producto : empresa.getListadoProductos()
                ) {
                    if (producto instanceof ProductoAlquiler && producto.getCodigo().compareToIgnoreCase(codigo) == 0) {
                        do {
                            System.out.println("Introduzca la fecha de inicio del alquiler");
                            fecha = br.readLine();
                        } while (convertiFecha(fecha) == null || !isAfter(LocalDate.now(), convertiFecha(fecha)));
                        fechaIncio = convertiFecha(fecha);

                        do {
                            System.out.println("Introduzca la fecha de fin del alquiler");
                            fecha = br.readLine();
                        } while (convertiFecha(fecha) == null || !isAfter(fechaIncio, convertiFecha(fecha)));
                        fechaEntrega = convertiFecha(fecha);

                        System.out.println("La empresa " + empresa.getNombreEmpresa() + "\nLe alquilara el producto " + producto.mySpecialPrint() + "\nEntre los dias " + formatearFecha(fechaIncio) +
                                " y " + formatearFecha(fechaEntrega) + " por un valor de " + (calculardias(fechaIncio, fechaEntrega) * ((ProductoAlquiler) producto).precioDia + " Euros"));

                        CreateFile.trackInfo(file, "Se ha calculado un presupuesto para el productos->" + producto.mySpecialPrint() +
                                "con un presupuesto de " + (calculardias(fechaIncio, fechaEntrega) * ((ProductoAlquiler) producto).precioDia +
                                "para la Empresa->" + empresa.getNombreEmpresa()));


                    }

                }

            }

        }

    }
}
