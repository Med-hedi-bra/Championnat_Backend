package oo;

import java.util.Date;

public class Joueur {
	private String nom , prenom , poste;
	private Date date_naissance;
	private int equipe , id ;
	private boolean certif;
	public Joueur(int id , String nom, String prenom,String poste , Date date_naissance, int equipe, boolean certif ) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.equipe = equipe;
		this.certif = certif;
		this.id = id;
		this.date_naissance = date_naissance;
		this.poste = poste;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public int getEquipe() {
		return equipe;
	}
	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
	public boolean isCertif() {
		return certif;
	}
	public void setCertif(boolean certif) {
		this.certif = certif;
	}
	
	
}
