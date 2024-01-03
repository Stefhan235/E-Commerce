/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Akun;
import model.Customer;
import model.Database;
import model.Produk;
import model.Seller;

/**
 *
 * @author wwwvf
 */
public class Dashboard extends javax.swing.JFrame {
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    private static int saldoSekarang;
    private Akun user;
    private boolean isClient = true;
    private static int paginatorIndex = 0;
    private static int maxBarang = 100;
    private static Produk[] listBarang = new Produk[5];
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard(Akun user, boolean isClient) {
        initComponents();
        // GUI Settings
        this.getContentPane().setBackground(Color.WHITE);
        //this.getContentPane().setPreferredSize(new Dimension(940, 540));
        dashboardAddItem.setBackground(TRANSPARENT);
        dashboardRefresh.setBackground(TRANSPARENT);

        // Property Settings
        this.user = user;
        this.isClient = isClient;
        saldoSekarang = this.user.getSaldo();
        
        initGUI();
    }

    private void updateMaxBarang() {
        try {
            if(isClient) {
                maxBarang = Produk.getProductCount();
            } else {
                maxBarang = Produk.getSellerProductCount(user.getEmail());
            }
    
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", HEIGHT);
        }
    }
    
    private void fetchItems() {
        try {
            Database db = new Database();
            if(isClient) {
                Produk.fetchProducts(listBarang, paginatorIndex);
            } else {
                Produk.fetchSellerProduct(listBarang, user.getEmail(), paginatorIndex);
            }
        } catch(SQLException e) {
            
        }
    }
    
    private void updateItemDisplay() {
        JPanel[] cards = {
            productCard1,
            productCard2,
            productCard3,
            productCard4,
            productCard5,
        };
        
        for(int i = 0; i < 5; i++) {
            if(listBarang[i] == null) {
                cards[i].setVisible(false);
            } else {
                cards[i].setVisible(true);
                switch(i) {
                    case 1:
                        productName2.setText(listBarang[i].getNamaProduk());
                        productPrice2.setText(String.format("Rp. %d", listBarang[i].getHargaProduk()));
                        productStock2.setText(String.format("%d", listBarang[i].getStok()));
                        productVendor2.setText(listBarang[i].getPenjualProduk());
                        Gambar.render(productImg2, listBarang[i].getImgPath());
                        break;
                    case 2:
                        productName3.setText(listBarang[i].getNamaProduk());
                        productPrice3.setText(String.format("Rp. %d", listBarang[i].getHargaProduk()));
                        productStock3.setText(String.format("%d", listBarang[i].getStok()));
                        productVendor3.setText(listBarang[i].getPenjualProduk());
                        Gambar.render(productImg3, listBarang[i].getImgPath());
                        break;
                    case 3:
                        productName4.setText(listBarang[i].getNamaProduk());
                        productPrice4.setText(String.format("Rp. %d", listBarang[i].getHargaProduk()));
                        productStock4.setText(String.format("%d", listBarang[i].getStok()));
                        productVendor4.setText(listBarang[i].getPenjualProduk());
                        Gambar.render(productImg4, listBarang[i].getImgPath());
                        break;
                    case 4:
                        productName5.setText(listBarang[i].getNamaProduk());
                        productPrice5.setText(String.format("Rp. %d", listBarang[i].getHargaProduk()));
                        productStock5.setText(String.format("%d", listBarang[i].getStok()));
                        productVendor5.setText(listBarang[i].getPenjualProduk());
                        Gambar.render(productImg5, listBarang[i].getImgPath());
                        break;
                    default:
                        productName1.setText(listBarang[i].getNamaProduk());
                        productPrice1.setText(String.format("Rp. %d", listBarang[i].getHargaProduk()));
                        productStock1.setText(String.format("%d", listBarang[i].getStok()));
                        productVendor1.setText(listBarang[i].getPenjualProduk());
                        Gambar.render(productImg1, listBarang[i].getImgPath());
                }
            }
        }
    }
    
    public void renderImage(JLabel target, String imgPath) {
        File f = new File(String.format("src//upload//%s", imgPath));

        Image img = (new ImageIcon(f.toString())).getImage().getScaledInstance(
            target.getWidth(), target.getHeight(), Image.SCALE_SMOOTH
        );
        
        target.setText("");
        target.setIcon(new ImageIcon(img));
    }
    
    public void initGUI() {
        // Adjust GUI based on role
        if(isClient) {
            dashboardAddItem.setVisible(false);
            dashboardSaldoActionText.setText("Tambah Saldo");
            dashboardSaldoActionButton.setText("Tambah Saldo");
        } else {
            dashboardTitle.setText("Daftar Barang Anda");

            for(JLabel vendor: new JLabel[]{
                productVendor1, productVendor2, productVendor3,
                productVendor4, productVendor5
            }) {
                vendor.setForeground(TRANSPARENT);
            }            
        }

        // Post-property setting GUI settings
        this.requestFocusInWindow();
        dashboardRow1.setBackground(TRANSPARENT);
        dashboardSaldoActionButton.setBackground(Color.WHITE);
        dashboardSaldoAnda.setText(String.format(
        "Rp. %d", saldoSekarang
        ));
        fetchItems();
        updateMaxBarang();
        updateItemDisplay();
        updatePaginatorMsg();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dashboardTitle = new javax.swing.JLabel();
        productCard1 = new javax.swing.JPanel();
        productImage1 = new javax.swing.JPanel();
        productImg1 = new javax.swing.JLabel();
        productName1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productStock1 = new javax.swing.JLabel();
        productPrice1 = new javax.swing.JLabel();
        productVendor1 = new javax.swing.JLabel();
        dashboardAddItem = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        dashboardSaldoAnda = new javax.swing.JLabel();
        JLabelSaldoAnda = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        dashboardSaldoActionText = new javax.swing.JLabel();
        dashboardSaldoActionValue = new javax.swing.JTextField();
        dashboardSaldoActionButton = new javax.swing.JButton();
        productCard2 = new javax.swing.JPanel();
        productImage2 = new javax.swing.JPanel();
        productImg2 = new javax.swing.JLabel();
        productName2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productStock2 = new javax.swing.JLabel();
        productPrice2 = new javax.swing.JLabel();
        productVendor2 = new javax.swing.JLabel();
        productCard3 = new javax.swing.JPanel();
        productImage3 = new javax.swing.JPanel();
        productImg3 = new javax.swing.JLabel();
        productName3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productStock3 = new javax.swing.JLabel();
        productPrice3 = new javax.swing.JLabel();
        productVendor3 = new javax.swing.JLabel();
        productCard4 = new javax.swing.JPanel();
        productImage4 = new javax.swing.JPanel();
        productImg4 = new javax.swing.JLabel();
        productName4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        productStock4 = new javax.swing.JLabel();
        productPrice4 = new javax.swing.JLabel();
        productVendor4 = new javax.swing.JLabel();
        productCard5 = new javax.swing.JPanel();
        productImage5 = new javax.swing.JPanel();
        productImg5 = new javax.swing.JLabel();
        productName5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        productStock5 = new javax.swing.JLabel();
        productPrice5 = new javax.swing.JLabel();
        productVendor5 = new javax.swing.JLabel();
        dashboardNextPage = new javax.swing.JButton();
        dashboardPrevPage = new javax.swing.JButton();
        dashboardPaginatorMsg = new javax.swing.JLabel();
        dashboardRefresh = new javax.swing.JButton();
        dashboardRow1 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 225, 54));
        jPanel3.setPreferredSize(new java.awt.Dimension(337, 39));

        dashboardTitle.setBackground(new java.awt.Color(255, 225, 54));
        dashboardTitle.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        dashboardTitle.setText("Penawaran Hari Ini");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(dashboardTitle)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboardTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productCard1.setBackground(new java.awt.Color(255, 255, 255));
        productCard1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        productCard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productCard1MouseClicked(evt);
            }
        });

        productImage1.setBackground(new java.awt.Color(204, 204, 204));

        productImg1.setText("akjaks");

        javax.swing.GroupLayout productImage1Layout = new javax.swing.GroupLayout(productImage1);
        productImage1.setLayout(productImage1Layout);
        productImage1Layout.setHorizontalGroup(
            productImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productImg1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        productImage1Layout.setVerticalGroup(
            productImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productImage1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(productImg1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        productName1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        productName1.setText("jLabel2");

        jLabel2.setText("Stok: ");

        productStock1.setText("69420");

        productPrice1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productPrice1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productPrice1.setText("Rp. 0,00");
        productPrice1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        productVendor1.setText("Nama Toko");

        javax.swing.GroupLayout productCard1Layout = new javax.swing.GroupLayout(productCard1);
        productCard1.setLayout(productCard1Layout);
        productCard1Layout.setHorizontalGroup(
            productCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productPrice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productName1)
                    .addComponent(productVendor1)
                    .addGroup(productCard1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        productCard1Layout.setVerticalGroup(
            productCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productStock1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productVendor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPrice1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dashboardAddItem.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        dashboardAddItem.setText("Tambah Produk");
        dashboardAddItem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        dashboardAddItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardAddItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardAddItemMouseExited(evt);
            }
        });
        dashboardAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardAddItemActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 225, 54));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 4, true));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        dashboardSaldoAnda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dashboardSaldoAnda.setText("Rp. 50000");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboardSaldoAnda, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(88, 88, 88))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboardSaldoAnda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JLabelSaldoAnda.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        JLabelSaldoAnda.setText("Saldo Anda");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelSaldoAnda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(JLabelSaldoAnda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 225, 54));

        dashboardSaldoActionText.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        dashboardSaldoActionText.setText("Tarik Saldo");

        dashboardSaldoActionValue.setText("Masukkan nominal saldo...");
        dashboardSaldoActionValue.setPreferredSize(new java.awt.Dimension(311, 40));
        dashboardSaldoActionValue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dashboardSaldoActionValueFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dashboardSaldoActionValueFocusLost(evt);
            }
        });
        dashboardSaldoActionValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardSaldoActionValueActionPerformed(evt);
            }
        });

        dashboardSaldoActionButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dashboardSaldoActionButton.setText("Tarik Saldo");
        dashboardSaldoActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardSaldoActionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(dashboardSaldoActionText)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(dashboardSaldoActionValue, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(dashboardSaldoActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(dashboardSaldoActionText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardSaldoActionValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardSaldoActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        productCard2.setBackground(new java.awt.Color(255, 255, 255));
        productCard2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        productCard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productCard2MouseClicked(evt);
            }
        });

        productImage2.setBackground(new java.awt.Color(204, 204, 204));

        productImg2.setText("jLabel7");

        javax.swing.GroupLayout productImage2Layout = new javax.swing.GroupLayout(productImage2);
        productImage2.setLayout(productImage2Layout);
        productImage2Layout.setHorizontalGroup(
            productImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productImg2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        productImage2Layout.setVerticalGroup(
            productImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productImg2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
        );

        productName2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        productName2.setText("jLabel2");

        jLabel3.setText("Stok: ");

        productStock2.setText("69420");

        productPrice2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productPrice2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productPrice2.setText("Rp. 0,00");
        productPrice2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        productVendor2.setText("Nama Toko");

        javax.swing.GroupLayout productCard2Layout = new javax.swing.GroupLayout(productCard2);
        productCard2.setLayout(productCard2Layout);
        productCard2Layout.setHorizontalGroup(
            productCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productPrice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(productCard2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productStock2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addGroup(productCard2Layout.createSequentialGroup()
                        .addGroup(productCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productName2)
                            .addComponent(productVendor2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        productCard2Layout.setVerticalGroup(
            productCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productName2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(productStock2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productVendor2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPrice2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productCard3.setBackground(new java.awt.Color(255, 255, 255));
        productCard3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        productCard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productCard3MouseClicked(evt);
            }
        });

        productImage3.setBackground(new java.awt.Color(204, 204, 204));

        productImg3.setText("jLabel7");

        javax.swing.GroupLayout productImage3Layout = new javax.swing.GroupLayout(productImage3);
        productImage3.setLayout(productImage3Layout);
        productImage3Layout.setHorizontalGroup(
            productImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productImg3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        productImage3Layout.setVerticalGroup(
            productImage3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productImage3Layout.createSequentialGroup()
                .addComponent(productImg3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        productName3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        productName3.setText("jLabel2");

        jLabel4.setText("Stok: ");

        productStock3.setText("69420");

        productPrice3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productPrice3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productPrice3.setText("Rp. 0,00");
        productPrice3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        productVendor3.setText("Nama Toko");

        javax.swing.GroupLayout productCard3Layout = new javax.swing.GroupLayout(productCard3);
        productCard3.setLayout(productCard3Layout);
        productCard3Layout.setHorizontalGroup(
            productCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productPrice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(productCard3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productStock3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addGroup(productCard3Layout.createSequentialGroup()
                        .addGroup(productCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productName3)
                            .addComponent(productVendor3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        productCard3Layout.setVerticalGroup(
            productCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productName3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(productStock3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productVendor3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPrice3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        productCard4.setBackground(new java.awt.Color(255, 255, 255));
        productCard4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        productCard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productCard4MouseClicked(evt);
            }
        });

        productImage4.setBackground(new java.awt.Color(204, 204, 204));

        productImg4.setText("jLabel7");

        javax.swing.GroupLayout productImage4Layout = new javax.swing.GroupLayout(productImage4);
        productImage4.setLayout(productImage4Layout);
        productImage4Layout.setHorizontalGroup(
            productImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productImg4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        productImage4Layout.setVerticalGroup(
            productImage4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productImage4Layout.createSequentialGroup()
                .addComponent(productImg4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        productName4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        productName4.setText("jLabel2");

        jLabel5.setText("Stok: ");

        productStock4.setText("69420");

        productPrice4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productPrice4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productPrice4.setText("Rp. 0,00");

        productVendor4.setText("Nama Toko");

        javax.swing.GroupLayout productCard4Layout = new javax.swing.GroupLayout(productCard4);
        productCard4.setLayout(productCard4Layout);
        productCard4Layout.setHorizontalGroup(
            productCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productPrice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productImage4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(productCard4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productStock4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addGroup(productCard4Layout.createSequentialGroup()
                        .addGroup(productCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productName4)
                            .addComponent(productVendor4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        productCard4Layout.setVerticalGroup(
            productCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productImage4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productName4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productCard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(productStock4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productVendor4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPrice4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productCard5.setBackground(new java.awt.Color(255, 255, 255));
        productCard5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        productCard5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productCard5MouseClicked(evt);
            }
        });

        productImage5.setBackground(new java.awt.Color(204, 204, 204));

        productImg5.setText("jLabel7");

        javax.swing.GroupLayout productImage5Layout = new javax.swing.GroupLayout(productImage5);
        productImage5.setLayout(productImage5Layout);
        productImage5Layout.setHorizontalGroup(
            productImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productImg5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        productImage5Layout.setVerticalGroup(
            productImage5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productImage5Layout.createSequentialGroup()
                .addComponent(productImg5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        productName5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        productName5.setText("jLabel2");

        jLabel6.setText("Stok: ");

        productStock5.setText("69420");

        productPrice5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productPrice5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        productPrice5.setText("Rp. 0,00");

        productVendor5.setText("Nama Toko");

        javax.swing.GroupLayout productCard5Layout = new javax.swing.GroupLayout(productCard5);
        productCard5.setLayout(productCard5Layout);
        productCard5Layout.setHorizontalGroup(
            productCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productImage5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productPrice5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(productCard5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productStock5, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
                    .addGroup(productCard5Layout.createSequentialGroup()
                        .addGroup(productCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productName5)
                            .addComponent(productVendor5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        productCard5Layout.setVerticalGroup(
            productCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productCard5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productName5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productCard5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(productStock5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productVendor5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productPrice5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dashboardNextPage.setBackground(new java.awt.Color(255, 225, 54));
        dashboardNextPage.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dashboardNextPage.setText("Next");
        dashboardNextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardNextPageActionPerformed(evt);
            }
        });

        dashboardPrevPage.setBackground(new java.awt.Color(255, 225, 54));
        dashboardPrevPage.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        dashboardPrevPage.setText("Previous");
        dashboardPrevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardPrevPageActionPerformed(evt);
            }
        });

        dashboardPaginatorMsg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dashboardPaginatorMsg.setText("Menampilkan ... dari ... barang");

        dashboardRefresh.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        dashboardRefresh.setText("Perbarui");
        dashboardRefresh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 225, 54), 2, true));
        dashboardRefresh.setMaximumSize(new java.awt.Dimension(77, 31));
        dashboardRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardRefreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardRefreshMouseExited(evt);
            }
        });
        dashboardRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardRefreshActionPerformed(evt);
            }
        });

        dashboardRow1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1676, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dashboardPrevPage, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dashboardNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productCard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productCard3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productCard4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productCard5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dashboardPaginatorMsg)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dashboardRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dashboardAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(dashboardRow1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productCard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productCard4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productCard5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productCard2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productCard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashboardPaginatorMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dashboardPrevPage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dashboardNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardAddItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardAddItemMouseEntered
        dashboardAddItem.setBackground(new Color(200, 200, 140, 1));
    }//GEN-LAST:event_dashboardAddItemMouseEntered

    private void dashboardAddItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardAddItemMouseExited
        dashboardAddItem.setBackground(TRANSPARENT);
    }//GEN-LAST:event_dashboardAddItemMouseExited

    private void productCard1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productCard1MouseClicked
       produkDisplay page = new produkDisplay(
            this, true, 
               listBarang[0], user, 
               listBarang[0].getImgPath()
       );
       page.setVisible(true);
    }//GEN-LAST:event_productCard1MouseClicked

    private void dashboardAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardAddItemActionPerformed
        produkTambah page = new produkTambah(this, true, user.getEmail());
        page.setVisible(true);
    }//GEN-LAST:event_dashboardAddItemActionPerformed

    private void dashboardSaldoActionValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardSaldoActionValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardSaldoActionValueActionPerformed

    private void dashboardSaldoActionValueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dashboardSaldoActionValueFocusGained
        dashboardSaldoActionValue.setText("");
    }//GEN-LAST:event_dashboardSaldoActionValueFocusGained

    private void updateDBSaldo(String user, int deltaSaldo) {
        try {
            if(isClient) {
                Customer.topUp(user, deltaSaldo);
            } else {
                Seller.withdraw(user, deltaSaldo);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", HEIGHT);
        }
    }
    private void updateDisplaySaldo(int deltaSaldo, char operation) {
        switch(operation) {
            case '+':
                saldoSekarang += deltaSaldo;
                break;
            case '-':
                if(saldoSekarang >= deltaSaldo ) {
                    saldoSekarang -= deltaSaldo;
                } else {
                    JOptionPane.showMessageDialog(
                            null, "Pinjol dulu!", 
                            "Error!", HEIGHT
                    );
                }
        }
        
        dashboardSaldoAnda.setText(String.format(
        "Rp. %d", saldoSekarang
        ));
    }
    
    private void dashboardSaldoActionValueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dashboardSaldoActionValueFocusLost
       
    }//GEN-LAST:event_dashboardSaldoActionValueFocusLost

    private void productCard2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productCard2MouseClicked
       produkDisplay page = new produkDisplay(
            this, true, 
            listBarang[1], user,
            listBarang[1].getImgPath()
       );
       page.setVisible(true);
    }//GEN-LAST:event_productCard2MouseClicked

    private void productCard3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productCard3MouseClicked
       produkDisplay page = new produkDisplay(
            this, true, 
            listBarang[2], user, 
            listBarang[2].getImgPath()
       );
       page.setVisible(true);
    }//GEN-LAST:event_productCard3MouseClicked

    private void productCard4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productCard4MouseClicked
       produkDisplay page = new produkDisplay(
            this, true, 
            listBarang[3], user,
            listBarang[3].getImgPath()
       );
       page.setVisible(true);
    }//GEN-LAST:event_productCard4MouseClicked

    private void productCard5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productCard5MouseClicked
       produkDisplay page = new produkDisplay(
            this, true, 
            listBarang[4], user,
            listBarang[4].getImgPath()
       );
       page.setVisible(true);
    }//GEN-LAST:event_productCard5MouseClicked

    private void updatePaginatorMsg() {
        dashboardPaginatorMsg.setText(String.format(
           "Menampilkan %d dari %d barang", 
            Math.min(((paginatorIndex + 1)*5), maxBarang), 
            maxBarang
        ));
    }
    private void dashboardNextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardNextPageActionPerformed
        if(paginatorIndex < (maxBarang / 5) && (paginatorIndex + 1)*5 != maxBarang) {
            paginatorIndex++;
            updatePaginatorMsg();
        }
        
        // Update...
        fetchItems();
        updateItemDisplay();
    }//GEN-LAST:event_dashboardNextPageActionPerformed

    private void dashboardPrevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardPrevPageActionPerformed
        if(paginatorIndex > 0) {
            paginatorIndex--;        
            updatePaginatorMsg();
        }
        
        // Update...
        fetchItems();
        updateItemDisplay();
    }//GEN-LAST:event_dashboardPrevPageActionPerformed

    private void dashboardSaldoActionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardSaldoActionButtonActionPerformed
        String tempNominal = dashboardSaldoActionValue.getText();
        int nominal;
        
        if(!tempNominal.isEmpty()) {
            try {
                nominal = Integer.valueOf(tempNominal);
                if(nominal < 0) {
                    JOptionPane.showMessageDialog(null, "Nilai tak boleh negatif", "Error!", HEIGHT);
                    return;
                }
                
                // Update interface and database
                if(isClient)updateDisplaySaldo(nominal, '+');
                else updateDisplaySaldo(nominal, '-');
                
                updateDBSaldo(this.user.getEmail(), nominal);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", HEIGHT);
            }
        }
        
        this.requestFocusInWindow();
        dashboardSaldoActionValue.setText("Masukkan nominal (contoh: 50000)");
    }//GEN-LAST:event_dashboardSaldoActionButtonActionPerformed

    private void dashboardRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardRefreshMouseEntered
        dashboardRefresh.setBackground(new Color(200, 200, 140, 1));
    }//GEN-LAST:event_dashboardRefreshMouseEntered

    private void dashboardRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardRefreshMouseExited
        dashboardRefresh.setBackground(TRANSPARENT);
    }//GEN-LAST:event_dashboardRefreshMouseExited

    private void dashboardRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardRefreshActionPerformed
        updateMaxBarang();
        fetchItems();
        updateItemDisplay();
        updatePaginatorMsg();
    }//GEN-LAST:event_dashboardRefreshActionPerformed

    private void dashboardRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardRefreshMouseClicked

    }//GEN-LAST:event_dashboardRefreshMouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(new Seller("", "", "ashdashdlashdlashas", "", 0, ""), false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelSaldoAnda;
    private javax.swing.JButton dashboardAddItem;
    private javax.swing.JButton dashboardNextPage;
    private javax.swing.JLabel dashboardPaginatorMsg;
    private javax.swing.JButton dashboardPrevPage;
    private javax.swing.JButton dashboardRefresh;
    private javax.swing.JSeparator dashboardRow1;
    private javax.swing.JButton dashboardSaldoActionButton;
    private javax.swing.JLabel dashboardSaldoActionText;
    private javax.swing.JTextField dashboardSaldoActionValue;
    private javax.swing.JLabel dashboardSaldoAnda;
    private javax.swing.JLabel dashboardTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel productCard1;
    private javax.swing.JPanel productCard2;
    private javax.swing.JPanel productCard3;
    private javax.swing.JPanel productCard4;
    private javax.swing.JPanel productCard5;
    private javax.swing.JPanel productImage1;
    private javax.swing.JPanel productImage2;
    private javax.swing.JPanel productImage3;
    private javax.swing.JPanel productImage4;
    private javax.swing.JPanel productImage5;
    private javax.swing.JLabel productImg1;
    private javax.swing.JLabel productImg2;
    private javax.swing.JLabel productImg3;
    private javax.swing.JLabel productImg4;
    private javax.swing.JLabel productImg5;
    private javax.swing.JLabel productName1;
    private javax.swing.JLabel productName2;
    private javax.swing.JLabel productName3;
    private javax.swing.JLabel productName4;
    private javax.swing.JLabel productName5;
    private javax.swing.JLabel productPrice1;
    private javax.swing.JLabel productPrice2;
    private javax.swing.JLabel productPrice3;
    private javax.swing.JLabel productPrice4;
    private javax.swing.JLabel productPrice5;
    private javax.swing.JLabel productStock1;
    private javax.swing.JLabel productStock2;
    private javax.swing.JLabel productStock3;
    private javax.swing.JLabel productStock4;
    private javax.swing.JLabel productStock5;
    private javax.swing.JLabel productVendor1;
    private javax.swing.JLabel productVendor2;
    private javax.swing.JLabel productVendor3;
    private javax.swing.JLabel productVendor4;
    private javax.swing.JLabel productVendor5;
    // End of variables declaration//GEN-END:variables
}
