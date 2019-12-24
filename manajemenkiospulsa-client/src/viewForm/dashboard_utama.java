/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewForm;

import DAO.autoNumber_DAO;
import DAO.produk_DAO;
import DAO.transaksi_DAO;
import DAO.userAccount_DAO;
import ENTITY.transaksi;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import viewDialog.JD_Akun;
import viewDialog.JD_InputTransaksi;
import viewDialog.JD_Produk;

/**
 *
 * @author MohamadEsa
 */
public class dashboard_utama extends javax.swing.JFrame implements DocumentListener{

    private userAccount_DAO uA_DAO;
    private produk_DAO p_DAO;
    private transaksi_DAO t_DAO;
    private autoNumber_DAO aN_DAO;
    DynamicTableModel tableModel;
    private JDynamicTable tabelData;
    private TableRowSorter<DynamicTableModel> sorter;
    
    public dashboard_utama() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Set Time">    
    public final void tampilkanJam(){
        ActionListener taskPerformer = new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            String nol_jam = "", nol_menit = "",nol_detik = "";
            String nol_hari = "", nol_bulan = "",nol_tahun = "";
            Calendar kalender = new GregorianCalendar();
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
            int nilai_hari = dateTime.getDate();
            int nilai_bulan = dateTime.getMonth()+1;
            int nilai_tahun = kalender.get(Calendar.YEAR);

            if(nilai_hari <= 9) nol_hari= "0";
            if(nilai_bulan <= 9) nol_bulan= "0";

            String hari = nol_hari + Integer.toString(nilai_hari);
            String bulan = nol_bulan + Integer.toString(nilai_bulan);
            String tahun = Integer.toString(nilai_tahun);

            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik="0";


            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);

            lbl_Time.setText(jam+":"+menit+":"+detik+" ("+hari+"/"+bulan+"/"+tahun+")");

            }
        };
        new javax.swing.Timer(1000, taskPerformer).start();
    }
    // </editor-fold>
    
    public void setuA_DAO(userAccount_DAO uA_DAO) {
        this.uA_DAO = uA_DAO;
    }

    public void setP_DAO(produk_DAO p_DAO) {
        this.p_DAO = p_DAO;
    }

    public void setT_DAO(transaksi_DAO t_DAO) {
        this.t_DAO = t_DAO;
    }

    public void setaN_DAO(autoNumber_DAO aN_DAO) {
        this.aN_DAO = aN_DAO;
    }
    
    public void startSet(){
        tampilkanJam();
        try {
            List<transaksi> t = t_DAO.getData();
            if(t != null){
                tableModel = new DynamicTableModel<>(t, transaksi.class);
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
                            transaksi get = (transaksi) tableModel.get(tabelData.convertRowIndexToView(index));
                            bt_Add.setEnabled(false);
                            bt_Update.setEnabled(true);
                            bt_Delete.setEnabled(true);
                            bt_Refresh.setEnabled(true);
                        }
                    }
                });
            }
        }   catch (RemoteException ex) {
            Logger.getLogger(dashboard_utama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reset(){
        bt_Add.setEnabled(true);
        bt_Update.setEnabled(false);
        bt_Delete.setEnabled(false);
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
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        scrolPencarian1 = new javax.swing.JScrollPane();
        scrolPencarian = new javax.swing.JScrollPane();
        tabelPencarian = new com.stripbandunk.jwidget.JDynamicTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        bt_Akun = new javax.swing.JButton();
        bt_About = new javax.swing.JButton();
        bt_Produk = new javax.swing.JButton();
        bt_ToLaporan = new javax.swing.JButton();
        bt_ExitAcc = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        lbl_Pengguna = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        bt_Add = new javax.swing.JButton();
        bt_Update = new javax.swing.JButton();
        bt_Delete = new javax.swing.JButton();
        bt_Refresh = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_exit = new javax.swing.JLabel();
        lbl_area = new javax.swing.JLabel();
        lbl_minimize = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_Time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Histori Transaksi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Cari");

        scrolPencarian.setViewportView(tabelPencarian);

        scrolPencarian1.setViewportView(scrolPencarian);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Status Pemesanan", "Tanggal Transaksi", "No Transaksi" }));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Urutkan");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrolPencarian1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(47, 47, 47)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrolPencarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jToolBar1.setBackground(new java.awt.Color(0, 51, 102));
        jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new java.awt.Insets(2, 2, 2, 2));

        bt_Akun.setForeground(new java.awt.Color(0, 0, 0));
        bt_Akun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Person.png"))); // NOI18N
        bt_Akun.setText("Akun");
        bt_Akun.setToolTipText("");
        bt_Akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AkunActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_Akun);

        bt_About.setForeground(new java.awt.Color(0, 0, 0));
        bt_About.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/About.png"))); // NOI18N
        bt_About.setText("Tentang");
        bt_About.setToolTipText("");
        bt_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AboutActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_About);

        bt_Produk.setForeground(new java.awt.Color(0, 0, 0));
        bt_Produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Red tag.png"))); // NOI18N
        bt_Produk.setText("Produk");
        bt_Produk.setToolTipText("");
        bt_Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ProdukActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_Produk);

        bt_ToLaporan.setForeground(new java.awt.Color(0, 0, 0));
        bt_ToLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Report.png"))); // NOI18N
        bt_ToLaporan.setText("Laporan");
        jToolBar1.add(bt_ToLaporan);

        bt_ExitAcc.setForeground(new java.awt.Color(0, 0, 0));
        bt_ExitAcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Exit.png"))); // NOI18N
        bt_ExitAcc.setText("Keluar Akun");
        bt_ExitAcc.setToolTipText("");
        bt_ExitAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ExitAccActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_ExitAcc);

        jToolBar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("  Nama Pengguna :");
        jToolBar2.add(jLabel2);

        lbl_Pengguna.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Pengguna.setText("  -:");
        lbl_Pengguna.setPreferredSize(new java.awt.Dimension(13, 20));
        jToolBar2.add(lbl_Pengguna);

        jToolBar3.setFloatable(false);
        jToolBar3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar3.setRollover(true);
        jToolBar3.setBorderPainted(false);

        bt_Add.setForeground(new java.awt.Color(0, 0, 0));
        bt_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        bt_Add.setText("TAMBAH");
        bt_Add.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_Add.setMargin(new java.awt.Insets(25, 15, 25, 15));
        bt_Add.setName(""); // NOI18N
        bt_Add.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_AddActionPerformed(evt);
            }
        });
        jToolBar3.add(bt_Add);

        bt_Update.setForeground(new java.awt.Color(0, 0, 0));
        bt_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Update.png"))); // NOI18N
        bt_Update.setText("PERBARUI");
        bt_Update.setEnabled(false);
        bt_Update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_Update.setMargin(new java.awt.Insets(25, 15, 25, 15));
        bt_Update.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bt_Update.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UpdateActionPerformed(evt);
            }
        });
        jToolBar3.add(bt_Update);

        bt_Delete.setForeground(new java.awt.Color(0, 0, 0));
        bt_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Delete.png"))); // NOI18N
        bt_Delete.setText("HAPUS");
        bt_Delete.setEnabled(false);
        bt_Delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_Delete.setMargin(new java.awt.Insets(25, 15, 25, 15));
        bt_Delete.setVerifyInputWhenFocusTarget(false);
        bt_Delete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(bt_Delete);

        bt_Refresh.setForeground(new java.awt.Color(0, 0, 0));
        bt_Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Refresh.png"))); // NOI18N
        bt_Refresh.setText("REFRESH");
        bt_Refresh.setFocusable(false);
        bt_Refresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_Refresh.setMargin(new java.awt.Insets(25, 15, 25, 15));
        bt_Refresh.setVerifyInputWhenFocusTarget(false);
        bt_Refresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_RefreshActionPerformed(evt);
            }
        });
        jToolBar3.add(bt_Refresh);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Manajemen Penjualan Kios Pulsa ");

        lbl_exit.setBackground(new java.awt.Color(51, 51, 51));
        lbl_exit.setForeground(new java.awt.Color(255, 255, 255));
        lbl_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exitprogram.png"))); // NOI18N
        lbl_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_exitMouseExited(evt);
            }
        });

        lbl_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maximize.png"))); // NOI18N
        lbl_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_areaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_areaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_areaMouseExited(evt);
            }
        });

        lbl_minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize.png"))); // NOI18N
        lbl_minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_minimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_minimize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_area)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_exit))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_area, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lbl_minimize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        lbl_Time.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_Time.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Time.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void bt_AkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AkunActionPerformed
        JD_Akun a = new JD_Akun(uA_DAO, aN_DAO);
        a.startMode();
    }//GEN-LAST:event_bt_AkunActionPerformed

    private void bt_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AboutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_AboutActionPerformed

    private void bt_ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ProdukActionPerformed
        JD_Produk a1 = new JD_Produk(p_DAO, aN_DAO);
        a1.startMode();
    }//GEN-LAST:event_bt_ProdukActionPerformed

    private void bt_ExitAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ExitAccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_ExitAccActionPerformed

    private void bt_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_AddActionPerformed
        JD_InputTransaksi a3 = new JD_InputTransaksi(p_DAO, aN_DAO, t_DAO);
        a3.startMode();
    }//GEN-LAST:event_bt_AddActionPerformed

    private void bt_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_UpdateActionPerformed

    private void lbl_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_exitMouseClicked

    private void lbl_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_exitMouseEntered

    private void lbl_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseExited
        lbl_exit.setToolTipText("Keluar Aplikasi");
    }//GEN-LAST:event_lbl_exitMouseExited

    private void lbl_areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_areaMouseClicked
        if(getExtendedState() == NORMAL){
            lbl_area.setToolTipText("Perkecil");
            lbl_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/restore.png")));
            setExtendedState(MAXIMIZED_BOTH);
        }
        else{
            lbl_area.setToolTipText("Perlebar");
            lbl_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maximize.png")));
            setExtendedState(NORMAL);
        }
    }//GEN-LAST:event_lbl_areaMouseClicked

    private void lbl_areaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_areaMouseEntered

    }//GEN-LAST:event_lbl_areaMouseEntered

    private void lbl_areaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_areaMouseExited
        if(getExtendedState() == NORMAL){
            lbl_area.setToolTipText("Perlebar");
        }
        else{
            lbl_area.setToolTipText("Perkecil");
        }
    }//GEN-LAST:event_lbl_areaMouseExited

    private void lbl_minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_lbl_minimizeMouseClicked

    private void bt_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_RefreshActionPerformed
        reset();
        startSet();
    }//GEN-LAST:event_bt_RefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_About;
    private javax.swing.JButton bt_Add;
    private javax.swing.JButton bt_Akun;
    private javax.swing.JButton bt_Delete;
    private javax.swing.JButton bt_ExitAcc;
    private javax.swing.JButton bt_Produk;
    private javax.swing.JButton bt_Refresh;
    private javax.swing.JButton bt_ToLaporan;
    private javax.swing.JButton bt_Update;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel lbl_Pengguna;
    private javax.swing.JLabel lbl_Time;
    private javax.swing.JLabel lbl_area;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_minimize;
    private javax.swing.JScrollPane scrolPencarian;
    private javax.swing.JScrollPane scrolPencarian1;
    private com.stripbandunk.jwidget.JDynamicTable tabelPencarian;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent de) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
