import java.util.Comparator;

/**
 * Klasa reprezentuj¹ca przebieg jednej rundy gry - 
 * @author Micha³ Bogucki, Marcin Janeczko, Aleksander Tym
 *
 */
public class Round {
	private int wolumen;
	private int wolumenNiesprzedany;
	private int jakosc;
	private double cena;
	private double reklama;
	private double kjz;
	private double wynik;
	private double przychodyZodsprzedazy =0;
	
	public Round(int wolumen, int jakosc, double kjz, double cena, double reklama) {
		this.wolumen=wolumen;
		this.jakosc=jakosc;
		this.kjz=kjz;
		this.cena=cena;
		this.reklama=reklama;
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
		if(cena > 2*kjz)
		{
			wolumenNiesprzedany = (int) ( (kjz/cena) * wolumen );
			wolumen = wolumen - wolumenNiesprzedany;
			przychodyZodsprzedazy =Math.floor(( 0.5 * wolumenNiesprzedany * kjz)*100)/100;
		}
		
		przychodyZeSprzedazy = wolumen*cena;
		kosztyProdukcji = Model.KOSZTY_STALE+((wolumen+wolumenNiesprzedany)*kjz);
		zyskNaSprzedazy = przychodyZeSprzedazy + przychodyZodsprzedazy - kosztyProdukcji - reklama;
		zyskNaDzOp = zyskNaSprzedazy - Model.AMORTYZACJA;
		odsetki = (gotowkaNaEtap - kosztyProdukcji-reklama - Model.AMORTYZACJA )*Model.OPROCENTOWANIE;
		zyskNaDzGosp = zyskNaDzOp + odsetki;
		
		if(zyskNaDzGosp>=0) podatek = zyskNaDzGosp*Model.STOPA_PODATKU; 
		else		  		podatek=odsetki*Model.STOPA_PODATKU;
		
		if(kosztyProdukcji+reklama > Model.GOTOWKA_NA_ETAP){
			wynik = -100;
		}
		else
			wynik = Math.floor((zyskNaDzGosp - podatek)*100)/100;
	}



	public int getWolumenNiesprzedany() {
		return wolumenNiesprzedany;
	}



	public void setWolumenNiesprzedany(int wolumenNiesprzedany) {
		this.wolumenNiesprzedany = wolumenNiesprzedany;
	}



	public double getPrzychodyZodsprzedazy() {
		return przychodyZodsprzedazy;
	}



	public void setPrzychodyZodsprzedazy(double przychodyZodsprzedazy) {
		this.przychodyZodsprzedazy = przychodyZodsprzedazy;
	}



	

	

}
