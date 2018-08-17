/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author bn
 */
public class ComLuisAlvarezUisraelt7Model {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreArchivo = null, pausa = null;
        byte opt = 0;
        do {
            OperacionAS.limpiarPantalla();
            System.out.println("\n\t\t\tMENU-ELECCION");
            System.out.println("\t\tELIJA DE LAS SIGUIENTES OPCIONES");
            System.out.println("1) VERIFICAR ARCHIVO (VER SI EXISTE UN ARCHIVO)");
            System.out.println("2) CREAR ARCHIVO");
            System.out.println("3) INSERTAR REGISTRO A UN ARCHIVO");
            System.out.println("4) CONSULTAR CONTENIDO DEL ARCHIVO");
            System.out.println("5) CONSULTA INDIVIDUAL DE REGISTROS");
            System.out.println("6) SALIR");
            opt = sc.nextByte();
            switch (opt) {
                case 1:
                    System.out.print("Indique el nombre del archivo con su extensiOn a buscar: ");
                    nombreArchivo = sc.next();
                    if (OperacionAS.verificarExistencia(nombreArchivo) == true) {
                        System.out.print("\nYa existe");
                        OperacionAS.pausar();
                    } else {
                        System.out.print("\nNo existe");
                        OperacionAS.pausar();
                    }
                    break;
                case 2:
                    System.out.print("Indique el nombre del archivo con su extensiOn a crear: ");
                    nombreArchivo = sc.next();
                    if (OperacionAS.crearArchivo(nombreArchivo) == true) {
                        System.out.print("\nArchivo ha sido creado satisfactoriamente");
                    }
                    break;
                case 3:
                    System.out.print("Indique el nombre del archivo con su extensiOn en el que insertara datos: ");
                    nombreArchivo = sc.next();
                    if (OperacionAS.solicitudDatos(nombreArchivo) == true) {
                        System.out.print("Los datos han sido insertados satisfactoriamente");
                    }
                    break;
                case 4:
                    System.out.print("Indique el nombre del archivo con su extensiOn a visualizar: ");
                    nombreArchivo = sc.next();
                    OperacionAS.leerDelArchivo(nombreArchivo);
                    OperacionAS.pausar();
                    break;
                case 5:
                    int clave = 0;
                    System.out.print("Indique el nombre del archivo con su extension a visualizar: ");
                    nombreArchivo = sc.next();
                    System.out.print("Indique la clave a buscar: ");
                    clave = sc.nextInt();
                    OperacionAS.consultaIndividual(nombreArchivo, clave);
                    OperacionAS.pausar();
                    break;
            }
        } while (opt != 6);
    }
}
