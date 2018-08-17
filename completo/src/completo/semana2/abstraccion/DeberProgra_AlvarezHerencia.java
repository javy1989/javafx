/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana2.abstraccion;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class DeberProgra_AlvarezHerencia {

   private static String nombre;
   private static String raza;
   private static String tamano;
   private static String marca_croquetas;
   
   
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        System.out.println("Nombre del perro ");
        nombre= teclado.nextLine();
        System.out.println("Raza del perro ");
        raza= teclado.nextLine();
         System.out.println("Tamaño del perro ");
        tamano= teclado.nextLine();
        System.out.println("Marca de croquetas del perro ");
        marca_croquetas= teclado.nextLine();
        Perro p= new Perro(nombre, raza, tamano, marca_croquetas);
        p.imprimeDatos();
        p.imprimeMarcaCroquetas();
        
      
        System.out.println("Nombre del gato ");
        nombre= teclado.nextLine();
        System.out.println("Raza del gato ");
        raza= teclado.nextLine();
         System.out.println("Tamaño del gato ");
        tamano= teclado.nextLine();
        System.out.println("Marca de croquetas del gato ");
        marca_croquetas= teclado.nextLine();
        Gato g= new Gato(nombre, raza, tamano, marca_croquetas);
        g.imprimeDatos();
        g.imprimeMarcaCroquetas();
        
    }
    
}
