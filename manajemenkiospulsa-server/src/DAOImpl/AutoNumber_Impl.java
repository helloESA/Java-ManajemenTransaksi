/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import DAO.autoNumber_DAO;
import ENTITY.numberField;
import databaseAccess.databaseUtilities;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MohamadEsa
 */
public class AutoNumber_Impl extends UnicastRemoteObject implements autoNumber_DAO{
    
    
    private Connection koneksi;
    
    public AutoNumber_Impl() throws RemoteException{
        this.koneksi = databaseUtilities.getkoneksi();
    }
    
    @Override
    public String getAutoNumber(numberField field) throws RemoteException {
        String autoCode="";
        int numer = 0;
        String strTmp="";
        int panjangAwalan=field.getAwalan().length();
        int panjangId=field.getPanjangField()-panjangAwalan;
        String sql="SELECT RIGHT("+field.getNamaField()+", "+panjangId+") AS no_terakhir FROM "+field.getNamaTabel()+" ORDER BY no_terakhir";
        try {
            PreparedStatement pr = koneksi.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs.first()==false){
                numer = 1;
            } else{
                rs.last();
                numer=rs.getInt("no_terakhir")+1;
            }
            String SNumer=String.valueOf(numer);
            int PanjangNumer=SNumer.length();
            
            for(int i=0;i<panjangId-PanjangNumer;i++){
                strTmp=strTmp+"0";
            }
            autoCode=field.getAwalan()+strTmp+numer;
        } catch (SQLException e) {
            Logger.getLogger(AutoNumber_Impl.class.getName()).log(Level.SEVERE, null, e);
        }
        return autoCode;
    }
}
