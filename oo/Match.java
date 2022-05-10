package oo;

import java.util.Date;

public class Match {
	int id, equipe1 , equipe2 ;
	String lieu;
	Date date;
	
	public Match( int id ,int equipe1, int equipe2, String lieu, Date date) {
		super();
		this.id = id;
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
		this.lieu = lieu;
		this.date = date;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEquipe1() {
		return equipe1;
	}
	public void setEquipe1(int equipe1) {
		this.equipe1 = equipe1;
	}
	public int getEquipe2() {
		return equipe2;
	}
	public void setEquipe2(int equipe2) {
		this.equipe2 = equipe2;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
