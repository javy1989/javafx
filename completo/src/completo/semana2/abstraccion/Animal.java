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
public class Animal {

    protected String nombre, raza, tamano;
    private final String tipo;

    public Animal(String nombre, String raza, String tamano) {
        this.nombre = nombre;
        this.raza = raza;
        this.tamano = tamano;
        this.tipo = "Terreste";
    }

    public void imprimeDatos() {
        System.out.println("El nombre es:" + nombre);
        System.out.println("La raza es:" + raza);
        System.out.println("El tamaño es:" + tamano);
        System.out.println("El tipo es:" + tipo);
    }

}
