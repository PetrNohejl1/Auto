public class Auto {
	private double spotreba;
	private double stavNadrze;
	
	//Vytvoreni instance tridy pomoci konstruktoru s parametry spotreba a stavNadrze
	//Pri zadani spatnych hodnot se vyhazuje vyjimka
	public Auto(double spotreba, double stavNadrze) {
		super();
		if (spotreba <= 0) {
			throw new IllegalArgumentException("Chybna spotreba");
		}
		this.spotreba = spotreba;
		if (stavNadrze < 0) {
			throw new IllegalArgumentException("Chybny stav nadrze");
		}
		this.stavNadrze = stavNadrze;
	}

	public double getSpotreba() {
		return spotreba;
	}
	
	public double getStavNadrze() {
		return stavNadrze;
	}
	
	private void setStavNadrze(double stavNadrze) {
		this.stavNadrze = stavNadrze;
	}
	
	//Natankovani je pricteni natankovanych poctu litru ke stavu nadrze
	//Pri zadani spatnych hodnot se vyhodi vyjimka
	public void natankuj(double pocetLitru) throws Exception {
		if (pocetLitru < 0) {
			throw new RuntimeException("Nelze natankovat zaporny pocet litru");
		}
		setStavNadrze(getStavNadrze() + pocetLitru);
		
	}
	
	//Metoda jed popojede o vzdalenost
	//Pokud je vzdalenost zaporna, vyhodi se vyjimka
	public void jed(double vzdalenost) throws Exception {
		if (vzdalenost < 0) {
			throw new RuntimeException("Vzdalenost nesmi byt zaporna");
		}
		
		//spocitam si kolik na danou vzdalenost potrebuju benzinu
		double spotrebovanyBenzin = spotreba*vzdalenost/100;
		//vypocitam si kolik mi zbyde v nadrzi
		double novyStavNadrze = stavNadrze - spotrebovanyBenzin;
		
		//pokud mam v nadrzi mene nez nula nastavim 0 = prazdna nadrz a vyhodim vyjimku
		if (novyStavNadrze < 0) {
			setStavNadrze(0);
			throw new RuntimeException("Dosel benzin");		
		}
		//jinak nastavim novy stav nadrze
		setStavNadrze(novyStavNadrze);		
	}

	public String toString() {
		return "Auto [spotreba=" + spotreba + ", stavNadrze=" + stavNadrze + "]";
	}	
}
