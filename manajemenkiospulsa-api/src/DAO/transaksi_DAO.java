/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.transaksi;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author MohamadEsa
 */
public interface transaksi_DAO extends Remote{
    //penanganan CRUD
    boolean insert (transaksi trx) throws RemoteException;
    boolean update (transaksi trx) throws RemoteException;
    boolean delete (transaksi trx) throws RemoteException;
    //penanganan pencarian
    transaksi getDataTrx(String id) throws RemoteException;
    //penanganan tampil data
    List<transaksi> getData() throws RemoteException;
}
