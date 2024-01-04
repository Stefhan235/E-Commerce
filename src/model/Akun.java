/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wwwvf
 */
public class Akun {
    private String nama;
    private String email;
    private String no_telepon;
    private int saldo;
    private String imgPath;

    public Akun(String nama, String email, String no_telepon, int saldo, String imgPath) {
        this.nama = nama;
        this.email = email;
        this.no_telepon = no_telepon;
        this.saldo = saldo;
        this.imgPath = imgPath;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }


    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    static public int fetchSaldo(Akun targetUser, String email) throws SQLException {
        Database db = new Database();
        String sql;
        if(targetUser instanceof Seller) {
            System.out.println("seller");
            sql = String.format("SELECT saldo FROM seller WHERE email = '%s'", email);
        } else {
            System.out.println("buyer");
            sql = String.format("SELECT saldo FROM customer WHERE email = '%s'", email);
        }
        
        ResultSet rs = db.getData(sql);
        rs.next();
        return rs.getInt("saldo");
    }
}
