/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.userAccount;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author MohamadEsa
 */
public interface userAccount_DAO extends Remote{
    //penanganan CRUD
    boolean insert (userAccount user) throws RemoteException;
    boolean update (userAccount user) throws RemoteException;
    boolean delete (userAccount user) throws RemoteException;
    //penanganan pencarian
    userAccount getDataUser(String id) throws RemoteException;
    //penanganan login sistem
    userAccount getUserLogin(userAccount user) throws RemoteException;
    //penanganan tampil data
    List<userAccount> getData() throws RemoteException;
    
}
