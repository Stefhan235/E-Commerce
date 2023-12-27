package model;

import java.sql.SQLException;

public class Produk {
    //private int idProduk;
    private String namaProduk;
    private int hargaProduk;
    private String deskripsiProduk;
    private int stok;
    private String imgPath;
    
    public Produk(String namaProduk, int hargaProduk, String deskripsiProduk, int stok, String imgPath){
        this.namaProduk = namaProduk;
        this.hargaProduk = hargaProduk;
        this.deskripsiProduk = deskripsiProduk;
        this.stok = stok;
        this.imgPath = imgPath;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(int hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public String getDeskripsiProduk() {
        return deskripsiProduk;
    }

    public void setDeskripsiProduk(String deskripsiProduk) {
        this.deskripsiProduk = deskripsiProduk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    static public void fetchAllProducts() throws SQLException {
        Database db = new Database();
        String sql = "SELECT * FROM products";
        db.getData(sql);
    }
    
    static public void fetchSellerProduct(String seller) throws SQLException {
        Database db = new Database();
        String sql = "";
        db.getData(sql);
    }
}
