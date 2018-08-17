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
public class Perro extends Animal{
    private final String marca_croquetas;

    public Perro(String nombre, String raza, String tamano, String marca_croquetas) {
        super(nombre, raza, tamano);
        this.marca_croquetas = marca_croquetas;

    }
    @Override
     public void imprimeInformacion(){
        System.out.println("\n**DATOS DEL PERRO***");
        System.out.println("Soy un perro");
        System.out.println("Mi marca de croquetas es: "+marca_croquetas);
    }
    
}
