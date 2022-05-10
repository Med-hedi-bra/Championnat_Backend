package oo;

public class Resultat {
	private int  score1 , score2 , idMatch;
	private  String details;
	public Resultat(int idMatch,int score1, int score2,  String details) {
		super();
		this.score1 = score1;
		this.score2 = score2;
		this.idMatch = idMatch;
		this.details = details;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public int getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
