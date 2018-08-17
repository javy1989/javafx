/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana2.abstraccion;

/**
 *
 * @author User
 */
public class Gato extends Animal {

    private final String marca_croquetas;

    public Gato(String nombre, String raza, String tamano, String marca_croquetas) {
        super(nombre, raza, tamano);
        this.marca_croquetas = marca_croquetas;
    }

    public void imprimeMarcaCroquetas() {
        System.out.println("La marca de croquetas son: " + marca_croquetas);
    }

}
