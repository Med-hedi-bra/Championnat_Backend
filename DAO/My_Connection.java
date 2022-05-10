package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class My_Connection {
	public static Connection conn;
	public  My_Connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11491230?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String root ="sql11491230";
		String pwd = "S3tcNeRGbG";
		/*String url = "jdbc:mysql://localhost/gChampionat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String root ="root";
		String pwd = "";*/
		try {
			conn = DriverManager.getConnection(url , root , pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
