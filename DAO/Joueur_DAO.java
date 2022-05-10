package DAO;


import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oo.Joueur;

public class Joueur_DAO {
	public static ResultSet getAll() {
		ResultSet res = null;
		String req = "select * from joueur order by post";
		try {
			Statement st = My_Connection.conn.createStatement();
			res = st.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
	}
	public static ResultSet getAllByEquipe() {
		ResultSet res = null;
		String req = "select * from joueur order by equipe";
		try {
			Statement st = My_Connection.conn.createStatement();
			res = st.executeQuery(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return res;
	}
	
	public static ResultSet getById(int id) {
		ResultSet res = null;
		String req = "select * from joueur where id = ?";
		
		try {
			PreparedStatement st = My_Connection.conn.prepareStatement(req);
			st.setInt(1, id);
			res = st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return res;
	}
	public static void insert(Joueur j) {
		String req = "insert into joueur values(null ,? , ? ,?, ? , ? , ? )";
		int aux = 0;
		if(j.isCertif()) {
			aux = 1;
		}
		
		Date date_naissance = Convert_date.utilDate_to_sqlDate(j.getDate_naissance());
		System.out.println(date_naissance);
		try {
			
			PreparedStatement st = My_Connection.conn.prepareStatement(req);
			
			st.setString(1, j.getNom());
			st.setString(2, j.getPrenom());
			st.setString(3, j.getPoste());
			st.setDate(4,date_naissance);
			st.setInt(5, aux);
			st.setInt(6, j.getEquipe());
			st.executeUpdate();
		}
		
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void delete(int id) {
		String req = "delete from joueur where id = ?";
		try {
			PreparedStatement st = My_Connection.conn.prepareStatement(req);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
