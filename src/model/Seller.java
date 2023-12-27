package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Seller extends Akun {
    private String namaToko;

    public Seller(String namaToko, String nama, String email, String no_telepon, int saldo, String imgPath) {
        super(nama, email, no_telepon, saldo, imgPath);
        this.namaToko = namaToko;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }
    
    static public void withdraw(String email, int deltaSaldo) throws SQLException {
        Database db = new Database();
        String sql = String.format(
            "UPDATE seller SET saldo = saldo - %d WHERE email = '%s'",
            deltaSaldo, email
        );
        db.query(sql);
    }
        
    static public void registrasiSeller(String nama_toko, String nama, String email, String nomor_telepon, String password, String imgPath) throws SQLException{
        Database db = new Database();
        String sql = "INSERT INTO seller(nama_toko, nama, email, nomor_telepon, password, image_path, saldo) VALUES('" + nama_toko + "', '" + nama + "','" + email + "','" + nomor_telepon + "','" + password + "','" + imgPath + "', 0)";
        db.query(sql);
    }
    
    static public Seller loginSeller(String email, String password) throws SQLException{
        Database db = new Database();
        String sql = "SELECT * FROM seller WHERE email = '" + email + "' AND password = '" + password + "'";
        ResultSet rs = db.getData(sql);
        if(rs.next()) {
            return new Seller(
                rs.getString("nama_toko"),
                rs.getString("nama"), 
                rs.getString("email"),
                rs.getString("nomor_telepon"),  
                rs.getInt("saldo"), 
                rs.getString("image_path")
            );
        }
        return null;
    }
}

