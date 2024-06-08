/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.modelItem;
import service.service_ItemDAO;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *
 * @author oyest
 */
public class dao_ShowItem implements service_ItemDAO {
    private Connection conn;

    public dao_ShowItem() {
     conn = koneksi.getConnection();
    }
    
    @Override
    public List<modelItem> getAllItems() throws SQLException {
        List<modelItem> items = new ArrayList<>();
        String query = "SELECT * FROM barang";
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()){
            int id = rs.getInt("id_barang");
            String nama = rs.getString("nama_barang");
            String jenis = rs.getString("jenis_barang");
            String deskripsi = rs.getString("des");
            int harga = rs.getInt("harga");
            int jumlah = rs.getInt("jumlah_barang");
            byte[] imgBytes = rs.getBytes("foto");
            
            ImageIcon itemImage  = null;
            if(imgBytes!= null){
                itemImage = new ImageIcon(new ImageIcon(imgBytes).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            }
            modelItem item = new modelItem(id,nama,deskripsi,harga,jenis,jumlah,itemImage);
            items.add(item);
        }
        return items;
    }
    
}
