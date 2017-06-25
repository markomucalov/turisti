import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public abstract class Korisnik {
	String korisnicko_ime;
	String lozinka;
	
	public Korisnik(){
		
	}

	public Korisnik(String korisnicko_ime, String lozinka) {
		super();
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
	}

	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}

	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public static void ucitaj_korisnike(HashMap<String, Korisnik> korisnici) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("korisnici.txt"));
		String linija;
		
		while ((linija  = in.readLine()) != null){
			linija = linija.trim();
			String[] stringovi = linija.split("\\|");
			
			if (stringovi[2].equalsIgnoreCase("t")){
				Turista t = new Turista(stringovi[0].trim(),stringovi[1].trim());
				korisnici.put(t.getKorisnicko_ime(), t);
			}else{
				Vodic v = new Vodic(stringovi[0].trim(),stringovi[1].trim());
				korisnici.put(v.getKorisnicko_ime(), v);
			}
			
		}
		in.close();
	}
	
	public static void snimi_korisnike_u_fajl(HashMap<String, Korisnik> korisnici) throws IOException{
		PrintWriter out = new PrintWriter(new FileWriter("korisnici.txt"));

		for (String k : korisnici.keySet()) {
			if (korisnici.get(k) instanceof Vodic){
				out.println(korisnici.get(k).getKorisnicko_ime() + "|" + k + "|" + "v");
			}else{
				out.println(korisnici.get(k).getKorisnicko_ime() + "|" + k + "|" + "t");
			}
		}
		out.close();
	}
	
	
	public static boolean korisnik_vec_postoji(String korisnicko_ime) throws IOException{
		HashMap<String, Korisnik> korisnici = new HashMap<String,Korisnik>();
		ucitaj_korisnike(korisnici);
		if (korisnici.containsKey(korisnicko_ime)){
			return true;
		}
		return false;
	}
	
	public static boolean provjera_korisnika(String korisnicko_ime,String lozinka) throws IOException{
		HashMap<String, Korisnik> korisnici = new HashMap<String,Korisnik>();
		ucitaj_korisnike(korisnici);
		if (korisnici.containsKey(korisnicko_ime) && korisnici.get(korisnicko_ime).getLozinka().equals(lozinka)){
			return true;
		}
		return false;
	}
	
}