package com.emergentes.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionDB {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/db_biblio";
    static String usuario = "root";
    static String password = "Mendoza740";
    
    Connection conn = null;

    public conexionDB() {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("Conexion ok"+conn);
            }
        }catch(ClassNotFoundException e){
            System.out.println("Error de driver"+e.getMessage());
        }catch (SQLException ex){
            System.out.println("Error de sql" + ex.getMessage());
        }
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
