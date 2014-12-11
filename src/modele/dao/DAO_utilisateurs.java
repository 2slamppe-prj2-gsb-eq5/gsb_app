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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.Utilisateur;

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
    
    public ArrayList<Utilisateur> listeUtilisateur() throws SQLException{
        
            ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
            Statement vSt = super.Connexion().createStatement();
            // Requête de sélection
            ResultSet vRs = vSt.executeQuery("SELECT v.VIS_MATRICULE, v.VIS_NOM, v.VIS_PRENOM, v.VIS_ADRESSE, v.VIS_CP, v.VIS_VILLE, v.VIS_DATEEMBAUCHE, v.SEC_CODE v.LAB_CODE FROM VISITEUR v");
            while(vRs.next()){
            Utilisateur user = new Utilisateur();
            String matricule = vRs.getString(1);
            String nom = vRs.getString(2);
            String prenom = vRs.getString(3);
            String adresse = vRs.getString(4);
            String cp = vRs.getString(5);
            String ville = vRs.getString(6);
            String dateEmbauche = vRs.getString(7);
            String secCode = vRs.getString(8);
            String labCode = vRs.getString(9);
            utilisateurs.add(user);
            
        }
            return utilisateurs;
    }
}
