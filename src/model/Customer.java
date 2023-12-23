package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Akun{
    public Customer(String nama, String email, String no_telepon, String alamat, int saldo, String imgPath) {
        super(nama, email, no_telepon, alamat, saldo, imgPath);
    }

    static public void registrasiCustomer(String nama, String email, String no_telepon, String password, String imgPath) throws SQLException{
        Database db = new Database();
        String sql = "INSERT INTO customer(nama, email, nomor_telepon, password, image_path) VALUES('" + nama +"','"+ email +"','"+ no_telepon +"','"+ password +"','" + imgPath +"')";
        db.query(sql);
    }
    
    static public boolean loginCustomer(String email, String password) throws SQLException{
        Database db = new Database();
        String sql = "SELECT * FROM customer WHERE email = '" + email + "' AND password = '" + password + "'";
        ResultSet rs = db.getData(sql);
        return rs.next();
    }
}