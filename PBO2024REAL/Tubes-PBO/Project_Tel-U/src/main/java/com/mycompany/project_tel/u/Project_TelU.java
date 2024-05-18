/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.project_tel.u;
import config.koneksi;
import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author oyest
 */
public class Project_TelU {

    public static void main(String[] args) {
        Connection conn = koneksi.getConnection();
        if (conn != null) {
            System.out.println("Koneksi ke database berhasil!");
        } else {
            System.out.println("Koneksi ke database gagal.");
        }
    }
}
