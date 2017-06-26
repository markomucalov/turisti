import java.util.Date;
import java.util.LinkedList;

import model.Komentar;
import model.Termin;
import model.Tura;
import model.Vodic;
import view.GlavniProzor;
import view.RezultatPretrageProzor;
import view.TuraProzor;

public class Main {

	public static void main(String[] args) {
		GlavniProzor gp=new GlavniProzor();
		gp.setVisible(true);
		Tura t = new Tura();
		t.naslovTure = "Nova kul tura";
		t.opisTure = "Ovo je najjaca tura ikada, uzivacete sigurno!\n Obilazice se mnogi gradovi, sto ce omoguciti veseo provod!\nPosetite nas sajt za vise informacija! Bice Vam super,videcete!";
		t.cena = 150.0;
		t.ocena = 4.5;
		t.vodic = new Vodic("Cooler","Cooler","Zoki","Smoki");
		t.komentari = new LinkedList<Komentar>();
		for(int i=0;i<10;i++){
			t.komentari.push(new Komentar(new Date(),"Komentar broj: "+(i+1),t.vodic));
			
		}
		t.termini = new LinkedList<Termin>();
		for(int i=0;i<10;i++){
			t.termini.add(new Termin(new Date(),new Date(),i+1));
		}
		TuraProzor tp = new TuraProzor(t,t.vodic);
		tp.setVisible(true);
		
		LinkedList<Tura> ture = new LinkedList<Tura>();
		for(int i=0;i<10;i++){
			ture.add(t);
		}
		
		RezultatPretrageProzor rp = new RezultatPretrageProzor(ture,t.vodic);
		rp.setVisible(true);

	}

}
