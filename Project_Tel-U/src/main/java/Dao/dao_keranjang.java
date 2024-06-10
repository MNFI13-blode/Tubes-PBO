/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Keranjang_checkout.Keranjang;
import java.sql.Connection;
import model.model_keranjang;
import config.koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import service.service_keranjang;

/**
 *
 * @author ariel
 */
public class dao_keranjang implements service_keranjang{
    private Connection conn;

    public dao_keranjang(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public List<model_keranjang> getAllItems()throws SQLException{
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("No");
//        model.addColumn("Kode Barang");
//        model.addColumn("Nama");
//        model.addColumn("Harga");
        
        List<model_keranjang> items = new ArrayList<>();
        String sql ="SELECT keranjang.keranjang_id, " + 
                    "keranjang.quantity, " +
                    "barang.nama_barang, barang.harga " +
                    "FROM keranjang " +
                    "JOIN barang ON keranjang.product_id = barang.id_barang";
        
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        while(res.next()){
            int id = res.getInt("keranjang_id");
            String namaBarang = res.getString("nama_barang");
            int harga = res.getInt("harga");
            int quantity = res.getInt("quantity");
            items.add(new model_keranjang(id, namaBarang, harga, quantity));
           
        }
            return items;
    }
    
    @Override
    public int getTotalAmount() throws SQLException{
        int total = 0;
//        int total_final = 0;
        
        String sql = "SELECT keranjang.quantity, barang.harga " +
            "FROM keranjang " +
            "JOIN barang ON keranjang.product_id = barang.id_barang";
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
        
        while (res.next()) {
            int quantity = res.getInt("quantity");
            int harga = res.getInt("harga");
            total += quantity * harga;
        }
        
        return total;
    }
  
}




//    private void Tampilkan_Data(){
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("No");
//        model.addColumn("Kode Barang");
//        model.addColumn("Nama");
//        model.addColumn("Harga");
//        try{
//            int no = 1;
//            
//            String sql =             
//                    "SELECT keranjang.keranjang_id, " +
//                    "barang.nama_barang, barang.harga " +
//                    "FROM keranjang " +
//                    "JOIN barang ON keranjang.product_id = barang.id_barang";
//            java.sql.Connection conn = (Connection) koneksi.getConnection();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet res = stm.executeQuery(sql);
//            
//            while(res.next()){
//                model.addRow(new Object[]{no++, res.getString(1), res.getString(2), res.getString(3)});
//            }
//            jTable1.setModel(model);
//        }catch (SQLException e){
//            System.out.println("Error :" + e.getMessage());
//        }
//    }
//    
//    private void jumlah(){
//        int total = 0;
//        int total_final = 0;
//        for(int i = 0; i < jTable1.getRowCount(); i++){
//            int amount = Integer.parseInt((String) jTable1.getValueAt(i, 3));
//            total += amount;
//            total_final = total * Integer.parseInt((String) jTable1.getValueAt(i, 4));
//        }
//        jLabel2.setText(""+total_final);
//    }




//skip




//  @Override
//    private void Tampilkan_Data(){
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("No");
//        model.addColumn("Kode Barang");
//        model.addColumn("Nama");
//        model.addColumn("Harga");
//        try{
//            dao_keranjang cart = new Keranjang(conn);
//            List<model_keranjang> items = dao_keranjang.getAllItems();
//            int no = 1;
            
//            String sql =             
//                    "SELECT keranjang.keranjang_id, " +
//                    "barang.nama_barang, barang.harga " +
//                    "FROM keranjang " +
//                    "JOIN barang ON keranjang.product_id = barang.id_barang";
//            java.sql.Connection conn = (Connection) koneksi.getConnection();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet res = stm.executeQuery(sql);
            
//            while(res.next()){
//                model.addRow(new Object[]{no++, res.getString(1), res.getString(2), res.getString(3)});
//            }
//            jTable1.setModel(model);
//        }catch (SQLException e){
//            System.out.println("Error :" + e.getMessage());
//        }
//    }
    
//    public void model_keranjang() throws SQLException {
//        PreparedStatement st = null;
//        ResultSet         rs = null;
//        String query = 
//            "SELECT keranjang.keranjang_id, " +
//            "barang.nama_barang, barang.harga " +
//            "FROM keranjang " +
//            "JOIN barang ON keranjang.product_id = barang.id_barang";
//   
//        try {
//            st = conn.prepareStatement(query);
//            rs = st.executeQuery();
//            
//            while (rs.next()) {
//                int idKeranjang = rs.getInt("id_keranjang");
//                String nama = rs.getString("nama");
//                double harga = rs.getDouble("harga");
//
//                System.out.println("ID Keranjang: " + idKeranjang +
//                                   ", Nama: " + nama +
//                                   ", Harga: " + harga); 
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }