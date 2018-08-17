/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Robert
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        HashMap<Integer, String> lista_agenda = new HashMap<>();
        Scanner lector = new Scanner(System.in);
        int op = 0;
        int codigo;
        String nombre;

        while (op != 5) {
            System.out.println("---------------------------------------- ");
            System.out.println("Escoger una opcion: ");
            System.out.println("1.AGREGAR CONTACTO DE LA AGENDA: ");
            System.out.println("2.MODIFICAR EL CONTACTO DE LA AGENDA: ");
            System.out.println("3.MOSTRAR EL CONTACTO DE LA AGENDA: ");
            System.out.println("4.ELIMINAR EL CONTACTO DE LA AGENDA: ");
            System.out.println("5.SALIR: ");
            
            op = lector.nextInt();

            switch (op) {

                case 1:
                    System.out.println("INTRODUZCA EL NUMERO DE FONO DEL CONTACTO ");
                    codigo = lector.nextInt();
                    System.out.println("NOMBRE CONTACTO: ");
                    nombre = lector.next();
                    registrarAgenda(codigo, nombre, lista_agenda);
                    break;

                case 2:
                    System.out.println("INTRODUZCA LA INFORMACION DEL CONTACTO A MODIFICAR");
                    codigo = lector.nextInt();
                    modificar(codigo, lista_agenda);
                    break;

                case 3:
                    mostrarAgenda(lista_agenda);

                    break;

                case 4:
                    System.out.println("INTRODUZCA EL CONTACTO A ELIMINAR");
                    codigo = lector.nextInt();
                    eliminar(codigo, lista_agenda);
                    break;

                case 5:
                    break;
                default:
                    System.out.println("ESCOGA UNA OPCION VALIDA -ERROR");
                    break;

            }

        }

    }

    private static void registrarAgenda(int cod, String nombre, HashMap<Integer, String> lista_agendado) {

        if (lista_agendado.containsKey(cod)) {
            System.out.println("no se puede registarar,existe ya este codigo");

        } else {

            lista_agendado.put(cod, nombre);

        }
    }

    private static void modificar(int cod, HashMap<Integer, String> lista_agendado) {

        Scanner lectura = new Scanner(System.in);
        if (lista_agendado.containsKey(cod)) {
            System.out.println("NOMBRE DEL CONTACTO: ");
            lista_agendado.put(cod, lectura.next());
        } else {
            System.out.println("NO HAY NINGUN CONTACTO CON ESTE CODIGO");
        }

    }

    private static void mostrarAgenda(HashMap<Integer, String> lista_agendado) {

        int clave;
        Iterator<Integer> alumnos = lista_agendado.keySet().iterator();
        System.out.println("LISTA DE CONTACTOS");
        while (alumnos.hasNext()) {
            clave = alumnos.next();
             System.out.println("DATOS AGENDA:");
             System.out.println("*************");
            System.out.println("FONO" + ":" +clave + "-" + "CONTACTO" + ":" +lista_agendado.get(clave));

        }

    }

    private static void eliminar(int cod, HashMap<Integer, String> lista_agendado) {

        if (lista_agendado.containsKey(cod)) {
            lista_agendado.remove(cod);
        } else {

            System.out.println("ERROR NO EXISTE");
        }
    }

}
