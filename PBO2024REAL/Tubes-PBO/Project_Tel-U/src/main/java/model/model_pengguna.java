/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/**
 *
 * @author oyest
 */
public class model_pengguna {
    private String id_pengguna;
    private String username;
    private String password;
    private String alamat;
    private String email;
    private String role;
    private InputStream foto;

    public model_pengguna(String id_pengguna, String username, String password, String alamat, String email, String role, byte[] data) {
        this.id_pengguna = id_pengguna;
        this.username = username;
        this.password = password;
        this.alamat = alamat;
        this.email = email;
        this.role = role;
        this.foto = new ByteArrayInputStream(data);
    }

    public model_pengguna() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String getId_pengguna() {
        return id_pengguna;
    }

    public void setId_pengguna(String id_pengguna) {
        this.id_pengguna = id_pengguna;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }
    
    
}
