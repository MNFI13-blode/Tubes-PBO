/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.util.List;
import model.model_keranjang;

/**
 *
 * @author ariel
 */
public interface service_keranjang {
    
    List<model_keranjang> getAllItems() throws SQLException;
    int getTotalAmount() throws SQLException;

}
