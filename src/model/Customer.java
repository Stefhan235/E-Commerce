package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private String nama;
    private String email;
    private String password;
    private String nomorTelepon;
    private String imgPath;

    public Customer(String nama, String email, String password, String nomorTelepon, String imgPath) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.nomorTelepon = nomorTelepon;
        this.imgPath = imgPath;
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

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    public void registrasiCustomer() throws SQLException{
        Database db = new Database();
        String sql = "INSERT INTO customer(nama, email, nomor_telepon, password, image_path) VALUES('"+this.getNama()+"','"+this.getEmail()+"','"+this.getNomorTelepon()+"','"+this.getPassword()+"','"+this.getImgPath()+"')";
        db.query(sql);
    }
    
    public boolean loginCustomer(String email, String password) throws SQLException{
        Database db = new Database();
        String sql = "SELECT * FROM customer WHERE email = '" + email + "' AND password = '" + password + "'";
        ResultSet rs = db.getData(sql);
        return rs.next();
    }
}