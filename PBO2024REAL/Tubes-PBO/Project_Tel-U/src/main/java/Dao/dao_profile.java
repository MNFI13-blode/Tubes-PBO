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
    public model_pengguna getmodel_pengguna(int id) throws SQLException {
        String query = "SELECT * FROM user_profile WHERE id = ?";
        try (Connection connection = koneksi.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                model_pengguna profile = new model_pengguna();
                profile.setId_pengguna(rs.getString("id"));
                profile.setUsername(rs.getString("name"));
                profile.setEmail(rs.getString("email"));
                profile.setAlamat(rs.getString("address"));
                return profile;
            }
        }
        return null;
    }
    public void updateProfile(model_pengguna user) throws SQLException {
        String query = "UPDATE user_profile SET name = ?, email = ?, address = ?, role = ? WHERE id = ?";
        try (Connection connection = koneksi.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getAlamat());
            stmt.setString(4, user.getRole());
            stmt.setString(5, user.getId_pengguna());
            stmt.executeUpdate();
        }
    }
}
