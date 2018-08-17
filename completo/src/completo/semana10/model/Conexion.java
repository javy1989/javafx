/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completo.semana10.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RODOLFO ALVAREZ
 */
public class Conexion {

    public static Connection getConexionMysql() {
        Connection con = null;
        try {

            //instancia del driver Base
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "*******");
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }

    public static Connection getConexionPostgrest() {
        Connection con = null;
       
        
        //props.setProperty("ssl", "true");
        try {
             con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_facturacion","postgres", "postgres");

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
            

    public void closeConexion() {
        Connection con = null;
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexion Cerrada");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
            
}

