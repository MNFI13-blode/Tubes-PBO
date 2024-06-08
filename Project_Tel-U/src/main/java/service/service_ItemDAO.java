/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.sql.SQLException;
import java.util.List;
import model.modelItem;
/**
 *
 * @author oyest
 */
public interface service_ItemDAO {
   List<modelItem> getAllItems() throws SQLException;
}
