/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana10.model;

import java.util.Date;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class Factura {

    private int id_factura;
    private int id_usuario;
    private Usuario usuario;
    private String codigo;
    private Date fecha;

    public Factura() {
    }

    public Factura(int id_factura, int id_usuario, Date fecha) {
        this.id_factura = id_factura;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Factura{" + "id_factura=" + id_factura + ", id_usuario=" + id_usuario + ", codigo=" + codigo + ", fecha=" + fecha + '}';
    }

}