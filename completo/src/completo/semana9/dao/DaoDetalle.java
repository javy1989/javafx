/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana9.dao;


import completo.semana9.conexion.Conexion;
import completo.semana9.model.Detalle;
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
public class DaoDetalle {

    public boolean registrarDetalle(Detalle detalle) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;

        String sql2 = "INSERT INTO public.Detalle(id_factura, "
                + "valor, producto, cantidad, precioTotal) values "
                + "(" + detalle.getId_factura() + ",'"
                + detalle.getValor() + "','" + detalle.getProducto() + "','"
                + detalle.getCantidad() + "', " + detalle.getPrecioTotal() + ")";

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

        String sql = "SELECT * FROM public.detalle where id_factura =" + id_Factura + " ORDER BY id_detalle";
        List<Detalle> listaFactura = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Detalle c = new Detalle();
                c.setId_detalle(rs.getInt(1));
                c.setId_factura(rs.getInt(2));
                c.setValor(rs.getBigDecimal("valor"));
                c.setProducto(rs.getString(4));
                c.setCantidad(rs.getInt(5));
                c.setPrecioTotal(rs.getBigDecimal("preciototal"));

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
