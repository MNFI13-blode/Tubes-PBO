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
        String query = "SELECT barang.nama_barang, barang.des, barang.harga, barang.foto, penjual.nama_toko, penjual.username FROM barang "
                + "INNER JOIN penjual ON barang.id_penjual = penjual.id_penjual WHERE barang.id_barang = ?";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nama_barang = resultSet.getString("nama_barang");
                String des = resultSet.getString("des");
                int harga = resultSet.getInt("harga");
                byte[] gambar = resultSet.getBytes("foto");
                String nama_toko = resultSet.getString("nama_toko");
                String username = resultSet.getString("username");

                produk = new DeskripsiProdukModel(nama_barang, des, harga, gambar, nama_toko, username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produk;
    }
}
