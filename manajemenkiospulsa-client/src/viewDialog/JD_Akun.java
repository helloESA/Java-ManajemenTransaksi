/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewDialog;

import DAO.autoNumber_DAO;
import DAO.userAccount_DAO;
import ENTITY.numberField;
import ENTITY.userAccount;
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
public class JD_Akun extends javax.swing.JDialog implements DocumentListener{

    /**
     * Creates new form JD_customer
     */
    DynamicTableModel tableModel;
    private JDynamicTable tabelData;
    private userAccount_DAO uA_DAO;
    private autoNumber_DAO aN_DAO;
    private TableRowSorter<DynamicTableModel> sorter;
    
    public JD_Akun (userAccount_DAO ua_DAO, autoNumber_DAO an_DAO){
        this.uA_DAO = ua_DAO;
        this.aN_DAO = an_DAO;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void startMode(){
        try {
            List<userAccount> ua = uA_DAO.getData();
            if(ua != null){
                tableModel = new DynamicTableModel<>(ua, userAccount.class);
                tabelData = new JDynamicTable(tableModel);
                scrolPencarian.setViewportView(tabelData);
                sorter = new TableRowSorter<>(tableModel);
                tabelData.setRowSorter(sorter);
                txt_cari.getDocument().addDocumentListener(this);
                tabelData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent lse) {
                        int index = tabelData.getSelectedRow();
                        if(index != -1){
                            userAccount get = (userAccount) tableModel.get(tabelData.convertRowIndexToView(index));
                            txt_ID.setText(get.getId_akun());
                            txt_Asli.setText(get.getNama_asli());
                            cb_JK.setSelectedItem(get.getJenis_kelamin());
                            txt_Akun.setText(get.getNama_akun());
                            txt_Password.setText(get.getPassword());
                            cb_Bagian.setSelectedItem(get.getBagian());
                            txt_Alamat.setText(get.getAlamat());
                            txt_HP.setText(get.getNo_telp());
                            //penanganan tombol saat data di tabel diklik
                            txt_Asli.setEnabled(true);
                            cb_JK.setEnabled(true);
                            txt_Akun.setEnabled(true);
                            cb_Bagian.setEnabled(true);
                            txt_Alamat.setEnabled(true);
                            txt_HP.setEnabled(true);
                            btn_new.setEnabled(false);
                            btn_save.setEnabled(false);
                            btn_update.setEnabled(true);
                            btn_delete.setEnabled(true);
                            btn_reset.setEnabled(true);
                            txt_Asli.requestFocus();
                        }
                    }
                    
                });
                setVisible(true);
            }
        } catch (RemoteException e) {
            Logger.getLogger(JD_Akun.class.getName()).log(Level.SEVERE, null, e);
        }
    } 
    
    public boolean validasi(){
        boolean valid = false;
        
        if (txt_ID.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Kode Belum Diisi");
        } else if (txt_Asli.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Nama Asli Belum Isi");
        } else if (cb_JK.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(rootPane, "Jenis Kelamin Belum Diatur");
        } else if (txt_Akun.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Nama Akun Belum Isi");
        } else if (txt_Password.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Password Belum Isi");
        } else if (cb_Bagian.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(rootPane, "Bagian Belum Diatur");
        } else if (txt_Alamat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Alamat Belum Isi");
        } else if (txt_HP.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "No Telepon/HP Belum Isi");
        } else{
            valid=true;
        }
        
        return valid;
    }
    
    public userAccount getUser(){
        userAccount u = new userAccount();
        u.setId_akun(txt_ID.getText());
        u.setNama_asli(txt_Asli.getText());
        u.setJenis_kelamin(cb_JK.getSelectedItem().toString());
        u.setNama_akun(txt_Akun.getText());
        u.setPassword(txt_Password.getText());
        u.setBagian(cb_Bagian.getSelectedItem().toString());
        u.setAlamat(txt_Alamat.getText());
        u.setNo_telp(txt_HP.getText());
        return u;
    }
    
    public void reset(){
        txt_ID.setText("");
        txt_Asli.setText("");
        cb_JK.setSelectedIndex(0);
        txt_Akun.setText("");
        txt_Password.setText("");
        cb_Bagian.setSelectedIndex(0);
        txt_Alamat.setText("");
        txt_HP.setText("");
        //penanganan tombol saat data di tabel diklik
        txt_Asli.setEnabled(false);
        cb_JK.setEnabled(false);
        txt_Akun.setEnabled(false);
        txt_Password.setEnabled(false);
        cb_Bagian.setEnabled(false);
        txt_Alamat.setEnabled(false);
        txt_HP.setEnabled(false);
        btn_new.setEnabled(true);
        btn_save.setEnabled(false);
        btn_update.setEnabled(false);
        btn_delete.setEnabled(false);
        btn_reset.setEnabled(true);
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
        scrolPencarian = new javax.swing.JScrollPane();
        tabelPencarian = new com.stripbandunk.jwidget.JDynamicTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_Asli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cb_JK = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_Akun = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        cb_Bagian = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_Alamat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_HP = new javax.swing.JTextField();
        btn_new = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbl_exit1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Akun", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cari");

        scrolPencarian.setViewportView(tabelPencarian);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrolPencarian, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
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
                .addComponent(scrolPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID Akun");

        txt_ID.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama Asli");

        txt_Asli.setEnabled(false);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Jenis Kelamin");

        cb_JK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Laki-Laki", "Perempuan", "Memilih Tidak Menjawab" }));
        cb_JK.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nama Akun");

        txt_Akun.setEnabled(false);

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Password");

        txt_Password.setEnabled(false);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Bagian");

        cb_Bagian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Owner", "Admin", "Reseller" }));
        cb_Bagian.setEnabled(false);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Alamat");

        txt_Alamat.setEnabled(false);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("No HP/Tlp");

        txt_HP.setEnabled(false);

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
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_HP, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(cb_Bagian, javax.swing.GroupLayout.Alignment.LEADING, 0, 132, Short.MAX_VALUE)
                    .addComponent(txt_ID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Asli, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_JK, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                    .addComponent(txt_Akun, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Password, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Alamat, javax.swing.GroupLayout.Alignment.LEADING))
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
                    .addComponent(txt_Asli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_JK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Akun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_Bagian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_HP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_new.setText("BARU");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_reset.setText("RESET");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_save.setText("SIMPAN");
        btn_save.setEnabled(false);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_update.setText("UBAH");
        btn_update.setEnabled(false);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("HAPUS");
        btn_delete.setEnabled(false);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                    .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 21, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))))))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Kelola Akun");

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
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_exit1))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        try {
            numberField field = new numberField();
            field.setAwalan("ACC-");
            field.setNamaField("id_akun");
            field.setNamaTabel("useraccount");
            field.setPanjangField(10);
                txt_ID.setText(aN_DAO.getAutoNumber(field));
                txt_Asli.setEnabled(true);
                cb_JK.setEnabled(true);
                txt_Akun.setEnabled(true);
                txt_Password.setEnabled(true);
                cb_Bagian.setEnabled(true);
                txt_Alamat.setEnabled(true);
                txt_HP.setEnabled(true);
                btn_new.setEnabled(false);
                btn_save.setEnabled(true);
                btn_update.setEnabled(false);
                btn_delete.setEnabled(false);
                btn_reset.setEnabled(true);
        } catch (RemoteException e) {
            Logger.getLogger(JD_Akun.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        reset();
        startMode();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if(validasi()){
            userAccount ua = getUser();
            if(ua != null){
                try {
                    if(uA_DAO.insert(ua)){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
                        startMode();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(null, "Data Gagal Disimpan", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JD_Akun.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(validasi()){
            userAccount ua = getUser();
            if(ua != null){
                try {
                    if(uA_DAO.update(ua)){
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
                        startMode();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JD_Akun.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if(validasi()){
            userAccount ua = getUser();
            if(ua != null){
                int ok = JOptionPane.showConfirmDialog(null, "Yakin data ini akan dihapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if(ok == 0){
                    try {
                        if(uA_DAO.delete(ua)){
                            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Notifikasi", JOptionPane.INFORMATION_MESSAGE);
                            startMode();
                            reset();
                        } else{
                            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (RemoteException e) {
                        Logger.getLogger(JD_Akun.class.getName()).log(Level.SEVERE, null, e);
                    } 
                }
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void lbl_exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseClicked
        dispose();
    }//GEN-LAST:event_lbl_exit1MouseClicked

    private void lbl_exit1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_exit1MouseEntered

    private void lbl_exit1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exit1MouseExited
        
    }//GEN-LAST:event_lbl_exit1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_Bagian;
    private javax.swing.JComboBox<String> cb_JK;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_exit1;
    private javax.swing.JScrollPane scrolPencarian;
    private com.stripbandunk.jwidget.JDynamicTable tabelPencarian;
    private javax.swing.JTextField txt_Akun;
    private javax.swing.JTextField txt_Alamat;
    private javax.swing.JTextField txt_Asli;
    private javax.swing.JTextField txt_HP;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JPasswordField txt_Password;
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
