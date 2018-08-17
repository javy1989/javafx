/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana9.model;

import java.math.BigDecimal;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class Detalle {

    private int id_detalle;
    private int id_factura;
    private Factura factura;
    private BigDecimal valor;
    private String producto;
    private int cantidad;
    private BigDecimal precioTotal;

    public Detalle() {
    }

    public Detalle(int id_detalle, int id_factura, BigDecimal valor, String producto, int cantidad, BigDecimal precioTotal) {
        this.id_detalle = id_detalle;
        this.id_factura = id_factura;
        this.valor = valor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;

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

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
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

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Detalle{" + "id_detalle" + id_detalle + ", id_factura=" + id_factura + ", valor=" + valor + ", producto=" + producto + ", cantidad=" + cantidad + ",precioTotal=" + precioTotal + '}';
    }

}
