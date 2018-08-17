/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.mvc.daoImpl;

import com.uisrael.mvc.entidades.Conexion;
import com.uisrael.mvc.entidades.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class DaoUsuario {

    private static DaoUsuario instance;

    public static DaoUsuario getInstance() {
        if (instance == null) {
            instance = new DaoUsuario();
        }
        return instance;
    }

    public boolean registrarUsuario(Usuario usuario) throws Exception {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql4 = "INSERT INTO public.usuario(documento,nombre,apellido, "
                + "direccion, telefono) values "
                + "('" + usuario.getDocumento() + "','" + usuario.getNombre() + "','"
                + usuario.getApellido() + "','" + usuario.getDireccion() + "','" + usuario.getTelefono() + "')";

        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql4);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DaoUsuario, método registrar" + e);
            throw new Exception("Error", e);
        }
        return registrar;
    }

    
    public boolean editarUsuario(Usuario usuario) throws Exception {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql4 = "update usuario set documento='" + usuario.getDocumento() + "',apellido='" + usuario.getApellido() + "',direccion='" + usuario.getDireccion() + "',telefono='" + usuario.getTelefono() + "',nombre='" + usuario.getNombre() + "' where id_usuario=" + usuario.getId_usuario();
        System.out.println(sql4);
        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql4);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DaoUsuario, método registrar" + e);
            throw new Exception("Error", e);
        }
        return registrar;
    }

     public boolean eliminarUsuario(Usuario usuario) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql3 = "delete from usuario where id_usuario=" + usuario.getId_usuario();
        System.out.println(sql3);

        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql3);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método registrar" + e);
        }
        return registrar;
    }

    /**
     * meotodo para buscar usaurio por documento
     *
     * @param documento
     * @return
     */
    public Usuario buscarFindByDocumento(String documento) {

        Statement stm = null;
        Connection co = null;
        ResultSet rs = null;
        String sql4 = "select * from Usuario where documento='" + documento + "'";
        int id;
        Usuario usu = null;

        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql4);

            while (rs.next()) {
                usu = new Usuario();
                usu.setId_usuario(rs.getInt(1));
                usu.setDocumento(rs.getString("documento"));
                usu.setNombre(rs.getString(3));
                usu.setApellido(rs.getString(4));
                usu.setDireccion(rs.getString(5));
                usu.setTelefono(rs.getString(6));
            }
            stm.close();
            co.close();
            return usu;
        } catch (SQLException e) {
            System.out.println("Error: Clase DaoUsuario, método registrar" + e);
            return null;
        }
    }

    public List<Usuario> obtenerUsuarios() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql12 = "SELECT * FROM public.usuario ORDER BY id_usuario";
        List<Usuario> listaUsuario = new ArrayList<>();

        Usuario usu;
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql12);
            while (rs.next()) {
                usu = new Usuario();
                usu.setId_usuario(rs.getInt(1));
                usu.setNombre(rs.getString(2));
                usu.setApellido(rs.getString(3));
                usu.setDireccion(rs.getString(4));
                usu.setTelefono(rs.getString(5));
                listaUsuario.add(usu);
            }
            stm.close();
            rs.close();
            co.close();
            return listaUsuario;
        } catch (SQLException e) {
            System.out.println("Error: Clase DaoUsuario, método obtener" + e);
            return null;
        }

    }

    public Usuario buscarFindById(int id) {

        Statement stm = null;
        Connection co = null;
        ResultSet rs = null;
        String sql4 = "select * from Usuario where id_usuario=" + id;
        Usuario usu = null;

        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql4);

            while (rs.next()) {
                usu = new Usuario();
                usu.setId_usuario(rs.getInt(1));
                usu.setDocumento(rs.getString("documento"));
                usu.setNombre(rs.getString(3));
                usu.setApellido(rs.getString(4));
                usu.setDireccion(rs.getString(5));
                usu.setTelefono(rs.getString(6));
            }
            stm.close();
            co.close();
            return usu;
        } catch (SQLException e) {
            System.out.println("Error: Clase DaoUsuario, método registrar" + e);
            return null;
        }
    }
}