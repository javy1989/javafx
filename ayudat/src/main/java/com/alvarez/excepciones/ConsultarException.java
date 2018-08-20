/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.excepciones;

/**
 *
 * @author USUARIO
 */
public class ConsultarException extends Exception {

    public ConsultarException(String message) {
        super(message);
    }

    public ConsultarException(String message, Throwable cause) {
        super(message, cause);
    }

}
