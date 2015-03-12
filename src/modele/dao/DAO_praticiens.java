/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modele.metier.Praticiens;
import modele.metier.Utilisateur;

/**
 *
 * @author btssio
 */
public class DAO_praticiens {
    
    public DAO_praticiens(){
        
    }
    
    public ArrayList<Praticiens> listePraticiens() throws SQLException{
        
            ArrayList<Praticiens> praticiens = new ArrayList<>();//Liste de praticiens 
            Connexion con = new Connexion(); //Connection a la base
            Statement vSt = con.Connexion().createStatement();
            // Requête de sélection
            ResultSet vRs = vSt.executeQuery("SELECT p.PRA_NOM, p.PRA_PRENOM, PRA_NUM FROM PRATICIEN p"); //Exucution de la requete
            
            //Parcour de la réponse
            while(vRs.next()){
                //On enregistre les praticiens
                Praticiens praticien = new Praticiens();

                String nom = vRs.getString(1);
                praticien.setNom(nom);
                
                String prenom = vRs.getString(2);
                praticien.setPrenom(prenom);
                
                int num = vRs.getInt(3);
                praticien.setNum(num);

                praticiens.add(praticien);
            
            }
            return praticiens;
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
