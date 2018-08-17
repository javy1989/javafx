/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana2.encapsulacion;

/**
 *
 * @author User
 */
public class DeberProgra_Alvarez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ENCAPSULAMIENTO
        ejemplo_encapsu enc=new ejemplo_encapsu();
        enc.imprimePregunta();
        System.out.println("\n ***PUNTAJE FINAL***");
        System.out.println("Tu puntaje final es: "+enc.puntaje );
         
        
    }
    
}
