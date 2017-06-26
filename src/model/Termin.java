package model;

import java.util.ArrayList;

public class Termin {

	private String pocetakTutre;
	private String krajTure;
	private int brojSlobodnihMesta;
	private boolean aktivan;
	private double cena;
	private ArrayList<Rezervacija> rezervacije;

	public Termin() {
		super();
	}

	public Termin(String pocetakTutre, String krajTure, int brojSlobodnihMesta, boolean aktivan, double cena,
			ArrayList<Rezervacija> rezervacije) {
		super();
		this.pocetakTutre = pocetakTutre;
		this.krajTure = krajTure;
		this.brojSlobodnihMesta = brojSlobodnihMesta;
		this.aktivan = aktivan;
		this.cena = cena;
		this.rezervacije = rezervacije;
	}

	public String getPocetakTutre() {
		return pocetakTutre;
	}

	public void setPocetakTutre(String pocetakTutre) {
		this.pocetakTutre = pocetakTutre;
	}

	public String getKrajTure() {
		return krajTure;
	}

	public void setKrajTure(String krajTure) {
		this.krajTure = krajTure;
	}

	public int getBrojSlobodnihMesta() {
		return brojSlobodnihMesta;
	}

	public void setBrojSlobodnihMesta(int brojSlobodnihMesta) {
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}
}
