package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Seller {
    private String namaToko;
    private String nama;
    private String email;
    private String password;
    private int nomorTelepon;
    //private Produk produk;

    public Seller(String namaToko, String nama, String email, String password, int nomorTelepon) {
        this.namaToko = namaToko;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.nomorTelepon = nomorTelepon;
    }

    public Seller() {
    }

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(int nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
    
    public void registrasiSeller() throws SQLException{
        Database db = new Database();
        String sql = "INSERT INTO seller(nama_toko, nama, email, nomor_telepon, password) VALUES('"+this.getNamaToko()+"', '"+this.getNama()+"','"+this.getEmail()+"','"+this.getNomorTelepon()+"','"+this.getPassword()+"')";
        db.query(sql);
    }
    
    public boolean loginSeller(String email, String password) throws SQLException{
        Database db = new Database();
        String sql = "SELECT * FROM seller WHERE email = '" + email + "' AND password = '" + password + "'";
        ResultSet rs = db.getData(sql);
        return rs.next();
    }
}

