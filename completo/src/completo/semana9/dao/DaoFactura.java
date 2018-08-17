/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana9.dao;


import completo.semana9.conexion.Conexion;
import completo.semana9.model.Factura;
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

    public boolean registrarFactura(Factura factura) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fecha =formato.format(factura.getFecha());
        String sql3 = "INSERT INTO public.Factura(id_usuario, "
                + "codigo, fecha) values "
                + "(" + factura.getId_usuario() + ",'"
                + factura.getCodigo() + "','" + fecha + "')";
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
                factura = new Factura();
                factura.setId_factura(rs.getInt("id_factura"));
                factura.setCodigo(rs.getString("codigo"));
                factura.setFecha(rs.getDate("fecha"));
                factura.setId_usuario(rs.getInt("id_usuario"));
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

        String sql = "SELECT * FROM public.factura ORDER BY id_factura";
        List<Factura> listaFactura = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Factura c = new Factura();
                c.setId_factura(rs.getInt(1));
                c.setId_usuario(rs.getInt(2));
                c.setCodigo(rs.getString("codigo"));
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
