/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana6;

/**
 *
 * @author bn
 */
public class Persona extends Factura{
    private String nombre;
    private String apellido;
    private String cedula;

    public Persona(String nombre, String apellido, String cedula, String pvendido, String cvendida, String numeroVenta, String pventa) {
        super(pvendido, cvendida, numeroVenta, pventa);
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public Persona() {
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

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + '}';
    }


    
    

    }

    

