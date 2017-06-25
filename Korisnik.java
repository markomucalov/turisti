import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
			Turista t = new Turista(stringovi[0].trim(),stringovi[1].trim());
			korisnici.put(t.getKorisnicko_ime(), t);
		}
		in.close();
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
