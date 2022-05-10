package oo;

public class Classement {
	private int id_equipe , match_joue , gagnant , perdu , egalite ,buts , points;

	public Classement(int id_equipe, int match_joue, int gagnant, int perdu, int egalite, int buts, int points) {
		super();
		this.id_equipe = id_equipe;
		this.match_joue = match_joue;
		this.gagnant = gagnant;
		this.perdu = perdu;
		this.egalite = egalite;
		this.buts = buts;
		this.points = points;
	}

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}

	public int getMatch_joue() {
		return match_joue;
	}

	public void setMatch_joue(int match_joue) {
		this.match_joue = match_joue;
	}

	public int getGagnant() {
		return gagnant;
	}

	public void setGagnant(int gagnant) {
		this.gagnant = gagnant;
	}

	public int getPerdu() {
		return perdu;
	}

	public void setPerdu(int perdu) {
		this.perdu = perdu;
	}

	public int getEgalite() {
		return egalite;
	}

	public void setEgalite(int egalite) {
		this.egalite = egalite;
	}

	public int getButs() {
		return buts;
	}

	public void setButs(int buts) {
		this.buts = buts;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Classement [id_equipe=" + id_equipe + ", match_joue=" + match_joue + ", gagnant=" + gagnant + ", perdu="
				+ perdu + ", egalite=" + egalite + ", buts=" + buts + ", points=" + points + "]";
	}
	
	
}
