package model;

import java.util.Date;

public class Komentar {
	
	private String sadrzina;
	private Date datumObjave;
	private Tura tura;
	private Korisnik korisnik;
	
	
	public Komentar(String sadrzina, Date datumObjave, Tura tura, Korisnik korisnik) {
		super();
		this.sadrzina = sadrzina;
		this.datumObjave = datumObjave;
		this.tura = tura;
		this.korisnik = korisnik;
	}


	public String getSadrzina() {
		return sadrzina;
	}


	public void setSadrzina(String sadrzina) {
		this.sadrzina = sadrzina;
	}


	public Date getDatumObjave() {
		return datumObjave;
	}


	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
	}


	public Tura getTura() {
		return tura;
	}


	public void setTura(Tura tura) {
		this.tura = tura;
	}


	public Korisnik getKorisnik() {
		return korisnik;
	}


	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	

}
