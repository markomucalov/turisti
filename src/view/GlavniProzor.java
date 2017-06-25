package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GlavniProzor extends JFrame {

	private static final long serialVersionUID = 1L;

	public GlavniProzor() {

		setSize(800, 600);

		setTitle("Turisticka agencija");

		ImageIcon i = new ImageIcon("images/ikonica.png");
		setIconImage(i.getImage());

		setLayout(new BorderLayout());

		meni();
		panelPretrage();
		pozadinaProzora();

	}

	public void meni() {

		JMenuBar menubar = new JMenuBar();

		JMenuItem log = new JMenuItem("Prijava");
		log.setMaximumSize(new Dimension(80, 50));
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// onaj ko bude radio logovanje nek doda poziv za prikaz prozora
				// za logovanje
			}
		});

		JMenuItem reg = new JMenuItem("Registracija");
		reg.setMaximumSize(new Dimension(80, 50));
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// isto za registrovanje
			}
		});

		menubar.add(log);
		menubar.add(reg);

		setJMenuBar(menubar);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void panelPretrage() {

		JPanel imp = new JPanel();
		imp.setLayout(new BorderLayout());
		JLabel labela = new JLabel("Parametar pretrage: ");
		JTextField text = new JTextField(10);

		JComboBox opcijePretrage = new JComboBox();
		opcijePretrage.addItem("termin");
		opcijePretrage.addItem("ocena");
		opcijePretrage.addItem("cena");
		opcijePretrage.addItem("vodic");
		opcijePretrage.addItem("grad");

		JPanel leviP = new JPanel();
		JPanel srednjiP = new JPanel();
		JPanel desniP = new JPanel();

		imp.add(leviP, BorderLayout.WEST);
		imp.add(srednjiP, BorderLayout.CENTER);
		imp.add(desniP, BorderLayout.EAST);

		desniP.add(new JLabel("Tip pretrage: "));
		desniP.add(opcijePretrage);

		desniP.add(labela);
		desniP.add(text);
		add(imp, BorderLayout.NORTH);

	}

	public void pozadinaProzora() {

		JPanel imp = new JPanel();

		ImageIcon im = new ImageIcon("images/image.jpg");
		Image image = im.getImage();
		Image newimg = image.getScaledInstance(800, 500, java.awt.Image.SCALE_SMOOTH);
		im = new ImageIcon(newimg);

		JLabel labela = new JLabel();
		labela.setIcon(im);

		imp.add(labela);
		add(imp, BorderLayout.SOUTH);

	}

}
