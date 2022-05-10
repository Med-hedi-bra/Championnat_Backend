package DAO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Convert_date {
	public static Date utilDate_to_sqlDate(java.util.Date dateU){
		java.sql.Date sqlDate = new Date(dateU.getTime());
		return sqlDate;
		
	}
	
	public static java.util.Date string_to_utilDate(String str) {
		java.util.Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = sdf.parse(str);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		};
		return date;
	}
	public static String utilDate_to_string(java.util.Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");  
		String strDate = dateFormat.format(date); 
		return strDate;
	}
	public static java.util.Date sqlDate_to_utilDate(java.sql.Date dateSq){
		String dateS = dateSq.toString();
		java.util.Date date = string_to_utilDate(dateS);
		return date;
		
		
		
	}
}
