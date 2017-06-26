package model;

import java.util.ArrayList;


public class Vodic extends Korisnik {

	ArrayList <Tura> ture;
	
	public Vodic(String korIme, String lozinka, String ime, String prezime, String telefon, ArrayList<Tura> ture) {
		super(korIme, lozinka, ime, prezime, telefon);
		this.ture = ture;
	}
	
	//TO DO
	public void aktivirajTermin(Termin t){};
	public void potvrdiPrijavu(){};
	public void prikaziListuTurista(){};
	public void  potvrdiRezervaciju(){};
}
