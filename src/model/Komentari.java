package model;

import java.util.LinkedList;
import java.util.Observable;

public class Komentari extends Observable {
	public LinkedList<Komentar> komentari;
	
	public Komentari(LinkedList<Komentar> komentari){
		super();
		this.komentari = komentari;
	}
	
	public void dodajKomentar(Komentar arg0){
		this.komentari.add(arg0);
		this.setChanged();
		this.notifyObservers();
	}
}
