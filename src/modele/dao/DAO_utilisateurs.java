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
    public Connexion(Connexion con) {
        super(con, VISITEUR);
    }

    @Override
    public int count() throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM "+this.tableName;
        PreparedStatement counter;
        try
        {
        counter = this.con.PrepareStatement(query);
        ResultSet res = counter.executeQuery();
        res.next();
        return res.getInt("count");
        }
        catch(SQLException e){ throw e; }
    }
    
    public DAO_utilisateurs(){
        try {
            listeUtilisateur();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_utilisateurs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listeUtilisateur() throws SQLException{
        
             System.out.println("-------- Oracle JDBC Connection Testing ------");
 
		try {
 
			Class.forName("oracle.jdbc.driver.OracleDriver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("Oracle JDBC Driver Registered!");
 
		Connection connection = null;
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "GSB",
					"GSB");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	
            Statement vSt = connection.createStatement();
            // Requête de sélection
            ResultSet vRs = vSt.executeQuery("SELECT v.VIS_PRENOM FROM VISITEUR v");
            while(vRs.next()){
            String vPrenom = vRs.getString(1);
            System.out.println("Prenom="+vPrenom);
        }
    }
}
