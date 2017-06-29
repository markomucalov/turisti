package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Korisnik;
import model.Tura;
import model.Vodic;

public class Aplikacija {
	
	static Korisnik trenutnoAktivan;
	static  ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	static ArrayList<Tura> ture= new ArrayList<Tura>();
	
	
	//TO DO
	public static  void pretraziKorisnike(){};
	public static  void dodajKorisnika(){};
	public static  void obrisiKorisnika(){};
	
	
	public static  void pretraziTure(){};
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

		ArrayList<Tura> tur= new ArrayList<Tura>();
		for (int i =0; i <t.getVodici().size(); i++ ){
			for (int j=0; j< korisnici.size(); i++){
				if (korisnici.get(j) instanceof Vodic){
					String imePrezime= korisnici.get(j).getIme()+ " "+korisnici.get(j).getPrezime();
					if (imePrezime.equals(t.getVodici().get(i))){
						 tur= ((Vodic)korisnici.get(j)).getTure();
						 tur.remove(t);
						((Vodic)korisnici.get(j)).setTure(tur);
						
					}
				}
			}	
		}
	};
	//ucitavanje tura u kolekciju(ture) aplikacije
	public static void ucitavanjeTura() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper om = new ObjectMapper();
		ture = om.readValue(new File("fajlovi/ture.json"), ArrayList.class);
	};
	
}
