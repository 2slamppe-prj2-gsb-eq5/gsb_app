/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author btssio
 */
public class DAO_utilisateurs extends Connexion {
    
    public DAO_utilisateurs(){
        try {
            listeUtilisateur();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_utilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listeUtilisateur() throws SQLException{
        
            Statement vSt = super.Connexion().createStatement();
            // Requête de sélection
            ResultSet vRs = vSt.executeQuery("SELECT v.VIS_PRENOM FROM VISITEUR v");
            while(vRs.next()){
            String vPrenom = vRs.getString(1);
            
            System.out.println("Prenom="+vPrenom);
        }
    }
}
