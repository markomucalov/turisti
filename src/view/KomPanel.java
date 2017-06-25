package view;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Komentar;
import model.Korisnik;

public class KomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	private LinkedList<Komentar> komentari;
	private Korisnik ulogovaniKorisnik;
	private JButton dodajKomentarDugme;
	
	
	static void pokreniDodajKomentarDialog(){
		
	}
	
	
	KomPanel(LinkedList<Komentar> komentari,Korisnik ulogovaniKorisnik){
		this.komentari = komentari;
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
		
		JPanel panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		JScrollPane jscroll = new JScrollPane(panel);
		if(this.komentari.size()==0){
			panel.add(new JLabel("Nema komentara!"));
		}
		else{
			for(Komentar kom:this.komentari){
				panel.add(new KomentarIzgled(kom));
			}
			this.add(jscroll);
	}
		
	}
	
}
	
	
