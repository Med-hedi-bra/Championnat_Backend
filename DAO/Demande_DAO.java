package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oo.Joueur;

public class Demande_DAO {

	public static int nonValider(Joueur j) {
		int res = 0;
		
		String req = "delete from demande where nom =? and prenom = ? and equipe = ?";
		Date date = Convert_date.utilDate_to_sqlDate(j.getDate_naissance());
		try {
			PreparedStatement statement = My_Connection.conn.prepareStatement(req);
			statement.setString(1, j.getNom());
			statement.setString(2, j.getPrenom());
			statement.setInt(3, j.getEquipe());
			res = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static ResultSet getAll() {
		ResultSet res = null;
		String req = "select * from demande ";
		try {
			Statement statement = My_Connection.conn.createStatement();
			res = statement.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}
	
	public static int valider(Joueur j) {
		int res = 0;
		Joueur_DAO.insert(j);
		res = nonValider(j);
		return res;
	}
	
}
