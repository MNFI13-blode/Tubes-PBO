/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.util.List;
import model.model_register;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author oyest
 */
public interface service_register {
    
    void registerUser(model_register log) throws SQLException; 
    model_register getUserByUsername(String username) throws SQLException;
    List<model_register> getAllUsers() throws SQLException;
    
}
