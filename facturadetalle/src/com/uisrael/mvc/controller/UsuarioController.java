/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.mvc.controller;

import com.uisrael.mvc.daoImpl.DaoUsuario;
import com.uisrael.mvc.entidades.Usuario;
import java.util.List;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class UsuarioController {

    private static DaoUsuario usuarioDao;
    private static UsuarioController instace;

    public static UsuarioController getInstace() {
        if (instace == null) {
            instace = new UsuarioController();
            usuarioDao = DaoUsuario.getInstance();
        }
        return instace;
    }

    public List<Usuario> getUsuario() {
        List<Usuario> tmp = usuarioDao.obtenerUsuarios();
        if (tmp != null) {
            return tmp;
        } else {
            return null;
        }
    }

    public boolean guardar(Usuario usuario) throws Exception {
        return usuarioDao.registrarUsuario(usuario);
    }

    public Usuario getUsuarioFindByDocumento(String documento) {
        return usuarioDao.buscarFindByDocumento(documento);
    }

    public Usuario getUsuarioFindById(int id) {
        return usuarioDao.buscarFindById(id);
    }

    public boolean editar(Usuario usuario) throws Exception {
        return usuarioDao.editarUsuario(usuario);
    }

    public boolean eliminar(Usuario usuario) throws Exception {
        return usuarioDao.eliminarUsuario(usuario);
    }
}
