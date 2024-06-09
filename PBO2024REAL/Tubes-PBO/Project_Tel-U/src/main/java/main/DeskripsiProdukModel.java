/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


/**
 *
 * @author HP
 */
public class DeskripsiProdukModel {
    private String nama_barang,des;
    private int harga;
    private byte[] gambar;

    public DeskripsiProdukModel(String nama_barang, String des, int harga, byte[] gambar) {
        this.nama_barang = nama_barang;
        this.des = des;
        this.harga = harga;
        this.gambar = gambar;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getDeskripsi() {
        return des;
    }

    public void setDeskripsi(String des) {
        this.des = des;
    }

    public int getHargaProduk() {
        return harga;
    }

    public void setHargaProduk(int harga) {
        this.harga = harga;
    }

    public byte[] getGambarProduk() {
        return gambar;
    }

    public void setGambarProduk(byte[] gambar) {
        this.gambar = gambar;
    }
}
