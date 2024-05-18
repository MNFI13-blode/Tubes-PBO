/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validasi;
import java.sql.SQLException;
import service.service_register;
import Dao.dao_register;
import model.model_register;
/**
 *
 * @author oyest
 */
public class avaibelRegisterUsername   {
    private service_register regDao;

    public avaibelRegisterUsername() {
        this.regDao = new dao_register();
    
    }

    public void registerUser(model_register log) throws SQLException {
      if(regDao.getUserByUsername(log.getUsername()) == null){
          regDao.registerUser(log);
      }else{
          throw new SQLException("Username dengan kata ini sudah ada");
      }
    }

  
    public model_register getUserByUsername(String username) throws SQLException {
        return regDao.getUserByUsername(username);
    }
    
    
    
    
    
   
    
    
    
}
