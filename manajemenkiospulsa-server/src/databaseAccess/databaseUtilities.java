/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MohamadEsa
 */
public class databaseUtilities{
    private static Connection koneksi;
    
    public static  Connection getkoneksi(){
            if(koneksi == null){
                try {
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/mpt_pulsa","root","");
                } catch (SQLException e) {
                    Logger.getLogger(databaseUtilities.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        return koneksi;
    }
}

