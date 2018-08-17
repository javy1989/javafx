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
public class Instrumento {
    
    String marca;
    String modelo;
    String color;
    String tipo;
    double costo;
    String  fecha_instrumento;

    public Instrumento(String marca, String modelo, String color, String fecha_instrumento, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fecha_instrumento= fecha_instrumento;
        this.tipo = tipo;
    }
    
    
    
    public void obtenerInstrumento() {
        System.out.println("Instrumento: "+this.tipo+" "+this.marca+" "+this.modelo+" "+this.color+" "+this.fecha_instrumento);
    }
    
}
