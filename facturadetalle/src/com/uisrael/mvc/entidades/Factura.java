/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.mvc.entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class Factura {

    private int id_factura;
    private Usuario usuario;
    private String codigo;
    private Date fecha;
    private BigDecimal total;

    public Factura() {
    }

    public Factura(Usuario usuario) {
        this.usuario = usuario;
    }

    public Factura(int id_factura, Date fecha) {
        this.id_factura = id_factura;
        this.fecha = fecha;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return codigo;
    }

}
