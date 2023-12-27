package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Akun {
    public Customer(String nama, String email, String no_telepon, int saldo, String imgPath) {
        super(nama, email, no_telepon, saldo, imgPath);
    }

    static public void topUp(String email, int deltaSaldo) throws SQLException {
        Database db = new Database();
        String sql = String.format(
            "UPDATE seller SET saldo = saldo + %d WHERE email = '%s'",
            deltaSaldo, email
        );
        db.query(sql);
    }
    
    static public void registrasiCustomer(String nama, String email, String no_telepon, String password, String imgPath) throws SQLException{
        Database db = new Database();
        String sql = "INSERT INTO customer(nama, email, nomor_telepon, password, image_path, saldo) VALUES('" + nama +"','"+ email +"','"+ no_telepon +"','"+ password +"','" + imgPath +"', 0)";
        db.query(sql);
    }
    
    static public Customer loginCustomer(String email, String password) throws SQLException{
        Database db = new Database();
        String sql = "SELECT * FROM customer WHERE email = '" + email + "' AND password = '" + password + "'";
        ResultSet rs = db.getData(sql);
        if(rs.next()) {
            return new Customer(
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