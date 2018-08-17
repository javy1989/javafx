/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana7;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bn
 */
public class OperacionAS {
    
    public static boolean verificarExistencia(String nombreArchivo) {
        boolean resul = false;
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            return true;
        }
        return resul;
    }

   
    public static boolean crearArchivo(String nombreArchivo) {

        try {
            File archivo = new File(nombreArchivo);
            archivo.createNewFile();
            return true;
        } catch (IOException ex) {
            System.out.print("Ocurrio un error al crear el archivo\n" + ex.getMessage());
            return false;
        }
    }

    public static boolean insertarDatos(String nombreArchivo, Detalle detalle) {
        try {
            
            FileOutputStream fileOS = new FileOutputStream(nombreArchivo, true);
            DataOutputStream dataAFile = new DataOutputStream(fileOS);
            
            if (consultaExiste(nombreArchivo, detalle.getClave())) {
                System.out.println("Ya existe Clave - La clave es unica");
                return false;
            } else {
                dataAFile.writeInt(detalle.getClave());
                dataAFile.writeUTF(detalle.getCedula());
                dataAFile.writeUTF(detalle.getNombre()+ "_" + detalle.getApellido());
                dataAFile.writeUTF(detalle.getPvendido());
                dataAFile.writeUTF(detalle.getPventa());
                dataAFile.writeUTF(detalle.getNumeroVenta());
                dataAFile.writeUTF(detalle.getCvendida());
                dataAFile.writeUTF(detalle.getDescripcionV());
                dataAFile.writeUTF(detalle.getEmpresa());
                dataAFile.writeUTF(detalle.getFecha());

                return true;
            }
        } catch (IOException ex) {
            System.out.print("\nOcurrio una falla al ingresar los datos al archivo\n");
            return false;
        }
    }

    public static void leerDelArchivo(String nombreArchivo) {
        try {
            
            FileInputStream fileIS = new FileInputStream(nombreArchivo);
            DataInputStream dataDFile = new DataInputStream(fileIS);
          
            try {
                do {
                    System.out.print("\n" + dataDFile.readInt());
                    System.out.print("\n" + dataDFile.readUTF());
                    System.out.print("\n" + dataDFile.readUTF());
                    System.out.print("\n" + dataDFile.readUTF());
                    System.out.print("\n" + dataDFile.readUTF());
                    System.out.print("\n" + dataDFile.readUTF());
                    System.out.print("\n" + dataDFile.readUTF());
                    System.out.print("\n" + dataDFile.readUTF());
                    System.out.print("\n" + dataDFile.readUTF());
                    System.out.print("\n" + dataDFile.readUTF());
                } while (dataDFile.available() != 0);   //true
            } catch (EOFException f) {
                System.out.print("\nAlgún error de archivos: " + f);
            }
        } catch (IOException extraccion) {
            System.out.print("\nOcurrio falla al extraer los datos del archivo");
        }
    }

    public static void consultaIndividual(String nombreArchivo, int clave) {
        int cve = 0;
        String cedula = null;
        String nombre = null;
        String apellido = null;
        String pvendido = null;
        String cvendida = null;
        String numeroVenta = null;
        String pventa = null;
        String descripcionV = null;
        String empresa = null;
        String fecha = null;
        
        byte edad = 0;
        float estatura = 0.0f;
        try {
            FileInputStream in = new FileInputStream(nombreArchivo);
            DataInputStream Din = new DataInputStream(in);
            try {
                do {
                    cve = Din.readInt();
                    cedula = Din.readUTF();
                    nombre = Din.readUTF();
                    apellido = Din.readUTF();
                    pvendido = Din.readUTF();
                    pventa = Din.readUTF();
                    numeroVenta = Din.readUTF();
                    cvendida = Din.readUTF();
                    descripcionV = Din.readUTF();
                    empresa = Din.readUTF();
                    fecha = Din.readUTF();
                   
                    if (cve == clave) {
                        System.out.print("\nClave registrada es:  " + cve);
                        System.out.print("\nCedula registrada es: " + cedula);
                        System.out.print("\nNombre registrado es:   " + nombre);
                        System.out.print("\nApellido registrado es:    " + apellido);
                        System.out.print("\nProducto vendido registrado es:  " + pvendido);
                        System.out.print("\nPrecio de venta registrado es: " + pventa);
                        System.out.print("\nNumero de venta registrado es:   " + numeroVenta);
                        System.out.print("\nCantidad vendida registrada es:    " + cvendida);
                        System.out.print("\nDescripcion registrado es:   " + descripcionV);
                        System.out.print("\nEmpresa registrada es:    " + empresa);
                        System.out.print("\nFecha registrada es:    " + fecha);
                        
                        
                        
                    }
                } while (cve != clave);
            } catch (EOFException f) {
                System.out.print("La clave buscada no se encuenstra en el archivo\n");
            }
        } catch (IOException Entrada) {
            System.out.print("\nOcurrio una falla al extraer los datos del archivo\n");
        }
    }

    public static boolean consultaExiste(String nombreArchivo, int clave) {
        int cve = 0;
        String nombre = null;
        String apellido = null;
        String NumeroVenta = null;
        boolean existe = false;
        try {
            FileInputStream in = new FileInputStream(nombreArchivo);
            DataInputStream Din = new DataInputStream(in);
            try {
                do {
                    cve = Din.readInt();
                    nombre = Din.readUTF();
                    apellido = Din.readUTF();
                    NumeroVenta = Din.readUTF();
                    if (cve == clave) {
                        existe = true;
                    }
                } while (cve != clave);
            } catch (EOFException f) {
             
                existe = false;
            }

        } catch (IOException Entrada) {
            System.out.print("\nOcurrio una falla al extraer los datos del archivo\n");
        }
        return existe;
    }

    public static boolean solicitudDatos(String nombreArchivo) {
        Scanner sc = new Scanner(System.in);
        String cedula = null;
        String nombre = null;
        String apellido = null;
        String pvendido = null;
        String pventa = null;
        String NumeroVenta = null;
        String cvendida = null;
        String descripcionV = null;
        String empresa = null;
        String fecha = null;
        Detalle facturanueva= new Detalle();
        
   
        
        System.out.print("\nIndique la clave: ");
        facturanueva.setClave(sc.nextInt());
        
        System.out.print("\nIndique cedula: ");
        cedula = sc.nextLine();
        facturanueva.setCedula(cedula);
        System.out.print("\nIndique nombre: ");
        nombre = sc.nextLine();
        facturanueva.setNombre(nombre);
        System.out.print("\nIndique apellido: ");
        apellido = sc.nextLine();
        facturanueva.setApellido(apellido);
        System.out.print("\nIndique producto vendido: ");
        pvendido = sc.nextLine();
        facturanueva.setPvendido(pvendido);
        System.out.print("\nIndique precio de venta: ");
        pventa = sc.nextLine();
        facturanueva.setPventa(pventa);
        System.out.print("\nIndique numero de venta: ");
        NumeroVenta = sc.nextLine();
        facturanueva.setNumeroVenta(NumeroVenta);
        System.out.print("\nIndique cantidad vendida: ");
        cvendida = sc.nextLine();
        facturanueva.setCvendida(cvendida);
        System.out.print("\nIndique descripcion de producto: ");
        descripcionV = sc.nextLine();
        facturanueva.setDescripcionV(descripcionV);
        System.out.print("\nIndique empresa: ");
        empresa = sc.nextLine();
        facturanueva.setEmpresa(empresa);
        System.out.print("\nIndique fecha: ");
        fecha = sc.nextLine();
        facturanueva.setFecha(fecha);
        if (insertarDatos(nombreArchivo, facturanueva) == true) {
            return true;
        } else {
            return false;
        }
    }

    public final static void limpiarPantalla() {

        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
        }

    }

    public final static void pausar() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
