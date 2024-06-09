/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.ArrayList;
import java.util.List;
import login_and_register.FromLogin;
import login_and_register.FormRegister;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model_register;
import service.service_register;
import login_and_register.FromLogin;
import java.util.UUID;
import java.io.InputStream;
import java.io.IOException; 



/**
 *
 * @author oyest
 */
public class dao_register implements service_register {
    private Connection conn;
    private String shortUUID;
   
    
    public String getShortUUID() {
        return this.shortUUID;
    }
    
     public String generateShortUUID() {
         UUID uuid = UUID.randomUUID();
         String uuidString = uuid.toString().replace("-", "");
         return uuidString.substring(0, Math.min(uuidString.length(), 9));
    }

    
    public dao_register( ) {
        conn = koneksi.getConnection();
      
    }

    @Override
    public void registerUser(model_register log)  throws SQLException {
        String  query = "INSERT INTO pengguna (id_pembeli, username, password, alamat, email, role,foto) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(query);
        String userID = generateShortUUID();
        
        System.out.println(userID);
        pstmt.setString(1, userID);
        pstmt.setString(2, log.getUsername());
        pstmt.setString(3, log.getPassword());
        pstmt.setString(4, log.getAlamatl());
        pstmt.setString(5, log.getEmail());
        pstmt.setString(6, log.getRole());
        
       if(log.getImage() != null){
           try(InputStream imageStream = log.getImage()){
               pstmt.setBlob(7, log.getImage());
           }catch(IOException ex){
               ex.printStackTrace();
           }
           
       }else{
            pstmt.setNull(7, java.sql.Types.BLOB);
       }
        pstmt.executeUpdate();
        
        log.setId_pembeli(userID);
        FromLogin login = new FromLogin();
        login.setVisible(true);
        login.revalidate();
    
      
    }

    @Override
    public model_register getUserByUsername(String username) throws SQLException {
       String query = "SELECT * FROM pengguna WHERE username =  ?";
       PreparedStatement pstmt = conn.prepareStatement(query);
       pstmt.setString(1, username);
       ResultSet rs = pstmt.executeQuery();
       
       if (rs.next()){
          model_register log = new model_register();
          log.setId_pembeli(rs.getString("id_pembeli"));
          log.setUsername(rs.getNString("username"));
          log.setPassword(rs.getString("password"));
          log.setAlamatl(rs.getString("alamat"));
          log.setEmail(rs.getString("email"));
          log.setRole(rs.getString("role"));
          return log;
       }
       return null;
    }

    @Override
    public List<model_register> getAllUsers() throws SQLException {
     List<model_register> log = new ArrayList<>();
     String query = "SELECT * FROM users";
     PreparedStatement pstmt = conn.prepareStatement(query);
     ResultSet rs = pstmt.executeQuery();
     
     while (rs.next()){
         model_register log1 = new model_register();
          log1.setId_pembeli(rs.getString("id_pembeli"));
          log1.setUsername(rs.getNString("username"));
          log1.setPassword(rs.getString("password"));
          log1.setAlamatl(rs.getString("alamat"));
          log1.setEmail(rs.getString("email"));
          log1.setRole(rs.getString("role"));
          log.add(log1);
     }
     return log;
    }
    
    
    
    
    
    
    
    
}
