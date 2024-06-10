/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ariel
 */
public class model_keranjang {
    
    private int ikeranjang_id;
    private String namaBarang;
    private int harga;
    private int quantity;
    

    public model_keranjang(int ikeranjang_id, String namaBarang, int harga, int quantity) {
        this.ikeranjang_id = ikeranjang_id;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.quantity = quantity;
    }

    /**
     * @return the ikeranjang_id
     */
    public int getIkeranjang_id() {
        return ikeranjang_id;
    }

    /**
     * @param ikeranjang_id the ikeranjang_id to set
     */
    public void setIkeranjang_id(int ikeranjang_id) {
        this.ikeranjang_id = ikeranjang_id;
    }

    /**
     * @return the namaBarang
     */
    public String getNamaBarang() {
        return namaBarang;
    }

    /**
     * @param namaBarang the namaBarang to set
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    /**
     * @return the harga
     */
    public int getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
 
}
