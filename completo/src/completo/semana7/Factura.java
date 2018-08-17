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
public class Factura {
   private String pvendido;
   private String cvendida;
   private String numeroVenta;
   private String pventa;

    public Factura() {
    }

    public Factura(String pvendido, String cvendida, String numeroVenta, String pventa) {
        this.pvendido = pvendido;
        this.cvendida = cvendida;
        this.numeroVenta = numeroVenta;
        this.pventa = pventa;
    }

    public String getPvendido() {
        return pvendido;
    }

    public void setPvendido(String pvendido) {
        this.pvendido = pvendido;
    }

    public String getCvendida() {
        return cvendida;
    }

    public void setCvendida(String cvendida) {
        this.cvendida = cvendida;
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public String getPventa() {
        return pventa;
    }

    public void setPventa(String pventa) {
        this.pventa = pventa;
    }

    @Override
    public String toString() {
        return "Factura{" + "pvendido=" + pvendido + ", cvendida=" + cvendida + ", numeroVenta=" + numeroVenta + ", pventa=" + pventa + '}';
    }

    
    }
    
    
   

