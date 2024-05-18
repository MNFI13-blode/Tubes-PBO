/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author oyest
 */
public class koneksi {
    private static Connection connection;
    
    public static Connection getConnection(){
       Connection conn = null;
       String url = "jdbc:mysql://localhost:3306/tel-u_market";
       String username = "root";
       String password = "";
       
       try{
           conn = DriverManager.getConnection(url, username, password);
           DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
           connection = (Connection) DriverManager.getConnection(url,username,password);
           System.out.println("Koneksi ke database berhasil!");
       }catch(SQLException e){
           Logger.getLogger(koneksi.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Koneksi ke database gagal: " + e.getMessage());
       }
       return connection;
    }
}
