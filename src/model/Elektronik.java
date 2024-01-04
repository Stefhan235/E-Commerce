/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author wwwvf
 */
public class Elektronik extends Produk implements Pajak { 
    public Elektronik(String namaProduk, int hargaProduk, String deskripsiProduk, int stok, String imgPath, Seller penjual) {
        super(namaProduk, hargaProduk, deskripsiProduk, stok, imgPath, penjual);
    }
    
    public int hitungPajak() {
        return (int) (this.getHargaProduk() * 0.1);
    }
    
    public String[] getKemasanTersedia() {
        return new String[]{"Bubble Wrap", "Kayu"};
    }
}
