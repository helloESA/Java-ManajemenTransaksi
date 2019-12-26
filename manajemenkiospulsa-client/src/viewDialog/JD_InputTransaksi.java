/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewDialog;

import DAO.autoNumber_DAO;
import DAO.produk_DAO;
import DAO.transaksi_DAO;
import DAO.userAccount_DAO;
import ENTITY.numberField;
import ENTITY.produk;
import ENTITY.transaksi;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import viewForm.dashboard_utama;

/**
 *
 * @author MohamadEsa
 */
public class JD_InputTransaksi extends javax.swing.JDialog {

    /**
     * Creates new form JD_InputTransaksi
     */
    private produk produkTransaksi;
    private final produk_DAO p_DAO;
    
    private final autoNumber_DAO aN_DAO;
    private final transaksi_DAO t_DAO;
    
    
    SpinnerDateModel dateModel;
    JSpinner.DateEditor dateEditor;
    
    public JD_InputTransaksi(produk_DAO p_dao, autoNumber_DAO an_dao, transaksi_DAO t_dao) {
        this.p_DAO = p_dao;
        this.aN_DAO = an_dao;
        this.t_DAO = t_dao;
        initComponents();
        
        
    }
   
    public void startMode(){
        try {
            numberField field = new numberField();
            field.setAwalan("");
            field.setNamaField("id_transaksi");
            field.setNamaTabel("transaksi");
            field.setPanjangField(10);
                txt_ID.setText(aN_DAO.getAutoNumber(field));
            Date tgl = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");
                txt_Waktu.setText(df.format(tgl));
                lbl_Waktu.setText(formatdate.format(tgl));
                dc_tglBayar.setDate(new Date());
                
        } catch (RemoteException e) {
            Logger.getLogger(JD_InputTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
        lbl_Title.setText("Tambah Transaksi");
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void updateMode(transaksi tr){
        lbl_Title.setText("Ubah Data");
        btn_produkcari.setEnabled(false);
        produkTransaksi = tr.getProduk();
        txt_ID.setText(String.valueOf(tr.getId_transaksi()));
        txt_Waktu.setText(String.valueOf(tr.getWaktu_trx()));
        lbl_Waktu.setText(String.valueOf(tr.getTanggal_trx()));
        txt_Kode.setText(String.valueOf(tr.getProduk()));
        txt_Keterangan.setText(String.valueOf(tr.getKeterangan_produk()));
        txt_Tujuan.setText(String.valueOf(tr.getNo_tujuan()));
        txt_Harga.setText(String.valueOf(tr.getHarga()));
        cb_Status.setSelectedItem(tr.getStatus_trx());
        dc_tglBayar.setDate(tr.getTgl_bayar());
        txt_SN.setText(tr.getNo_voucher());
        txt_Note.setText(tr.getCatatan());
    }
    
    public boolean validasi(){
        boolean valid = false;
        if(txt_ID.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "ID Belum Tersedia");
        } else if (txt_Waktu.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Waktu Transaksi Masih Kosong");
        } else if (lbl_Waktu.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Tanggal Transaksi Masih Kosong");
        } else if (txt_Kode.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Kode Produk Masih Kosong");
        } else if (txt_Keterangan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Keterangan Produk Masih Kosong");
        } else if (txt_Tujuan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "No Tujuan Masih Kosong");
        } else if (txt_Harga.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Harga Produk Masih Kosong");
        } else if (cb_Status.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(rootPane, "Status Transaksi Belum Diatur");
        } else if (dc_tglBayar.getDate()==null){
            JOptionPane.showMessageDialog(rootPane, "Tanggal Bayar Masih Kosong");
        } else if (txt_SN.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "No Serial Masih Kosong");
        } else if (txt_Note.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Catatan Transaksi Masih Kosong");
        } else{
            valid = true;
        }
        return valid;
    }
    
     public transaksi getTransaksi(){
        transaksi tr = new transaksi();
        tr.setId_transaksi(txt_ID.getText());
        tr.setWaktu_trx(txt_Waktu.getText());
        tr.setTanggal_trx(lbl_Waktu.getText());
        tr.setProduk(produkTransaksi);
        tr.setKeterangan_produk(txt_Keterangan.getText());
        tr.setNo_tujuan(txt_Tujuan.getText());
        int harga = Integer.parseInt(txt_Harga.getText());
        tr.setHarga(harga);
        tr.setStatus_trx(cb_Status.getSelectedItem().toString());
        tr.setTgl_bayar(dc_tglBayar.getDate());
        tr.setNo_voucher(txt_SN.getText());
        tr.setCatatan(txt_Note.getText());
        return tr;
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
        jPanel7 = new javax.swing.JPanel();
        lbl_Title = new javax.swing.JLabel();
        lbl_exit1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Waktu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_Kode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Keterangan = new javax.swing.JTextField();
        btn_produkcari = new javax.swing.JButton();
        txt_Tujuan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Harga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_Status = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_SN = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_Note = new javax.swing.JTextField();
        lbl_Waktu = new javax.swing.JLabel();
        dc_tglBayar = new com.toedter.calendar.JDateChooser();
        btn_save = new javax.swing.JButton();
        btn_save1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Title.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Title.setText("Tambah Transaksi");

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
                .addComponent(lbl_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_exit1))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID Transaksi");

        txt_ID.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Waktu Transaksi");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Kode Produk");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Keterangan Produk");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("No Tujuan");

        btn_produkcari.setText(". . .");
        btn_produkcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_produkcariActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Harga");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Status Transaksi");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tanggal Bayar");

        cb_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Belum Membayar", "Telah Membayar" }));
        cb_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_StatusActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("No SN/Vooucher");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Keterangan");

        lbl_Waktu.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_ID, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txt_Keterangan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_Kode, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_produkcari))
                    .addComponent(txt_Tujuan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Harga, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_Waktu))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cb_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_Note, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_SN, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dc_tglBayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(cb_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dc_tglBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_SN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_produkcari)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Keterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Tujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        btn_save.setText("SIMPAN");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_save1.setText("BATAL");
        btn_save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_save1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btn_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(376, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseClicked
        dispose();
    }//GEN-LAST:event_lbl_exit1MouseClicked

    private void lbl_exit1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_exit1MouseEntered

    private void lbl_exit1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseExited

    }//GEN-LAST:event_lbl_exit1MouseExited

    private void btn_produkcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_produkcariActionPerformed
        try {
            List<produk> pro = p_DAO.getData();
            if(! pro.isEmpty()){
                DynamicTableModel tableModel= new DynamicTableModel(pro, produk.class);
                JD_Pencarian ss = new JD_Pencarian();
                ss.setTitle("Pencarian Produk");
                ss.setTableModel(tableModel);
                ss.loadPencarian();
                String putData = ss.ambilData();
                if(putData != null){
                    produkTransaksi = p_DAO.getDataProduk(putData);
                    txt_Kode.setText(produkTransaksi.getKode_produk());
                    txt_Keterangan.setText(produkTransaksi.getKeterangan_produk());
                    txt_Harga.setText(String.valueOf(produkTransaksi.getHarga_jual()));
                } else{
                    JOptionPane.showMessageDialog(rootPane, "Produk Masih Kosong");
                }
            }
        } catch (RemoteException e) {
            Logger.getLogger(JD_Pencarian.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_produkcariActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if(validasi()){
            transaksi trr = getTransaksi();
            if(trr !=null){
                try {
                    if(t_DAO.insert(trr)){
                        JOptionPane.showMessageDialog(rootPane, "Transaksi Berhasil Diproses");
                        
                        dispose();
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Transaksi Gagal Diproses");
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JD_InputTransaksi.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void cb_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_StatusActionPerformed
        
    }//GEN-LAST:event_cb_StatusActionPerformed

    private void btn_save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_save1ActionPerformed
       dispose();
    }//GEN-LAST:event_btn_save1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_produkcari;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_save1;
    private javax.swing.JComboBox<String> cb_Status;
    private com.toedter.calendar.JDateChooser dc_tglBayar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_Waktu;
    private javax.swing.JLabel lbl_exit1;
    private javax.swing.JTextField txt_Harga;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_Keterangan;
    private javax.swing.JTextField txt_Kode;
    private javax.swing.JTextField txt_Note;
    private javax.swing.JTextField txt_SN;
    private javax.swing.JTextField txt_Tujuan;
    private javax.swing.JTextField txt_Waktu;
    // End of variables declaration//GEN-END:variables
}
