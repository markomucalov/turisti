package view;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Korisnik;
import model.Termin;
import model.Tura;
import model.Vodic;

public class TuraProzor extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Tura tura;
	Korisnik ulogovaniKorisnik;
	
	private void podesiVelicinu(){
		Dimension velicinaEkrana = Toolkit.getDefaultToolkit().getScreenSize();
		int sirina = (int)velicinaEkrana.getWidth();
		int visina = (int)velicinaEkrana.getHeight();
		this.setSize(sirina/2, visina/2);
	}
	
	
	
	private void podesiInformacije(){
		JLabel ocenaLabela = new JLabel("\tOcena: "+this.tura.getOcena());
		ocenaLabela.setFont(new Font("Serif", Font.BOLD, 24));
		String vodiciImena = "";
		for(String v:this.tura.getVodici()){
			vodiciImena += v+", ";
		}
		JLabel vodicLabela = new JLabel("\tVodici: "+vodiciImena);
		vodicLabela.setFont(new Font("Serif", Font.BOLD, 24));
		JPanel panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		panel.add(ocenaLabela);
		panel.add(vodicLabela);
		this.add(panel);
	}
	
	private void podesiKomentare(){
		KomPanel kompanel = new KomPanel(this.tura.getKomentari(),this.ulogovaniKorisnik);
			this.add(kompanel);
		}
	
	
	private void podesiOpisTure(){
		JPanel panel = new JPanel();
		BoxLayout form = new BoxLayout(panel,BoxLayout.Y_AXIS);
		panel.setLayout(form);
		JLabel lab = new JLabel("Opis ture\n");
		lab.setFont(new Font("Serif", Font.BOLD, 24));
		panel.add(lab);
		panel.add(new JLabel("<html><p>"+this.tura.getOpis()+"</p></html>"));
		this.add(panel);
	}
	
	private void podesiTermine(){
		JPanel terminPanel = new JPanel();
		BoxLayout komform = new BoxLayout(terminPanel,BoxLayout.Y_AXIS);
		terminPanel.setLayout(komform);
		JLabel terminLabela = new JLabel("Termini");
		terminLabela.setFont(new Font("Serif", Font.BOLD, 24));
		terminPanel.add(terminLabela);
		Vector<String> zaglavlje = new Vector<String>();
		Vector<Vector<String>> teloTabele = new Vector<Vector<String>>();
		podesiTabelu(zaglavlje,teloTabele);
		JTable tabela = new JTable(teloTabele,zaglavlje);
		tabela.setDefaultEditor(Object.class,null);//da ne moze da se edituje
		JScrollPane jscroll = new JScrollPane(tabela);
		terminPanel.add(jscroll);
		this.add(terminPanel);
	}
	
	private void podesiTabelu(Vector<String> zaglavlje, Vector<Vector<String>> teloTabele) {
		zaglavlje.addElement("Pocetak");
		zaglavlje.addElement("Zavrsetak");
		zaglavlje.addElement("Broj slobodnih mesta");
	
		Vector<String> trenutniRed;
		for(Termin t:this.tura.getTermini()){
			trenutniRed = new Vector<String>();
			teloTabele.addElement(trenutniRed);
			trenutniRed.addElement(t.getPocetakTure());
			trenutniRed.addElement(t.getKrajTure());
			trenutniRed.addElement(t.getBrojSlobodnihMesta()+"");
		}
		
	}

	public TuraProzor(Tura tura,Korisnik ulogovaniKorisnik){
		this.tura = tura;
		this.ulogovaniKorisnik = ulogovaniKorisnik;
		this.setTitle(tura.getIdTure());
		podesiVelicinu();
		this.setLayout(new GridLayout(2,2));
		podesiOpisTure();
		podesiInformacije();
		podesiKomentare();
		podesiTermine();
	}
	
	
	
}
