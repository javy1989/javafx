/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.mvc.entidades;

import java.math.BigDecimal;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class Detalle {

    private int id_detalle;
    private Factura factura;
    private BigDecimal valor;
    private String producto;
    private int cantidad;

    public Detalle() {
    }

    public Detalle(Factura factura) {
        this.factura = factura;
    }

    public Detalle(int id_detalle, BigDecimal valor, String producto, int cantidad) {
        this.id_detalle = id_detalle;
        this.valor = valor;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return producto;
    }

}
