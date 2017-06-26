package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Korisnik;
import model.Tura;

public class RezultatPretrageProzor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//koliko znakova opisa da prikaze
	private static final int velicinaUvoda = 50;
	
	private LinkedList<Tura> ture;
	private Korisnik ulogovaniKorisnik;
	
	public RezultatPretrageProzor(LinkedList<Tura> ture,Korisnik ulogovaniKorisnik){
		super();
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		this.ture = ture;
		podesiVelicinu();
		podesiIzgled();
	}

	private void podesiVelicinu(){
		Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
		int sirina = (int)velicinaEkrana.getWidth();
		int visina = (int)velicinaEkrana.getHeight();
		this.setSize(sirina/2, visina/2);
	}
	
	
	private void podesiIzgled() {
		JPanel glavniPanel = new JPanel();
		BoxLayout form = new BoxLayout(glavniPanel,BoxLayout.Y_AXIS);
		glavniPanel.setLayout(form);
		JScrollPane jscroll = new JScrollPane(glavniPanel);
		for(Tura t:ture){
			glavniPanel.add(new MiniTuraIzgled(t,velicinaUvoda,ulogovaniKorisnik));
		}
		this.add(jscroll);
		
	}
	
}
