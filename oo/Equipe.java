package oo;

import java.util.Date;

public class Equipe {
	private int id ;
	private String nom , lieu;
	private Date date_creation;
	public Equipe(int id, String nom, String lieu, Date date_creation) {
		super();
		this.id = id;
		this.nom = nom;
		this.lieu = lieu;
		this.date_creation = date_creation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	
}
