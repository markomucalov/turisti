package model;

import java.util.ArrayList;
import java.util.Observable;

public class Komentari extends Observable {
	public ArrayList<Komentar> komentari;
	
	public Komentari(ArrayList<Komentar> komentari){
		super();
		this.komentari = komentari;
	}
	
	public void dodajKomentar(Komentar arg0){
		this.komentari.add(arg0);
		this.setChanged();
		this.notifyObservers();
	}
}
