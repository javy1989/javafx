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
public class Detalle extends Empleado{
    private String descripcionV;
    private String empresa;
    private String ruc;
    private String fecha;

    public Detalle() {
    }

    public Detalle(String descripcionV, String empresa, String ruc, String fecha, String nombre, String apellido, String cedula, String pvendido, String cvendida, String numeroVenta, String pventa, int clave) {
        super(nombre, apellido, cedula, pvendido, cvendida, numeroVenta, pventa, clave);
        this.descripcionV = descripcionV;
        this.empresa = empresa;
        this.ruc = ruc;
        this.fecha = fecha;
    }

    public String getDescripcionV() {
        return descripcionV;
    }

    public void setDescripcionV(String descripcionV) {
        this.descripcionV = descripcionV;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Detalle{" + "descripcionV=" + descripcionV + ", empresa=" + empresa + ", ruc=" + ruc + ", fecha=" + fecha + '}';
    }

   
    
}
