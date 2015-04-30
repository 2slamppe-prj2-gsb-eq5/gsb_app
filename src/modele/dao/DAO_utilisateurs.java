/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.Utilisateur;
import oracle.jdbc.OraclePreparedStatement;

/**
 *
 * @author btssio
 */
public class DAO_utilisateurs extends Connexion {
    
    public DAO_utilisateurs(){
        
    }
    
    public ArrayList<Utilisateur> listeUtilisateur() throws SQLException{
        
            ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
            Connexion con = new Connexion();
            Statement vSt = con.Connexion().createStatement();
            // Requête de sélection
            ResultSet vRs = vSt.executeQuery("SELECT v.VIS_PRENOM, VIS_NOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, SEC_CODE, LAB_CODE FROM VISITEUR v");
            while(vRs.next()){
                Utilisateur user = new Utilisateur();

                String prenom = vRs.getString(1);
                user.setPrenom(prenom);
                
                String nom = vRs.getString(2);
                user.setNom(nom);
                
                String adresse = vRs.getString(3);
                user.setAdresse(adresse);
                
                String cp = vRs.getString(4);
                user.setCP(cp);
                
                String ville = vRs.getString(5);
                user.setVille(ville);
                
                String code = vRs.getString(6);
                user.setLabCode(code);
                
                String labo = vRs.getString(7);
                user.setLabCode(labo);

                utilisateurs.add(user);
            
            }
            return utilisateurs;
    }
    
    public String libelleSecCode(String secCode) throws SQLException{
        
            String libelleSecCode = "";
            Connexion con = new Connexion();
            Statement vSt = con.Connexion().createStatement();
            // Requête de sélection
            ResultSet vRs = vSt.executeQuery("SELECT v.VIS_PRENOM, VIS_NOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, SEC_CODE, LAB_CODE FROM VISITEUR v");
            while(vRs.next()){
                Utilisateur user = new Utilisateur();

                String prenom = vRs.getString(1);
                user.setPrenom(prenom);
                
                String nom = vRs.getString(2);
                user.setNom(nom);
                
                String adresse = vRs.getString(3);
                user.setAdresse(adresse);
                
                String cp = vRs.getString(4);
                user.setCP(cp);
                
                String ville = vRs.getString(5);
                user.setVille(ville);
                
                String code = vRs.getString(6);
                user.setLabCode(code);
                
                String labo = vRs.getString(7);
                user.setLabCode(labo);
            
            }
            return libelleSecCode;
    }
}
