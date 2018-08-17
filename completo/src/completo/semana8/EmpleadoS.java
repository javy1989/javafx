/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana8;

import java.io.Serializable;

/**
 *
 * @author Rudolf
 */
public class EmpleadoS implements  Serializable{
    private String nombre, apellido, cedula;
    private Integer anio;

    public EmpleadoS() {
    }


    public EmpleadoS(String nombre, String apellido, String cedula, Integer anio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }
    
    

    @Override
    public String toString() {
        return "EmpleadoS{" + "nombre=" + nombre + ", apellido=" + apellido + ", anio=" + anio + ", cedula=" + cedula+ '}';
    } 
}
