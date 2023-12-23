/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author wwwvf
 */
public class Makanan extends Produk implements Pajak {
    public Makanan(String namaProduk, int hargaProduk, String deskripsiProduk, int stok, String imgPath) {
        super(namaProduk, hargaProduk, deskripsiProduk, stok, imgPath);
    }
    
    public int hitungPajak() {
        return (int) (this.getHargaProduk()*0.02);
    }
}
