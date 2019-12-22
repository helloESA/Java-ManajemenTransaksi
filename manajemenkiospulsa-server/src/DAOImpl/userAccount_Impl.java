/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.userAccount_DAO;
import ENTITY.userAccount;
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
public class userAccount_Impl extends UnicastRemoteObject implements userAccount_DAO{

    
    private Connection koneksi;
    
    public userAccount_Impl() throws RemoteException{
        koneksi = databaseUtilities.getkoneksi();
    }
    
    @Override
    public boolean insert(userAccount user) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql="INSERT INTO `useraccount`(`id_akun`, `nama_asli`, `jenis_kelamin`, `nama_akun`, `password`, `bagian`, `alamat`, `no_telp`) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            pr.setString(1, user.getId_akun());
            pr.setString(2, user.getNama_asli());
            pr.setString(3, user.getJenis_kelamin());
            pr.setString(4, user.getNama_akun());
            pr.setString(5, user.getPassword());
            pr.setString(6, user.getBagian());
            pr.setString(7, user.getAlamat());
            pr.setString(8, user.getNo_telp());
            
            pr.executeUpdate();
            valid = true;
        } catch (SQLException e) {
            Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean update(userAccount user) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql="UPDATE `useraccount` SET `nama_asli`=?,`jenis_kelamin`=?,`nama_akun`=?,"
                + "`password`=?,`bagian`=?,`alamat`=?,`no_telp`=? WHERE `id_akun`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            pr.setString(1, user.getNama_asli());
            pr.setString(2, user.getJenis_kelamin());
            pr.setString(3, user.getNama_akun());
            pr.setString(4, user.getPassword());
            pr.setString(5, user.getBagian());
            pr.setString(6, user.getAlamat());
            pr.setString(7, user.getNo_telp());
            pr.setString(8, user.getId_akun());
            
            pr.executeUpdate();
            valid = true;
        } catch (SQLException e) {
            Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean delete(userAccount user) throws RemoteException {
        PreparedStatement pr = null;
        boolean valid = false;
        
        String sql="DELETE FROM `useraccount` WHERE `id_akun`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(sql);
            pr.setString(1, user.getId_akun());
            
            pr.executeUpdate();
            valid = true;
        } catch (SQLException e) {
            Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
        return valid;
    }

    @Override
    public userAccount getDataUser(String id) throws RemoteException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        userAccount acc = null;
        
        String SQL = "SELECT * FROM `useraccount` WHERE `id_akun`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(SQL);
            
            pr.setString(1, id);
            rs=pr.executeQuery();
            
            while (rs.next()) {
                acc = new userAccount();
                acc.setId_akun(rs.getString("id_akun"));
                acc.setNama_asli(rs.getString("nama_asli"));
                acc.setJenis_kelamin(rs.getString("jenis_kelamin"));
                acc.setNama_akun(rs.getString("nama_akun"));
                acc.setPassword(rs.getString("password"));
                acc.setBagian(rs.getString("bagian"));
                acc.setAlamat(rs.getString("alamat"));
                acc.setNo_telp(rs.getString("no_telp"));
            }
            return acc;
        } catch (SQLException e) {
            Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
            return null;
        } finally {
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public userAccount getUserLogin(userAccount user) throws RemoteException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        userAccount acc = null;
        
        String SQL = "SELECT * FROM `useraccount` WHERE `nama_akun`=? AND `password`=?";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(SQL);
            
            pr.setString(1, acc.getNama_akun());
            pr.setString(2, acc.getPassword());
            rs=pr.executeQuery();
            
            while (rs.next()) {
                acc = new userAccount();
                acc.setId_akun(rs.getString("id_akun"));
                acc.setNama_asli(rs.getString("nama_asli"));
                acc.setJenis_kelamin(rs.getString("jenis_kelamin"));
                acc.setNama_akun(rs.getString("nama_akun"));
                acc.setPassword(rs.getString("password"));
                acc.setBagian(rs.getString("bagian"));
                acc.setAlamat(rs.getString("alamat"));
                acc.setNo_telp(rs.getString("no_telp"));
            }
            return acc;
        } catch (SQLException e) {
            Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
            return null;
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }

    @Override
    public List<userAccount> getData() throws RemoteException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        List<userAccount> list = new ArrayList<>();
        
        String SQL = "SELECT * FROM `useraccount`";
        try {
            pr = (PreparedStatement) koneksi.prepareStatement(SQL);
            rs=pr.executeQuery();
            
            while (rs.next()) {
                userAccount acc = new userAccount();
                acc.setId_akun(rs.getString("id_akun"));
                acc.setNama_asli(rs.getString("nama_asli"));
                acc.setJenis_kelamin(rs.getString("jenis_kelamin"));
                acc.setNama_akun(rs.getString("nama_akun"));
                acc.setPassword(rs.getString("password"));
                acc.setBagian(rs.getString("bagian"));
                acc.setAlamat(rs.getString("alamat"));
                acc.setNo_telp(rs.getString("no_telp"));
                list.add(acc);
            }
            return list;
        } catch (SQLException e) {
            Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
            return null;
        } finally{
            if(pr != null){
                try {
                    pr.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(userAccount_Impl.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }
}
