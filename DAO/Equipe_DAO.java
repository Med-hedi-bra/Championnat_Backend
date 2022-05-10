package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.omg.CORBA.Request;

import oo.Equipe;

public class Equipe_DAO {
	public static int insert(Equipe e) {
		int res = 0 , idequipe=0 ;
		String req = "insert into equipe values( null ,?  , ? , ?)";
		Date dt = Convert_date.utilDate_to_sqlDate(e.getDate_creation());
		
		try {
			PreparedStatement st = My_Connection.conn.prepareStatement(req);
			st.setString(1, e.getNom());
			st.setString(2, e.getLieu());
			st.setDate(3, dt);
			res = st.executeUpdate();
			// AJouter l'equipe à la table de classement
			String req1 = "SELECT * FROM equipe ORDER BY id DESC LIMIT 1";
			Statement statement = My_Connection.conn.createStatement();
			ResultSet res1 = statement.executeQuery(req1);
			while(res1.next()) {
				idequipe = res1.getInt("id");
			}
			Classement_DAO.insert(idequipe);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return res;
		
	}
	
	public static int delete(int id) {
		int res = 0;
		String req = "delete from equipe where id = ?";
		try {
			PreparedStatement st  = My_Connection.conn.prepareStatement(req);
			st.setInt(1, id);
			res = st.executeUpdate();
			// retirer l'équipe de la table classement
			Classement_DAO.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}


public static int update (Equipe e) {
	int res = 0;
	String req = "update equipe set nom = ? , stade = ? , date_creation = ? where id = ?";
	Date date = Convert_date.utilDate_to_sqlDate(e.getDate_creation());
	
	try {
		PreparedStatement statement = My_Connection.conn.prepareStatement(req);
		statement.setString(1 ,e.getNom());
		statement.setString(2, e.getLieu());
		statement.setDate(3, date);
		statement.setInt(4, e.getId());
		res = statement.executeUpdate();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	return res;
}

public static ResultSet getAll() {
	ResultSet res = null;
	String req = "select * from equipe";
	try {
		Statement statement = My_Connection.conn.createStatement();
		res = statement.executeQuery(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return res ;
}




public static ResultSet getById(int id) {
	ResultSet res = null;
	String req = "select * from equipe where id = ?";
	try {
		
			PreparedStatement statement = My_Connection.conn.prepareStatement(req);
			statement.setInt(1, id);
			res = statement.executeQuery(req);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return res ;
}

}
