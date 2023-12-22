package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private String nama;
    private String email;
    private String password;
    private int nomorTelepon;

    public Customer(String nama, String email, String password, int nomorTelepon) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.nomorTelepon = nomorTelepon;
    }

    public Customer() {
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
    
    public void registrasiCustomer() throws SQLException{
        Database db = new Database();
        String sql = "INSERT INTO customer(nama, email, nomor_telepon, password) VALUES('"+this.getNama()+"','"+this.getEmail()+"','"+this.getNomorTelepon()+"','"+this.getPassword()+"')";
        db.query(sql);
    }
    
    public boolean loginCustomer(String email, String password) throws SQLException{
        Database db = new Database();
        String sql = "SELECT * FROM customer WHERE email = '" + email + "' AND password = '" + password + "'";
        ResultSet rs = db.getData(sql);
        return rs.next();
    }
}