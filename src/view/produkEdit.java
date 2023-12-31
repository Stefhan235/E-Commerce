/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Akun;
import model.Customer;
import model.Database;
import model.Makanan;
import model.Minuman;
import model.Produk;

/**
 *
 * @author deazs
 */
public class produkEdit extends javax.swing.JDialog {
    static private Produk product;
    static private String productCategory; // Not really needed
    static private Akun user;
    private static String filename;
    /**
     * Creates new form produkEdit
     */
    public produkEdit(java.awt.Frame parent, boolean modal, Produk product, Akun user) {
        super(parent, modal);
        initComponents();
        
        this.product = product;
        this.user = user;
        
        if(product instanceof Minuman ) {
            produkTambahKategori.setSelectedIndex(0);
        } else if(product instanceof Makanan ) {
            produkTambahKategori.setSelectedIndex(1);
        } else {
            produkTambahKategori.setSelectedIndex(2);
        }
        
        Gambar.renderProduk(tambahProdukImg, product.getImgPath());
        produkTambahNama.setText(product.getNamaProduk());
        produkTambahHarga.setText(String.valueOf(product.getHargaProduk()));
        produkTambahStok.setText(String.valueOf(product.getStok()));
        produkTambahDeskripsi.setText(product.getDeskripsiProduk());  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tambahProdukImg = new javax.swing.JLabel();
        pilihGambarBtn = new javax.swing.JButton();
        produkTambahNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        produkTambahHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        produkTambahStok = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        produkTambahKategori = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        produkTambahDeskripsi = new javax.swing.JTextArea();
        updateBtn = new javax.swing.JButton();
        produkTambahBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 225, 54));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setText("Warungpedia");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(1390, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 225, 54));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Update Produk");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        tambahProdukImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tambahProdukImg.setText("Gambar produkmu akan muncul di sini!");
        tambahProdukImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pilihGambarBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pilihGambarBtn.setText("Pilih Gambar");
        pilihGambarBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        pilihGambarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihGambarBtnActionPerformed(evt);
            }
        });

        produkTambahNama.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        produkTambahNama.setText("<nama produk>");
        produkTambahNama.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Harga");

        produkTambahHarga.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        produkTambahHarga.setText("<harga barang>");
        produkTambahHarga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Stok");

        produkTambahStok.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        produkTambahStok.setText("<stok barang>");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Kategori");

        produkTambahKategori.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        produkTambahKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Makanan", "Minuman", "Elektronik" }));

        jSeparator2.setBackground(new java.awt.Color(255, 225, 54));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Deskripsi");

        produkTambahDeskripsi.setColumns(20);
        produkTambahDeskripsi.setRows(5);
        jScrollPane1.setViewportView(produkTambahDeskripsi);

        updateBtn.setBackground(new java.awt.Color(255, 225, 54));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        produkTambahBackButton.setBackground(new Color(0, 0, 0, 0));
        produkTambahBackButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        produkTambahBackButton.setText("Kembali");
        produkTambahBackButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        produkTambahBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produkTambahBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1619, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tambahProdukImg, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihGambarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(produkTambahBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(produkTambahStok))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(28, 28, 28)
                                .addComponent(produkTambahHarga))
                            .addComponent(produkTambahNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(produkTambahKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(652, 652, 652))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambahProdukImg, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pilihGambarBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(produkTambahNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(produkTambahHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(produkTambahStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(produkTambahKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(produkTambahBackButton))
                .addGap(0, 265, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {
            // TODO add your handling code here:
            String nama = produkTambahNama.getText();
            int harga = Integer.parseInt(produkTambahHarga.getText());
            int stok = Integer.parseInt(produkTambahStok.getText());
            Object kategori =  produkTambahKategori.getSelectedItem();
            String deskripsi = produkTambahDeskripsi.getText();
            
            String productName = product.getNamaProduk();
            String email = product.getPenjual().getEmail();
            
            File fileakhir2;
            if(filename != null) {
                String newpath = "src//upload//produk";
                File directory = new File(newpath);
                if (!directory.exists()){
                    directory.mkdirs();
                }
                File fileawal;
                File fileakhir;
                String ext = this.filename.substring(filename.lastIndexOf(".")+1);
                fileawal = new File(filename);
                fileakhir = new File(newpath + "//" + email + nama + "." + ext);
                fileakhir2 = new File(email + nama + "." + ext);

                if (fileakhir.exists()){
                    fileakhir.delete();
                }
                
                try {
                    Files.copy(fileawal.toPath(), fileakhir.toPath());
                } catch (IOException ex) {
                    Logger.getLogger(CustomerSignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                fileakhir2 = new File(product.getImgPath());
            }
            
            Database db = new Database();
            String sql = "UPDATE produk SET nama = '"+nama+"', harga = '"+harga+"', stok = '"+stok+"', kategori = '"+kategori+"', deskripsi = '"+deskripsi+"', image_path = '"+fileakhir2+"' "
                    + "WHERE nama = '"+productName+"' and penjual = '"+email+"'";
            db.query(sql);
        } catch (SQLException ex) {
            Logger.getLogger(produkEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
        
    }//GEN-LAST:event_updateBtnActionPerformed

    private void pilihGambarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihGambarBtnActionPerformed
        // TODO add your handling code here: 
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        ImageIcon icon = new ImageIcon(f.toString());
        Image img = icon.getImage().getScaledInstance(tambahProdukImg.getWidth(), tambahProdukImg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic = new ImageIcon(img);
        tambahProdukImg.setIcon(ic);
        this.filename = f.getAbsolutePath();
    }//GEN-LAST:event_pilihGambarBtnActionPerformed

    private void produkTambahBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produkTambahBackButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_produkTambahBackButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(produkEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produkEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produkEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produkEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                produkEdit dialog = new produkEdit(new javax.swing.JFrame(), true, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton pilihGambarBtn;
    private javax.swing.JButton produkTambahBackButton;
    private javax.swing.JTextArea produkTambahDeskripsi;
    private javax.swing.JTextField produkTambahHarga;
    private javax.swing.JComboBox<String> produkTambahKategori;
    private javax.swing.JTextField produkTambahNama;
    private javax.swing.JTextField produkTambahStok;
    private javax.swing.JLabel tambahProdukImg;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
