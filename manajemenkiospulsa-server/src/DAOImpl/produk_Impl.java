/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.produk_DAO;
import ENTITY.produk;
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
public class produk_Impl extends UnicastRemoteObject implements produk_DAO{

    
    private final Connection koneksi;
    
    public produk_Impl() throws RemoteException{
        koneksi = databaseUtilities.getkoneksi();
    }
    
    @Override
    public boolean insert(produk prd) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql = "INSERT INTO `produk`(`id`, `kode_produk`, `provider`, `keterangan_produk`, `harga_jual`) "
                + "VALUES (?,?,?,?,?)";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            pr.setString(1, prd.getId());
            pr.setString(2, prd.getKode_produk());
            pr.setString(3, prd.getProvider());
            pr.setString(4, prd.getKeterangan_produk());
            pr.setInt(5, prd.getHarga_jual());
            
            pr.executeUpdate();
            valid = true;
        } catch (SQLException e) {
            Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean update(produk prd) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql = "UPDATE `produk` SET `kode_produk`=?,`provider`=?,"
                + "`keterangan_produk`=?,`harga_jual`=? WHERE `id`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            pr.setString(1, prd.getKode_produk());
            pr.setString(2, prd.getProvider());
            pr.setString(3, prd.getKeterangan_produk());
            pr.setInt   (4, prd.getHarga_jual());
            pr.setString(5, prd.getId());
            
            pr.executeUpdate();
            valid = true;
        } catch (SQLException e) {
            Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean delete(produk prd) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql = "DELETE FROM `produk` WHERE `id`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            pr.setString(1, prd.getId());
            
            pr.executeUpdate();
            valid = true;
        } catch (SQLException e) {
            Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            if (pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return valid;
    }

    @Override
    public produk getDataProduk(String id) throws RemoteException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        produk prd = null;
        
        String SQL = "SELECT * FROM `produk` WHERE kode_produk=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(SQL);
            pr.setString(1, id);
            rs=pr.executeQuery();
            
            while (rs.next()) {
                prd = new produk();
                prd.setId(rs.getString("id"));
                prd.setKode_produk(rs.getString("kode_produk"));
                prd.setProvider(rs.getString("provider"));
                prd.setKeterangan_produk(rs.getString("keterangan_produk"));
                prd.setHarga_jual(rs.getInt("harga_jual"));
            }
            return prd;
        } catch (SQLException e) {
            Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            if (pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<produk> getData() throws RemoteException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<produk> list = new ArrayList<>();
        
        String SQL = "SELECT * FROM `produk`";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(SQL);
            rs=pr.executeQuery();
            
            while (rs.next()) {
                produk p = new produk();
                p.setId(rs.getString("id"));
                p.setKode_produk(rs.getString("kode_produk"));
                p.setProvider(rs.getString("provider"));
                p.setKeterangan_produk(rs.getString("keterangan_produk"));
                p.setHarga_jual(rs.getInt("harga_jual"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally {
            if (pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(produk_Impl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
}
