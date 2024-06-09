/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Search;

/**
 *
 * @author A S U S
 */
public class search_model {
    private String id_barang;
    private byte[] foto;
    private String nama_barang;
    private String jenis_barang;
    private int harga;

    public search_model(String id_barang, byte[] foto, String nama_barang, String jenis_barang, int harga) {
        this.id_barang = id_barang;
        this.foto = foto;
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
        this.harga = harga;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getJenis_barang() {
        return jenis_barang;
    }

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
}
