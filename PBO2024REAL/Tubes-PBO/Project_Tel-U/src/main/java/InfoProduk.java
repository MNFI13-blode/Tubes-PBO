/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class InfoProduk {
    String NamaProduk;
    int HargaProduk;

    public InfoProduk(String NamaProduk, int HargaProduk) {
        this.NamaProduk = NamaProduk;
        this.HargaProduk = HargaProduk;
    }

    public String getNamaProduk() {
        return NamaProduk;
    }

    public int getHargaProduk() {
        return HargaProduk;
    }

    public void setNamaProduk(String NamaProduk) {
        this.NamaProduk = NamaProduk;
    }

    public void setHargaProduk(int HargaProduk) {
        this.HargaProduk = HargaProduk;
    }
    
}
