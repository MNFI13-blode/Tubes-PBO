/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import model.model_pengguna;
import Dao.dao_profile;
import java.sql.SQLException;
/**
 *
 * @author LENOVO
 */
public interface service_profil {
    dao_profile daoProfile = new dao_profile();

    default model_pengguna getmodel_pengguna(String id_pengguna) throws SQLException {
        return daoProfile.getmodel_pengguna(id_pengguna);
    }

    default void updateProfile(model_pengguna user) throws SQLException {
        daoProfile.updateProfile(user);
    }
    
}
