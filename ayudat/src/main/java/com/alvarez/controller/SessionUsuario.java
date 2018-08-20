/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvarez.controller;

import com.alvarez.dao.GrupoUsuarioDao;
import com.alvarez.entidades.GrupoUsuario;
import com.alvarez.entidades.Usuario;
import com.alvarez.excepciones.ConsultarException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class SessionUsuario {

    private static SessionUsuario instance;
    private Usuario usuario;
    private GrupoUsuario grupo;

    public static SessionUsuario getInstace() {
        if (instance == null) {
            instance = new SessionUsuario();
        }
        return instance;
    }

    public String setSessionUsuario(Usuario usuario) {
        try {
            this.usuario = usuario;
            GrupoUsuarioDao daog = new GrupoUsuarioDao();
            grupo = daog.getGrupoByUsuario(usuario);
            if (grupo == null) {
                this.usuario = null;
            }
            return null;
        } catch (ConsultarException ex) {
            return null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public GrupoUsuario getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoUsuario grupo) {
        this.grupo = grupo;
    }

}
