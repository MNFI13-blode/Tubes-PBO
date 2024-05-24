/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */





package Dao;

import main.DeskripsiProduk;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.model_login;
import service.service_login;
import login_and_register.FromLogin;
import config.token;


/**
 *
 * @author oyest
 */
public class dao_login implements service_login {
    private Connection conn;

    public dao_login() {
        conn = koneksi.getConnection();
    }

    @Override
    public void prosesLogin(model_login log) {
        PreparedStatement st = null;
        ResultSet rs         = null;
        String id            = null;
        String nama          = null;
        String Level2         = null;
        String sql = "SELECT * FROM pengguna WHERE(id_pembeli='"+log.getId_pembeli()+"'"
                +"OR username ='" + log.getUsername() + "')"
                + "AND password='"+log.getPassword()+"'";
//         String sql = "SELECT * FROM pengguna WHERE(id_pembeli='"+ log.getId_pembeli()+"OR username ='"+ log.getUsername()+"') AND password'"+log.getPassword()+"'";
//        Encrypt.getmd5java(log.getPassword())
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            if(rs.next()){
                id = rs.getString("id_pembeli");
                nama = rs.getString("username");
                Level2 = rs.getString("role");
                
                String token1 = token.generateToken(nama);
                
                DeskripsiProduk menu  = new DeskripsiProduk();
                menu.setVisible(true);
                menu.revalidate();
                
                FromLogin lg = new FromLogin();
                lg.tutup = true; 
               
                
            }else{
                JOptionPane.showMessageDialog(null, "Username atau Password Salah", "pesan",JOptionPane.INFORMATION_MESSAGE);
                FromLogin lg = new FromLogin();
                lg.tutup = false;
            }
        }catch(SQLException ex){
            Logger.getLogger(dao_login.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            if(st!= null){
                try{
                    st.close();
                }catch(SQLException ex){
                    Logger.getLogger(dao_login.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        
    }
    
    
    
}
