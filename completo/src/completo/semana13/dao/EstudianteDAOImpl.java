/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana13.dao;


import completo.semana13.conexion.Conexion;
import completo.semana13.model.Estudiante;
import completo.semana13.vista.JfrmEstudiante;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mrperez
 */
public class EstudianteDAOImpl {

    JfrmEstudiante princial;

    public boolean registrar(Estudiante estudiante) {
        boolean registrar = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO estudiante(id, nombre, apellido, direccion, telefono)"
                + " values (" + estudiante.getId() + ",'" + estudiante.getNombre() + "','" + estudiante.getApellido() + "','"
                + estudiante.getDireccion() + "','" + estudiante.getTelefono() + "')";
        try {
            con = Conexion.getConexionPostgrest();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    public List<Estudiante> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM estudiante ORDER BY ID";
        List<Estudiante> listaCliente = new ArrayList<Estudiante>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Estudiante c = new Estudiante();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setTelefono(rs.getString(5));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }

    public List<Estudiante> obtenernomebreapellido(String dato) {

        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM estudiante ";
        String cadena[] = dato.split(" ");
        String like = "(";
        for (int i = 0; i < cadena.length; i++) {
            if (i == 0) {
                like += "upper(concat(nombre,apellido)) like '%" + cadena[i].toUpperCase() + "%'";
            } else {
                like += " and upper(concat(nombre,apellido)) like '%" + cadena[i].toUpperCase() + "%'";
            }
        }
        if (!dato.isEmpty()) {
            like+=")";
            sql += " where " + like;
        }
        System.out.println(sql);
        List<Estudiante> listaCliente = new ArrayList<>();
        try {
            co = Conexion.getConexionPostgrest();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Estudiante c = new Estudiante();
                c.setId(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setTelefono(rs.getString(5));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }

    public boolean actualizar(Estudiante estudiante) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE estudiante SET nombre='" + estudiante.getNombre() + "', apellido='" + estudiante.getApellido()
                + "', direccion='" + estudiante.getDireccion() + "', telefono='" + estudiante.getTelefono() + "'" + " WHERE ID=" + estudiante.getId();
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    public boolean eliminar(Estudiante estudiante) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM estudiante WHERE ID=" + estudiante.getId();
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

    public int getMaxID() {
        Connection connect = null;
        Statement stm = null;
        ResultSet rs = null;
        int maximo = 1;
        String sql = "SELECT max(id) FROM estudiante";
        try {
            connect = Conexion.getConexionPostgrest();
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                maximo = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            System.out.println("Error: Clase EstudianteDAOImpl, método getMaxID");
            e.printStackTrace();
        }
        return maximo;
    }
}
