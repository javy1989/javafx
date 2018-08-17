/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.mvc.daoImpl;

import com.uisrael.mvc.entidades.Conexion;
import com.uisrael.mvc.entidades.Factura;
import com.uisrael.mvc.entidades.Usuario;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class DaoFactura {

    private static DaoFactura instace;

    public static DaoFactura getInstace() {
        if (instace == null) {
            instace = new DaoFactura();
        }
        return instace;
    }

    public boolean registrarFactura(Factura factura) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formato.format(factura.getFecha());
        String sql3 = "INSERT INTO public.Factura(id_usuario, "
                + "codigo, fecha,total) values "
                + "(" + factura.getUsuario().getId_usuario() + ",'"
                + factura.getCodigo() + "','" + fecha + "'," + factura.getTotal() + ")";
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

    public boolean editarFactura(Factura factura) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql3 = "update factura set total=" + factura.getTotal() + "where id_factura=" + factura.getId_factura();
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

    public boolean eliminarFactura(Factura factura) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql3 = "delete from factura where id_factura=" + factura.getId_factura();
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

    /*metodo para buscar factura por codig
     * 
     * @param codigo
     * @return 
     */
    public Factura facturaFindByCodigo(String codigo) {
        Statement stm = null;
        Connection co = null;
        ResultSet rs = null;
        String sql4 = "select * from Factura where codigo='" + codigo + "'";
        int id;
        Factura factura = null;

        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql4);

            while (rs.next()) {
                factura = new Factura(new Usuario());
                factura.setId_factura(rs.getInt("id_factura"));
                factura.setCodigo(rs.getString("codigo"));
                factura.setFecha(rs.getDate("fecha"));
                factura.getUsuario().setId_usuario(rs.getInt("id_usuario"));
            }
            stm.close();
            co.close();

            return factura;
        } catch (SQLException e) {
            System.out.println("Error: Clase DaoUsuario, método registrar" + e);
            return null;
        }
    }

    public List<Factura> obtenerFacturas() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM factura as f inner join usuario as u on f.id_usuario=u.id_usuario ORDER BY id_factura";
        List<Factura> listaFactura = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Factura c = new Factura(new Usuario());
                c.setId_factura(rs.getInt("id_factura"));
                c.getUsuario().setId_usuario(rs.getInt("id_usuario"));
                c.getUsuario().setDocumento(rs.getString("documento"));
                c.getUsuario().setNombre(rs.getString("nombre"));
                c.getUsuario().setApellido(rs.getString("apellido"));
                c.getUsuario().setDireccion(rs.getString("direccion"));
                c.getUsuario().setTelefono(rs.getString("telefono"));
                c.setCodigo(rs.getString("codigo"));
                c.setTotal(new BigDecimal(rs.getString("total")));
                c.setFecha(rs.getDate("fecha"));

                listaFactura.add(c);
            }
            stm.close();
            rs.close();
            co.close();
            return listaFactura;
        } catch (SQLException e) {
            System.out.println("Error: Clase DaoFactura, método obtener" + e);

            return null;
        }

    }

}
