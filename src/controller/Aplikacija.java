package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Korisnik;
import model.Tura;
import model.Vodic;

public class Aplikacija {

	public static Korisnik trenutnoAktivan=null;
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	public static ArrayList<Tura> ture = new ArrayList<Tura>();

	// TO DO
	public static void pretraziKorisnike() {};

	public static void dodajKorisnika() {};

	public static void obrisiKorisnika() {};

	

	public static void dodajTuru(Tura t) throws JsonGenerationException, JsonMappingException, IOException {

		ture.add(t);

		ArrayList<Tura> tur = ((Vodic) trenutnoAktivan).getTure();
		tur.add(t);
		((Vodic) trenutnoAktivan).setTure(tur);

		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/ture.json"), ture);

	};

	public static void obrisiTuru(Tura t) throws JsonGenerationException, JsonMappingException, IOException {

		ture.remove(t);

		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/ture.json"), ture);

		ArrayList<Tura> tur = new ArrayList<Tura>();
		for (int i = 0; i < t.getVodici().size(); i++) {
			for (int j = 0; j < korisnici.size(); i++) {
				if (korisnici.get(j) instanceof Vodic) {
					String imePrezime = korisnici.get(j).getIme() + " " + korisnici.get(j).getPrezime();
					if (imePrezime.equals(t.getVodici().get(i))) {
						tur = ((Vodic) korisnici.get(j)).getTure();
						tur.remove(t);
						((Vodic) korisnici.get(j)).setTure(tur);

					}
				}
			}
		}
	};

	// ucitavanje tura u kolekciju(ture) aplikacije
	public static void ucitavanjeTura() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		ture = om.readValue(new File("fajlovi/ture.json"), new TypeReference<ArrayList<Tura>>(){});
	};

	// pretraga tura po odredjenom kriterijumu pretrage
		public static ArrayList<Tura> pretraziTure(String tipPretrage, String parametarPretrage) {
			ArrayList<Tura> tur = new ArrayList<Tura>();

			switch (tipPretrage) {
			case "ocena":
				for (int i = 0; i < ture.size(); i++) {
					if (ture.get(i).getOcena() == Integer.parseInt(parametarPretrage)) {
						tur.add(ture.get(i));
					}
				}
				break;
			case "termin":
				for (int i = 0; i < ture.size(); i++) {
					for (int j = 0; j < ture.get(i).getTermini().size(); j++) {
						if (ture.get(i).getTermini().get(j).getPocetakTure().equals(parametarPretrage)) {
							tur.add(ture.get(i));
							break;
						}

					}
				}
				break;
			case "cena":
				for (int i = 0; i < ture.size(); i++) {
					for (int j = 0; j < ture.get(i).getTermini().size(); j++) {
						if (ture.get(i).getTermini().get(j).getCena() == Integer.parseInt(parametarPretrage)) {
							tur.add(ture.get(i));
							break;
						}

					}
				}
				break;
			case "grad":
				for (int i = 0; i < ture.size(); i++) {
					for (int j = 0; j < ture.get(i).getGradovi().size(); j++) {
						if (ture.get(i).getGradovi().get(j).getNaziv().equals(parametarPretrage)) {
							tur.add(ture.get(i));
							break;
						}
					}
				}
				break;
			}
			return tur;
		}
	// vraca ture koje je vodic licno kreirao (za prikaza tura koje vodic moze da brise)
	public static ArrayList<Tura> prikazTuraKojeJeVodicKreirao() {

		ArrayList<Tura> t = new ArrayList<Tura>();

		String imePrz = trenutnoAktivan.getIme() + " " + trenutnoAktivan.getPrezime();

		for (int i = 0; i < ture.size(); i++) {
			if (imePrz.equals(ture.get(i).getKreatortTure())) {
				t.add(ture.get(i));
			}
		}
		return t;
	}
	// vraca ture u cijem vodjenju vodic ucestvuje
	public static ArrayList<Tura> prikazTuraKojeVodicVodi() {

		ArrayList<Tura> t = new ArrayList<Tura>();

		String imePrz = trenutnoAktivan.getIme() + " " + trenutnoAktivan.getPrezime();

		for (int i = 0; i < ture.size(); i++) {
			for (int j = 0; j < ture.get(i).getVodici().size(); j++) {
				if (imePrz.equals(ture.get(i).getVodici().get(j))) {
					t.add(ture.get(i));
					break;
				}
			}
		}
		return t;
	}

}
