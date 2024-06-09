package main;

import config.koneksi;
import main.DeskripsiProdukModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoDeskripsiProduk {
    public DeskripsiProdukModel getProdukById(int id) {
        DeskripsiProdukModel produk = null;
        Connection conn = koneksi.getConnection();
        String query = "SELECT nama_barang, des, harga, foto FROM barang WHERE id_barang = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nama_barang = resultSet.getString("nama_barang");
                String des = resultSet.getString("des");
                int harga = resultSet.getInt("harga");
                byte[] gambar = resultSet.getBytes("foto");

                produk = new DeskripsiProdukModel(nama_barang, des, harga, gambar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produk;
    }
}
