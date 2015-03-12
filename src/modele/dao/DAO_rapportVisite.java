/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.metier.Praticiens;
import modele.metier.Utilisateur;

/**
 *
 * @author btssio
 */
public class DAO_rapportVisite {
    
    public DAO_rapportVisite(){
        
    }
    
    public void newRapportVisite(int numRapport, int praticienNum, String date, String bilan, String motif) throws SQLException{
        
            Connexion con = new Connexion();
            String requete = "INSERT INTO RAPPORT_VISITE " + "VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.Connexion().prepareStatement(requete);
            
            
            
            java.util.Date dates;
            dates = formateDate(date);
            long t = dates.getTime();
            java.sql.Date sqlDate = new java.sql.Date(t);
      
            ps.setString(1, "a131");
            ps.setInt(2, numRapport);
            ps.setInt(3, praticienNum);
            ps.setDate(4, sqlDate);
            ps.setString(5, bilan);
            ps.setString(6, motif);
            // etc - there is a setter for each basic datatype
            ps.execute();
            ps.close();


    }
    
    private Date formateDate(String date){
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = date;
 
            
 
		Date datetest = null;
        try {
            datetest = formatter.parse(dateInString);
            System.out.println(datetest);
        } catch (ParseException ex) {
            Logger.getLogger(DAO_rapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datetest;
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
