package Productos;

import CreacionFicheros.CreateFile;
import EmpresaColeccion.Empresa;
import EmpresaColeccion.MetodosEmpresa;
import Excepciones.MayorQueCero;
import Fechas.MetodosFechas;
import Interfaces.Bufferreader;
import Validaciones.Validaciones;
import static Fechas.MetodosFechas.*;
import static Validaciones.Validaciones.validarCodigoAlquiler;

import java.io.File;
import java.io.IOException;

import java.time.LocalDate;
import java.util.ArrayList;

public class MetodosProducto implements Bufferreader {


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
                            System.out.println("El nuevo precio de el producto con codigo " + producto.getCodigo() + "es de " + ((ProductoAlquiler) producto).getPrecioDia());
                        } else System.err.println("El producto no se ha actualizado");

                    }
                }
            }
        }


    }

    public static void mostrarUsuos(String nombreEmoresa, ArrayList<Empresa> Listado) throws IOException {
        Empresa emp = null;
        String codigo;
        ProductoAlquiler productoAlquiler = null;
        for (Empresa empresa : Listado
        ) {
            if (empresa.getNombreEmpresa().compareToIgnoreCase(nombreEmoresa) == 0) {
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


                        System.out.println("Se va a cambiar el precio por dia de " + ((ProductoVenta) producto).getPrecioVenta() + " por " + nuevoprecio);


                        if (Validaciones.repetirProceso("Estas seguro? S-s/N-n")) {
                            ((ProductoVenta) producto).setPrecioVenta(Float.parseFloat(nuevoprecio));
                            System.out.println("El nuevo precio de el producto con codigo " + producto.getCodigo() + "es de " + ((ProductoVenta) producto).getPrecioVenta());

                        } else System.err.println("El producto no se ha actualizado");

                    }

                }

            }
        }
    }


    public static void borrarUnProducto(ArrayList<Empresa> Listado, String empresa, String codigo,File file) throws IOException {
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
            String mensaje="Se ha borrado " + emp.getListadoProductos().get(num).mySpecialPrint();
            System.out.println(mensaje);
            CreateFile.trackInfo(file,mensaje);
            emp.getListadoProductos().remove(num);
        } else System.out.println("El producto no se ha borrado");

    }


    public static void alquilarProducto(ArrayList<Empresa> listado, File file) throws IOException {
        String nombreEmpresa;
        String codigo;
       /* Primero se verifica el nombre de la empresa(solo se muestran empresas
       que tienen productos en alquiler y que esten libres)
       y tambien se muestran los codigos de los productos
       que estan libres */
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
                            String mensje="Se ha registrado un alquiler en el producto" + producto.mySpecialPrint() + "\nCon las siguientes caracteristicas\n" + uso.toString() + "\n";
                            System.out.println(mensje);
                            CreateFile.trackInfo(file,mensje);
                        } else System.out.println("El producto no se a alquilado");

                    }

                }

            }

        }
    }

    public static void calcularPresupuesto(ArrayList<Empresa> listado,File file) throws IOException {
        String nombreEmpresa;
        String codigo;
        LocalDate fechaIncio,fechaEntrega;
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
                     do{
                         System.out.println("Introduzca la fecha de inicio del alquiler");
                            fecha=br.readLine();
                     }while (convertiFecha(fecha)==null);
                     fechaIncio=convertiFecha(fecha);

                     do{
                     do{
                         System.out.println("Introduzca la fecha en la que desea realizar la entrega");
                         fecha=br.readLine();
                        }while (convertiFecha(fecha)==null);
                        fechaEntrega= convertiFecha(fecha);
                        if(fechaEntrega.isBefore(fechaIncio)) System.err.println("Introduzca una fecha posterior a la fecha de inicio");
                     }while(fechaEntrega.isBefore(fechaIncio));


                        System.out.println("La empresa "+empresa.getNombreEmpresa()+"\nLe alquilara el producto "+producto.mySpecialPrint()+"\nEntre los dias "+formatearFecha(fechaIncio)+
                                " y "+formatearFecha(fechaEntrega)+" por un valor de "+(calculardias(fechaIncio,fechaEntrega)* ((ProductoAlquiler) producto).precioDia+" Euros"));

                                CreateFile.trackInfo(file,"Se ha calculado un presupuesto para el productos->"+producto.mySpecialPrint()+
                                        "con un presupuesto de "+(calculardias(fechaIncio,fechaEntrega)* ((ProductoAlquiler) producto).precioDia+
                                        "para la Empresa->"+empresa.getNombreEmpresa()));




                    }

                }

            }

        }

    }
}
