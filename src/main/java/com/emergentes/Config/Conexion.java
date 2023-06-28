package com.emergentes.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SYSTEMSJE
 */
public class Conexion {

    static String driver = "com.mysql.jdbc.Driver";  //propiedad de la clase Conexion
    static String url = "jdbc:mysql://localhost:3306/mibdventas"; //direccion  de kla base de datos
    static String usuario = "root";    //usuario de la administeacion de la base de datos
    static String password = "root";
    Connection conn = null;

    public Connection Conexion() {

        try {
            Class.forName(driver);//driver de la coneccion de la base de datos
            conn = DriverManager.getConnection(url, usuario, password); //conectar a la base de datos
            if (conn != null) {
                System.out.println("Conexion : " + conn);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    /*
    Connection con;
    String url = "jdbc:mysql://localhost:3306/sf_ventas";
    String usuario = "root";
    String clave = "root";

    public Connection Conexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
     */
}
