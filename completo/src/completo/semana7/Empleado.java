/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana7;

/**
 *
 * @author bn
 */
public class Empleado extends Factura{
    private String nombre;
    private String apellido;
    private String cedula;
    private int clave;

    public Empleado(String nombre, String apellido, String cedula, String pvendido, String cvendida, String numeroVenta, String pventa, int clave) {
        super(pvendido, cvendida, numeroVenta, pventa);
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.clave = clave;
        
    }

    public Empleado() {
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

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", clave=" + clave + '}';
    }
 
    }

    

