package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Korisnik;
import model.Tura;

public class MiniTuraIzgled extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Tura tura;
	int brojZnakova;
	JButton prikaziTuruDugme;
	Korisnik kor;
	
	public MiniTuraIzgled(Tura tura,int brojZnakovaOpisaZaPrikazati,Korisnik kor){
		super();
		this.tura = tura;
		this.brojZnakova = brojZnakovaOpisaZaPrikazati;
		this.kor = kor;
		podesiIzgled();
		podesiDugme();
		
	}

	private void podesiDugme() {
		this.prikaziTuruDugme.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				TuraProzor tp = new TuraProzor(tura,kor);
				tp.setVisible(true);
				
			}});
		
	}

	private void podesiIzgled() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		JLabel naslov = new JLabel(this.tura.getIdTure());
		naslov.setFont(new Font("Serif", Font.BOLD, 18));
		JLabel kratakOpis  = new JLabel();
		if(this.tura.getOpis().length() <=this.brojZnakova){
			kratakOpis.setText(this.tura.getOpis());
		}
		else{
			String text = tura.getOpis().substring(0, brojZnakova)+"...";
			kratakOpis.setText(text);
		}
		
		prikaziTuruDugme = new JButton("Prikazi turu");
		GridLayout pomocniLayout = new GridLayout(1,2);
		JPanel pomocniPanel = new JPanel();
		pomocniPanel.setLayout(pomocniLayout);
		pomocniPanel.add(naslov);
		pomocniPanel.add(prikaziTuruDugme);
		this.add(pomocniPanel,BorderLayout.PAGE_START);
		this.add(kratakOpis, BorderLayout.CENTER);
		this.add(new JLabel("	"), BorderLayout.PAGE_END);
		
	}
	
	
	
	
	
}
