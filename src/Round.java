/**
 * Klasa reprezentuj¹ca przebieg jednej rundy gry - 
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class Round {
	private int wolumen;
	private int jakosc;
	private double cena;
	private double reklama;
	private double kjz;
	private double wynik;
	
	public Round(int i, int j, double d, double e, double f) {
		wolumen=i;
		jakosc=j;
		kjz=d;
		cena=e;
		reklama=f;
		wynik=-1;
	}
	public int getWolumen() {
		return wolumen;
	}
	public void setWolumen(int wolumen) {
		this.wolumen = wolumen;
	}
	public int getJakosc() {
		return jakosc;
	}
	public void setJakosc(int jakosc) {
		this.jakosc = jakosc;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public double getReklama() {
		return reklama;
	}
	public void setReklama(double reklama) {
		this.reklama = reklama;
	}
	public double getKjz() {
		return kjz;
	}
	public void setKjz(double kjz) {
		this.kjz = kjz;
	}
	public double getWynik() {
		return wynik;
	}
	
	public void setWynik(double wynik) {
		this.wynik = wynik;
	}
	
	public void countWynik(double gotowkaNaEtap) 
	{ 
		double zyskNaDzGosp, zyskNaDzOp, podatek=0, odsetki, zyskNaSprzedazy, kosztyProdukcji,
		przychodyZeSprzedazy;
		przychodyZeSprzedazy = wolumen*cena;
		kosztyProdukcji = Model.KOSZTY_STALE+(wolumen*kjz);
		zyskNaSprzedazy = przychodyZeSprzedazy - kosztyProdukcji - reklama;
		zyskNaDzOp = zyskNaSprzedazy - Model.AMORTYZACJA;
		odsetki = (gotowkaNaEtap - kosztyProdukcji-reklama - Model.AMORTYZACJA )*Model.OPROCENTOWANIE;
		zyskNaDzGosp = zyskNaDzOp + odsetki;
		
		if(zyskNaDzGosp>=0) podatek = zyskNaDzGosp*Model.STOPA_PODATKU; 
		else		  		podatek=odsetki*Model.STOPA_PODATKU;
		
		
		wynik = zyskNaDzGosp - podatek;
		
		
	}
	

}
