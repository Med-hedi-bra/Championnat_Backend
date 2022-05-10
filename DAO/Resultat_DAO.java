package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oo.Resultat;

public class Resultat_DAO {
	public static int insert(Resultat m) {
		int res = 0;
		
		String req ="insert into resultat values(null, ? ,? ,? ,?);";
		try {
			PreparedStatement statement = My_Connection.conn.prepareStatement(req);
			statement.setInt(1, m.getIdMatch());
			statement.setInt(2, m.getScore1());
			statement.setInt(3, m.getScore2());
			statement.setString(4, m.getDetails());
			res = statement.executeUpdate();
			Classement_DAO.update(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	

	
	public static int delete (Resultat m) {
		int res = 0;
		String req = "delete from resultat where id_match = ?";
		try {
			Classement_DAO.delete(m);
			PreparedStatement statement = My_Connection.conn.prepareStatement(req);
			statement.setInt(1, m.getIdMatch());
			res = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return res;
	}
	
	public static ResultSet getAll() {
		ResultSet res = null;
		String req = "select * from resultat";
		try {
			Statement statement = My_Connection.conn.createStatement();
			res = statement.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static ResultSet getById(int id) {
		ResultSet res = null;
		String req = "select * from resultat where id_match = ?";
		try {
			PreparedStatement statement = My_Connection.conn.prepareStatement(req);
			statement.setInt(1, id);
			res = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}
