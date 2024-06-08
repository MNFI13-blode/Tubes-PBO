/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *
 * @author oyest
 */
public class modelItem {
    
    int jumlah;
    int itemID;
    String itemName;
    String description;
    double price;
    String brandName;
    ImageIcon image;
    
    public modelItem(int itemID, String itemName, String description, double price, String brandName,int jumlah, ImageIcon image) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.brandName = brandName;
        this.jumlah = jumlah;
        this.image = image;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    

}
