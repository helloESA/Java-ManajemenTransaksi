/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manajemenkiospulsa.client;

import DAO.autoNumber_DAO;
import DAO.produk_DAO;
import DAO.transaksi_DAO;
import DAO.userAccount_DAO;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import viewForm.StartProgram;
import viewForm.dashboard_utama;

/**
 *
 * @author MohamadEsa
 */
public class ManajemenkiospulsaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException{
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
                if("Nimbus".equals(info.getName())){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            Logger.getLogger(dashboard_utama.class.getName()).log(Level.SEVERE, null, e);
        }
        
        
        Registry client = LocateRegistry.getRegistry("localhost", 1099);
        final userAccount_DAO uA_DAO = (userAccount_DAO) client.lookup("user");
        final autoNumber_DAO aN_DAO = (autoNumber_DAO) client.lookup("auto");
        final produk_DAO p_DAO = (produk_DAO) client.lookup("produk");
        final transaksi_DAO t_DAO = (transaksi_DAO) client.lookup("transaksi");
        
        StartProgram ss = new StartProgram();
        ss.setVisible(true);
            for(int i=0;i<100;i++){
                ss.getProgressBar().setValue(i);
                ss.getLabelProgres().setText(Integer.toString(i)+" %");
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    Logger.getLogger(ManajemenkiospulsaClient.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            ss.dispose();
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                dashboard_utama dash = new dashboard_utama();
                dash.setLocationRelativeTo(dash);
                dash.setuA_DAO(uA_DAO);
                dash.setP_DAO(p_DAO);
                dash.setT_DAO(t_DAO);
                dash.setaN_DAO(aN_DAO);
                dash.setVisible(true);
                dash.startSet();
            }
        });
        
                
    }
    
}
