package model;

import java.util.ArrayList;

public class Tura {
	
	
	private String idTure;
	private String opis;
	private int ocena;
	private int minBrojMesta;
	private ArrayList<Termin> termini;
	private ArrayList<Vodic> vodici;
	private ArrayList<Komentar> komentari;
	private ArrayList<Mesto> gradovi;
	private ArrayList<Destinacija> destinacije;
	
	
	public Tura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tura(String idTure, String opis, int ocena, int minBrojMesta, ArrayList<Termin> termini,
			ArrayList<Vodic> vodici, ArrayList<Komentar> komentari, ArrayList<Mesto> gradovi,
			ArrayList<Destinacija> destinacije) {
		super();
		this.idTure = idTure;
		this.opis = opis;
		this.ocena = ocena;
		this.minBrojMesta = minBrojMesta;
		this.termini = termini;
		this.vodici = vodici;
		this.komentari = komentari;
		this.gradovi = gradovi;
		this.destinacije = destinacije;
	}
	public String getIdTure() {
		return idTure;
	}
	public void setIdTure(String idTure) {
		this.idTure = idTure;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public int getMinBrojMesta() {
		return minBrojMesta;
	}
	public void setMinBrojMesta(int minBrojMesta) {
		this.minBrojMesta = minBrojMesta;
	}
	public ArrayList<Termin> getTermini() {
		return termini;
	}
	public void setTermini(ArrayList<Termin> termini) {
		this.termini = termini;
	}
	public ArrayList<Vodic> getVodici() {
		return vodici;
	}
	public void setVodici(ArrayList<Vodic> vodici) {
		this.vodici = vodici;
	}
	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}
	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}
	public ArrayList<Mesto> getGradovi() {
		return gradovi;
	}
	public void setGradovi(ArrayList<Mesto> gradovi) {
		this.gradovi = gradovi;
	}
	public ArrayList<Destinacija> getDestinacije() {
		return destinacije;
	}
	public void setDestinacije(ArrayList<Destinacija> destinacije) {
		this.destinacije = destinacije;
	}

	
}
