/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewDialog;

import DAO.autoNumber_DAO;
import DAO.produk_DAO;
import ENTITY.numberField;
import ENTITY.produk;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author MohamadEsa
 */
public class JD_Produk extends javax.swing.JDialog implements DocumentListener{

    /**
     * Creates new form JD_Produk
     */
    DynamicTableModel tableModel;
    private JDynamicTable tabelData;
    private produk_DAO p_DAO;
    private autoNumber_DAO aN_DAO;
    private TableRowSorter<DynamicTableModel> sorter;
    
    public JD_Produk(produk_DAO p_dao, autoNumber_DAO an_dao){
        this.p_DAO = p_dao;
        this.aN_DAO = an_dao;
        initComponents();
    }

    public void startMode(){
        try {
            List<produk> p = p_DAO.getData();
            if(p != null){
                tableModel = new DynamicTableModel<>(p, produk.class);
                tabelData = new JDynamicTable(tableModel);
                tabelProduk.setViewportView(tabelData);
                sorter = new TableRowSorter<>(tableModel);
                tabelData.setRowSorter(sorter);
                txt_cari.getDocument().addDocumentListener(this);
                tabelData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent lse) {
                        int index = tabelData.getSelectedRow();
                        if(index != -1){
                            produk get = (produk) tableModel.get(tabelData.convertRowIndexToView(index));
                            txt_ID.setText(get.getId());
                            txt_Kode.setText(get.getKode_produk());
                            txt_Provider.setText(get.getProvider());
                            txt_Keterangan.setText(get.getKeterangan_produk());
                            txt_Harga.setText(String.valueOf(get.getHarga_jual()));
                            //penanganan tombol saat data di tabel diklik
                            txt_Kode.setEnabled(true);
                            txt_Provider.setEnabled(true);
                            txt_Keterangan.setEnabled(true);
                            txt_Harga.setEnabled(true);
                            bt_new.setEnabled(false);
                            bt_save.setEnabled(false);
                            bt_update.setEnabled(true);
                            bt_delete.setEnabled(true);
                            bt_reset.setEnabled(true);
                            
                        }
                    }
                });
                setVisible(true);
                setLocationRelativeTo(null);
            }
        } catch (RemoteException e) {
            Logger.getLogger(JD_Produk.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public boolean validasi(){
        boolean valid = false;
        if (txt_ID.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "ID Belum Diisi");
        } else if (txt_Kode.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Kode Produk Belum Diisi");
        } else if (txt_Provider.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Provider Belum Diisi");
        } else if (txt_Keterangan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Keterangan Produk Produk Belum Diisi");
        } else if (txt_Harga.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Harga Belum Diisi");
        } else{
            valid = true;
        }
        return valid;
    }
    
    public produk getProduk(){
        produk p = new produk();
        p.setId(txt_ID.getText());
        p.setKode_produk(txt_Kode.getText());
        p.setProvider(txt_Provider.getText());
        p.setKeterangan_produk(txt_Keterangan.getText());
        int harga = Integer.parseInt(txt_Harga.getText());
        p.setHarga_jual(harga);
        return p;
    }
    
    public void reset(){
        txt_ID.setText("");
        txt_Kode.setText("");
        txt_Provider.setText("");
        txt_Keterangan.setText("");
        txt_Harga.setText("");
        //penanganan tombol
        txt_Kode.setEnabled(false);
        txt_Provider.setEnabled(false);
        txt_Keterangan.setEnabled(false);
        txt_Harga.setEnabled(false);
        bt_new.setEnabled(true);
        bt_save.setEnabled(false);
        bt_update.setEnabled(false);
        bt_delete.setEnabled(false);
        bt_reset.setEnabled(true);
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
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        tabelProduk = new javax.swing.JScrollPane();
        tabelPencarian = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Kode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Provider = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_Keterangan = new javax.swing.JTextField();
        txt_Harga = new javax.swing.JTextField();
        bt_new = new javax.swing.JButton();
        bt_reset = new javax.swing.JButton();
        bt_save = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_exit1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Produk", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cari");

        tabelProduk.setViewportView(tabelPencarian);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabelProduk, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tabelProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID");

        txt_ID.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Kode Produk");

        txt_Kode.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Provider");

        txt_Provider.setEnabled(false);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Keterangan");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Harga Jual");

        txt_Keterangan.setEnabled(false);

        txt_Harga.setEnabled(false);
        txt_Harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_HargaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_HargaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(txt_Kode, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Provider, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Keterangan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Harga))
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Provider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_Keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        bt_new.setText("BARU");
        bt_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_newActionPerformed(evt);
            }
        });

        bt_reset.setText("RESET");
        bt_reset.setEnabled(false);
        bt_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_resetActionPerformed(evt);
            }
        });

        bt_save.setText("SIMPAN");
        bt_save.setEnabled(false);
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });

        bt_update.setText("UBAH");
        bt_update.setEnabled(false);
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_delete.setText("HAPUS");
        bt_delete.setEnabled(false);
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_new, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_save, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(bt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bt_new, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bt_save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 9, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Kelola Produk");

        lbl_exit1.setBackground(new java.awt.Color(51, 51, 51));
        lbl_exit1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_exit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitprogram.png"))); // NOI18N
        lbl_exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_exit1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_exit1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_exit1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_exit1))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lbl_exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_newActionPerformed
        try {
            numberField field = new numberField();
            field.setAwalan("");
            field.setNamaField("id");
            field.setNamaTabel("produk");
            field.setPanjangField(10);
                txt_ID.setText(aN_DAO.getAutoNumber(field));
                txt_Kode.setEnabled(true);
                txt_Provider.setEnabled(true);
                txt_Keterangan.setEnabled(true);
                txt_Harga.setEnabled(true);
                bt_new.setEnabled(false);
                bt_save.setEnabled(true);
                bt_update.setEnabled(false);
                bt_delete.setEnabled(false);
                bt_reset.setEnabled(true);
        } catch (RemoteException e) {
            Logger.getLogger(JD_Produk.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_bt_newActionPerformed

    private void bt_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_resetActionPerformed
        reset();
        startMode();
    }//GEN-LAST:event_bt_resetActionPerformed

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        if(validasi()){
            produk pr = getProduk();
            if(pr != null){
                try {
                    if(p_DAO.insert(pr)){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
                        startMode();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JD_Produk.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        if(validasi()){
            produk pr = getProduk();
            if(pr != null){
                try {
                    if(p_DAO.update(pr)){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
                        startMode();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(null, "Data Gagal Diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JD_Produk.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        if(validasi()){
            produk pr = getProduk();
            if(pr != null){
                try {
                    if(p_DAO.delete(pr)){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
                        startMode();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JD_Produk.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void lbl_exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseClicked
        dispose();
    }//GEN-LAST:event_lbl_exit1MouseClicked

    private void lbl_exit1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_exit1MouseEntered

    private void lbl_exit1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseExited
        
    }//GEN-LAST:event_lbl_exit1MouseExited

    private void txt_HargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_HargaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HargaKeyPressed

    private void txt_HargaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_HargaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_HargaKeyReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_new;
    private javax.swing.JButton bt_reset;
    private javax.swing.JButton bt_save;
    private javax.swing.JButton bt_update;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_exit1;
    private com.stripbandunk.jwidget.JDynamicTable tabelPencarian;
    private javax.swing.JScrollPane tabelProduk;
    private javax.swing.JTextField txt_Harga;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_Keterangan;
    private javax.swing.JTextField txt_Kode;
    private javax.swing.JTextField txt_Provider;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables

    public void saring(){
        String text=txt_cari.getText();
        if(text.length()==0){
            sorter.setRowFilter(null);
        }else{
            sorter.setRowFilter(RowFilter.regexFilter(Pattern.compile("(?i).*"+text+".*", 
                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL).toString()
                   ));
        }
    }
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        saring();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        saring();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        saring();
    }
}
