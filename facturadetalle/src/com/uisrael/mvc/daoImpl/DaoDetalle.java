/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uisrael.mvc.daoImpl;

import com.uisrael.mvc.entidades.Conexion;
import com.uisrael.mvc.entidades.Detalle;
import com.uisrael.mvc.entidades.Factura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoDetalle {

    private static DaoDetalle instace;

    public static DaoDetalle getInstance() {
        if (instace == null) {
            instace = new DaoDetalle();
        }
        return instace;
    }

    public boolean registrarDetalle(Detalle detalle) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql2 = "INSERT INTO public.Detalle(id_factura, "
                + "valor, producto, cantidad) values "
                + "(" + detalle.getFactura().getId_factura() + ","
                + detalle.getValor() + ",'" + detalle.getProducto() + "',"
                + detalle.getCantidad() + ")";

        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql2);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método registrar" + e);
        }
        return registrar;
    }

    public boolean eliminarDetalle(Detalle detalle) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql3 = "delete from detalle where id_detalle=" + detalle.getId_detalle();
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

    public boolean editarDetalle(Detalle detalle) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql2 = "update detalle set valor=" + detalle.getValor() + ",producto='" + detalle.getProducto() + "',cantidad=" + detalle.getCantidad() + " where id_detalle=" + detalle.getId_detalle();

        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql2);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método registrar" + e);
        }
        return registrar;
    }

    public List<Detalle> obtenerDetalle(int id_Factura) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM detalle where id_factura =" + id_Factura + " ORDER BY id_detalle";
        List<Detalle> listaFactura = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Detalle c = new Detalle(new Factura());
                c.setId_detalle(rs.getInt(1));
                c.getFactura().setId_factura(rs.getInt(2));
                c.setValor(rs.getBigDecimal("valor"));
                c.setProducto(rs.getString(4));
                c.setCantidad(rs.getInt(5));
                listaFactura.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método obtener" + e);
        }

        return listaFactura;
    }

}
