/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manajemenkiospulsa.server;

import DAO.autoNumber_DAO;
import DAO.produk_DAO;
import DAO.transaksi_DAO;
import DAO.userAccount_DAO;
import DAOImpl.AutoNumber_Impl;
import DAOImpl.produk_Impl;
import DAOImpl.transaksi_Impl;
import DAOImpl.userAccount_Impl;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author MohamadEsa
 */
public class ManajemenkiospulsaServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AccessException, NotBoundException{
        Registry server = LocateRegistry.createRegistry(1099);
        
        userAccount_DAO uA_DAO = (userAccount_DAO) new userAccount_Impl();
        autoNumber_DAO aN_DAO = (autoNumber_DAO) new AutoNumber_Impl();
        produk_DAO p_DAO = (produk_DAO) new produk_Impl();
        transaksi_DAO t_DAO = (transaksi_DAO) new transaksi_Impl();
        
        
        server.rebind("user", (Remote) uA_DAO);
        server.rebind("auto", (Remote) aN_DAO);
        server.rebind("produk", (Remote) p_DAO);
        server.rebind("transaksi", (Remote) t_DAO);
        
        allert_Database allert = new allert_Database();
        allert.setLocationRelativeTo(null);
        allert.setVisible(true);
        System.out.println("Database Aktif");
    }
    
}
