/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.sql.Blob;
import java.sql.SQLException;
import model.model_login;
import model.model_pengguna;
/**
 *
 * @author oyest
 */
public interface service_login {
   
    void prosesLogin(model_login log);
    model_pengguna getUserByUsername(String username) throws SQLException;   
    
}
