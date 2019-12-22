/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.produk;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author MohamadEsa
 */
public interface produk_DAO extends Remote{
    //penanganan CRUD
    boolean insert (produk prd) throws RemoteException;
    boolean update (produk prd) throws RemoteException;
    boolean delete (produk prd) throws RemoteException;
    //penanganan pencarian
    produk getDataProduk(String id) throws RemoteException;
    //penangan tampil data
    List<produk> getData() throws RemoteException;
}
