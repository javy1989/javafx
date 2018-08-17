/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo
 */
public class Diccionario {

    static HashMap<String, String> diccionario;
    static Scanner lector;
    private static String palabra;

    public static void main(String[] args) {
        try {
            initDiccionario();
            int opcion = 0;
            lector = new Scanner(System.in);
            while (opcion != 2) {
                mostrarMenu();
                opcion = lector.nextInt();
                switch (opcion) {
                    case 1:
                        buscarPalabra();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("No existe opcion");
                        break;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
        inicializador de map diccionario
     */
    private static void initDiccionario() {
        diccionario = new HashMap<>();
        diccionario.put("ordenador", "computer");
        diccionario.put("gato", "cat");
        diccionario.put("rojo", "red");
        diccionario.put("arbol", "tree");
        diccionario.put("pingüino", "penguin");
        diccionario.put("sol", "sun");
        diccionario.put("agua", "water");
        diccionario.put("viento", "wind");
        diccionario.put("siesta", "siesta");
        diccionario.put("arriba", "up");
        diccionario.put("raton", "mouse");
        diccionario.put("estadio", "arena");
        diccionario.put("calumnia", "aspersion");
        diccionario.put("aguacate", "avocado");
        diccionario.put("cuerpo", "body");
        diccionario.put("concurso", "contest");
        diccionario.put("cena", "dinner");
        diccionario.put("salida", "exit");
        diccionario.put("lenteja", "lentil");
        diccionario.put("cacerola", "pan");
        diccionario.put("pastel", "pie");
        diccionario.put("membrillo", "quince");
    }

    private static void mostrarMenu() throws IOException {
        System.out.println("***BIENVENIDO AL DICCIONARIO");
        System.out.println("Escoger la opcion:");
        System.out.println("1.Buscar palabra: ");
        System.out.println("2.Salir: ");

    }

    private static void buscarPalabra() {
        System.out.println("Ingrese la palabra:");
        lector = new Scanner(System.in);
        String palabraIn;
        palabraIn = lector.nextLine();
        if (!palabraIn.trim().isEmpty()) {
            palabra = buscarPalabra(palabraIn);
            if (palabra.isEmpty()) {
                System.out.println("Palabra no existe");
            } else {
                System.out.println("La respuesta es:" + palabra);
            }
        } else {
            System.out.println("No se admiten espacios");
            buscarPalabra();
        }

    }

    private static String buscarPalabra(String palabra) {
        if (diccionario.containsKey(palabra.trim())) {
            return diccionario.get(palabra.trim());
        }
        return "";
    }
}
