/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

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
    
public class selectAll {
       String query = "SELECT * FROM "+this.tableName;

}

   //Private
   private final static String TABLENAME = "FIRST";
}
