/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import model.model_pengguna;
import config.koneksi;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class dao_profile {
    public model_pengguna getmodel_pengguna(String id_pengguna) throws SQLException {
        String query = "SELECT * username, alamat, email, role FROM pengguna WHERE id_pembeli = 1";
        try (Connection connection = koneksi.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, id_pengguna);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                model_pengguna profile = new model_pengguna();
                profile.setId_pengguna(rs.getString("id"));
                profile.setUsername(rs.getString("name"));
                profile.setEmail(rs.getString("email"));
                profile.setAlamat(rs.getString("address"));
                profile.setRole(rs.getString("role"));
                return profile;
            }
        }
        return null;
    }
    
}
