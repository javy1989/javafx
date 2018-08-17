/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana2.polimorfismo;

/**
 *
 * @author User
 */
public class DeberProgra_AlvarezPolimorfismo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Animal an;
       
       an= new Animal("Luca", "Desconocido", "Grande");
       an.imprimeInformacion();
       an.imprimeDatos();
       
       an= new Perro("Tobi", "Fresh Poodle", "Pequeño","procan");
       an.imprimeInformacion();
       an.imprimeDatos();
       
       an= new Gato("Copito", "Persa", "Pequeño","Wiskas");
       an.imprimeInformacion();
       an.imprimeDatos();
       
       
    }
    
}
