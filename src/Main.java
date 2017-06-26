import java.util.ArrayList;
import java.util.Date;

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
		t.setVodici(new ArrayList<Vodic>());
		t.setIdTure("Nova kul tura");
		t.setOpis("Ovo je najjaca tura ikada, uzivacete sigurno!\n Obilazice se mnogi gradovi, sto ce omoguciti veseo provod!\nPosetite nas sajt za vise informacija! Bice Vam super,videcete!");
		t.setOcena(4);
		ArrayList<Tura> ture = new ArrayList<Tura>();
		for(int i=0;i<10;i++){
			ture.add(t);
		}
		t.getVodici().add(new Vodic("Cooler","Cooler","Zoki","Smoki","",ture));
		t.setKomentari(new ArrayList<Komentar>());
		for(int i=0;i<10;i++){
			t.getKomentari().add(new Komentar(new Date(),"Komentar broj: "+(i+1),t.getVodici().get(0)));
			
		}
		t.setTermini(new ArrayList<Termin>());
		for(int i=0;i<10;i++){
			t.getTermini().add(new Termin(new Date(),new Date(),i+1));
		}
		TuraProzor tp = new TuraProzor(t,t.getVodici().get(0));
		tp.setVisible(true);
		
		
		RezultatPretrageProzor rp = new RezultatPretrageProzor(ture,t.getVodici().get(0));
		rp.setVisible(true);

	}

}
