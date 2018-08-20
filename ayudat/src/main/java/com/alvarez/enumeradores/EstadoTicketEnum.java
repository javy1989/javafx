/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.enumeradores;

/**
 *
 * @author USUARIO
 */
public enum EstadoTicketEnum {
 
    CR("Creado"),
    AN("Anulado"),
    AT("Atendido"),
    ES("Espera");
    private final String valor;

    private EstadoTicketEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    
}
