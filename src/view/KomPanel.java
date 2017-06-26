package view;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Komentar;
import model.Komentari;
import model.Korisnik;

public class KomPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private Komentari komentari;
	private Korisnik ulogovaniKorisnik;
	private JButton dodajKomentarDugme;
	private JPanel panel;
	
	
	private void pokreniDodajKomentarDialog(){
		DodajKomDialog  komDialog = new DodajKomDialog(this.komentari,this.ulogovaniKorisnik);
		komDialog.setVisible(true);
	}
	
	
	KomPanel(ArrayList<Komentar> komentari2,Korisnik ulogovaniKorisnik){
		this.komentari = new Komentari(komentari2);
		this.komentari.addObserver(this);
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		
		BoxLayout komform = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(komform);
		JLabel komLabela = new JLabel("Komentari");
		komLabela.setFont(new Font("Serif", Font.BOLD, 24));
		
		if(this.ulogovaniKorisnik !=null){
			this.dodajKomentarDugme = new JButton("Dodaj komentar");
			GridLayout pomocniGornji = new GridLayout(1,2);
			JPanel pomocniGornjiPanel = new JPanel();
			pomocniGornjiPanel.setLayout(pomocniGornji);
			pomocniGornjiPanel.add(komLabela);
			pomocniGornjiPanel.add(this.dodajKomentarDugme);
			this.add(pomocniGornjiPanel);
			
			this.dodajKomentarDugme.addActionListener(new ActionListener() { 
			    public void actionPerformed(ActionEvent e) { 
			       pokreniDodajKomentarDialog();
			    }
			});
		}
		else{
			this.add(komLabela);
		}
		
		this.panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		JScrollPane jscroll = new JScrollPane(panel);
		if(this.komentari.komentari.size()==0){
			panel.add(new JLabel("Nema komentara!"));
		}
		else{
			for(Komentar kom:this.komentari.komentari){
				panel.add(new KomentarIzgled(kom));
			}
			this.add(jscroll);
	}
		
	}


	@Override
	public void update(Observable arg0, Object arg1){
		ArrayList<Komentar> lista = ((Komentari)arg0).komentari;
		Komentar poslednji = lista.get(lista.size()-1);
		
		panel.add(new KomentarIzgled(poslednji));
		panel.revalidate();
		panel.repaint();
		
	}
	
}
	
	
