/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author wwwvf
 */
public class Minuman extends Produk implements Pajak {
    public Minuman(String namaProduk, int hargaProduk, String deskripsiProduk, int stok, String imgPath, Seller penjual) {
        super(namaProduk, hargaProduk, deskripsiProduk, stok, imgPath, penjual);
    }
    
    public int hitungPajak() {
        return (int) (this.getHargaProduk()*0.01);
    }
}
