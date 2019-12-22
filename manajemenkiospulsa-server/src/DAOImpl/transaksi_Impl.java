/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.transaksi_DAO;
import ENTITY.produk;
import ENTITY.transaksi;
import databaseAccess.databaseUtilities;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MohamadEsa
 */
public class transaksi_Impl extends UnicastRemoteObject implements transaksi_DAO{

    private Connection koneksi;
    private produk_Impl produkimple;
    
    public transaksi_Impl() throws RemoteException{
        koneksi = databaseUtilities.getkoneksi();
        produkimple = new produk_Impl();
    }
    
    @Override
    public boolean insert(transaksi trx) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql = "INSERT INTO `transaksi`(`id_transaksi`, `waktu_trx`, `tanggal_trx`, "
                + "`kode_produk`, `keterangan_produk`, `no_tujuan`, `harga`, `status_trx`, "
                + "`tgl_bayar`, `no_sn`, `keterangan`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            pr.setString(1, trx.getId_transaksi());
            pr.setString(2, trx.getWaktu_trx());
            pr.setString(3, trx.getTanggal_trx());
            pr.setString(4, trx.getProduk().getKode_produk());
            pr.setString(5, trx.getKeterangan_produk());
            pr.setString(6, trx.getNo_tujuan());
            pr.setInt(7, trx.getHarga());
            pr.setString(8, trx.getStatus_trx());
            pr.setString(9, trx.getTgl_bayar());
            pr.setString(10, trx.getNo_voucher());
            pr.setString(11, trx.getCatatan());
            
            pr.executeUpdate();
            valid=true;
        } catch (SQLException e) {
            Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    return valid;
    }

    @Override
    public boolean update(transaksi trx) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql = "UPDATE `transaksi` SET `waktu_trx`=?,`tanggal_trx`=?,`kode_produk`=?,"
                + "`keterangan_produk`=?,`no_tujuan`=?,`harga`=?,`status_trx`=?,`tgl_bayar`=?,"
                + "`no_sn`=?,`keterangan`=? WHERE `id_transaksi`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            pr.setString(1, trx.getWaktu_trx());
            pr.setString(2, trx.getTanggal_trx());
            pr.setString(3, trx.getProduk().getKode_produk());
            pr.setString(4, trx.getKeterangan_produk());
            pr.setString(5, trx.getNo_tujuan());
            pr.setInt(6, trx.getHarga());
            pr.setString(7, trx.getStatus_trx());
            pr.setString(8, trx.getTgl_bayar());
            pr.setString(9, trx.getNo_voucher());
            pr.setString(10, trx.getCatatan());
            pr.setString(11, trx.getId_transaksi());
            
            pr.executeUpdate();
            valid=true;
        } catch (SQLException e) {
            Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    return valid;
    }

    @Override
    public boolean delete(transaksi trx) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql = "DELETE FROM `transaksi` WHERE `id_transaksi`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            
            pr.setString(1, trx.getId_transaksi());
            
            pr.executeUpdate();
            valid=true;
        } catch (SQLException e) {
            Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    return valid;
    }

    @Override
    public transaksi getDataTrx(String id) throws RemoteException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        transaksi tr = null;
        
        String SQL = "SELECT * FROM `transaksi` WHERE `id_transaksi`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(SQL);
            pr.setString(1, id);
            rs = pr.executeQuery();
            
            while (rs.next()) {
                tr = new transaksi();
                tr.setId_transaksi(rs.getString("`id_transaksi`"));
                tr.setWaktu_trx(rs.getString("`waktu_trx`"));
                tr.setTanggal_trx(rs.getString("`tanggal_trx`"));
                produk ID = produkimple.getDataProduk(rs.getString("`kode_produk`"));
                tr.setProduk(ID);
                tr.setKeterangan_produk(rs.getString("`keterangan_produk`"));
                tr.setNo_tujuan(rs.getString("`no_tujuan`"));
                tr.setHarga(rs.getInt("`harga`"));
                tr.setStatus_trx(rs.getString("`status_trx`"));
                tr.setTgl_bayar(rs.getString("`tgl_bayar`"));
                tr.setNo_voucher(rs.getString("`no_sn`"));
                tr.setCatatan(rs.getString("`keterangan`"));
            }
            return tr;
        } catch (SQLException e) {
             Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE, null, e);
             return null;
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public List<transaksi> getData() throws RemoteException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<transaksi> list = new ArrayList<>();
        
        String SQL = "SELECT * FROM `transaksi`";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(SQL);
            rs = pr.executeQuery();
            
            while (rs.next()) {
                transaksi tr = new transaksi();
                tr.setId_transaksi(rs.getString("`id_transaksi`"));
                tr.setWaktu_trx(rs.getString("`waktu_trx`"));
                tr.setTanggal_trx(rs.getString("`tanggal_trx`"));
                produk ID = produkimple.getDataProduk(rs.getString("`kode_produk`"));
                tr.setProduk(ID);
                tr.setKeterangan_produk(rs.getString("`keterangan_produk`"));
                tr.setNo_tujuan(rs.getString("`no_tujuan`"));
                tr.setHarga(rs.getInt("`harga`"));
                tr.setStatus_trx(rs.getString("`status_trx`"));
                tr.setTgl_bayar(rs.getString("`tgl_bayar`"));
                tr.setNo_voucher(rs.getString("`no_sn`"));
                tr.setCatatan(rs.getString("`keterangan`"));
                list.add(tr);
            }
            return list;
        } catch (SQLException e) {
             Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE, null, e);
             return null;
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(transaksi_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
    
}
