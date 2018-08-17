/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana3;

/**
 *
 * @author HP
 */
public class Tarea3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("\t\t\t TAREA - SEMANA 3 ");
        System.out.println("\t Clases, Objetos, polimorfismo, encapsulación, abstracción,etc ");
        System.out.println("\n\n Lista de Instrumentos Musicales \n");
        
        Guitarra g1 = new Guitarra("Ibanez", "331A", "Rojo", "2000", " ");
        g1.obtenerInstrumento();
        
        Bajo b1 = new Bajo("Yamaha", "B90", "Blanco", "2017", " ");
        b1.obtenerInstrumento();
        
        Bateria bt1 = new Bateria("Dream Star", "Jazz Drum", "Negro", "2015", " ");
        bt1.obtenerInstrumento();
        
        Saxofon s1 = new Saxofon("La Lira", "33K", "Dorado", "201", " ");
        s1.obtenerInstrumento();
        
    }
    
}
