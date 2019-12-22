/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.numberField;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author MohamadEsa
 */
public interface autoNumber_DAO extends Remote{
    //penanganan auto number
    String getAutoNumber(numberField field) throws RemoteException;
}
