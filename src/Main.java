

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Nactu si na vstupu hodnoty od uzivatele
		Scanner sc = new Scanner( System.in );
		System.out.println("Zadej spotrebu:");
		double spotreba = sc.nextDouble();
		System.out.println("Zadej pocatecni stav nadrze:");
		double stavNadrze = sc.nextDouble();
		
		//vytvorim si promennou typu Auto a zkusim pouzit hodnoty od uzivatele
		Auto auto = null;
		try {
			auto = new Auto(spotreba, stavNadrze);
		}
		//Uzivatel zadal spatne hodnoty
		catch (Exception e) {
			e.printStackTrace();
		}
		//kdyz je promenna null, znamena to, ze uzivatel zadal spatne a program konci
		if (auto != null) {
			String zadano = "";
			//Dokud nezada, ze chce skoncit, tak program jede
			while (!zadano.equalsIgnoreCase("K")) {
				//zeptam se uzivatele, co chce delat
				System.out.println("Natankovat: T / Jet: J / Konec: K");
				zadano = sc.next();
				//zadal tankovani
				if (zadano.equalsIgnoreCase("T")) {
					System.out.println("Zadej mnozstvi litru:");
					double tankovani = sc.nextDouble();
					try {
						auto.natankuj(tankovani);
					}
					//zadal spatnou hodnotu
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				//zadal, ze jede
				else if (zadano.equalsIgnoreCase("J")) {
					System.out.println("Zadej vzdalenost v kilometrech");
					double vzdalenost = sc.nextDouble();
					try {
						auto.jed(vzdalenost);
					}
					//nastala chyba
					catch (Exception e) {
						e.printStackTrace();
					}					
				}
				//zadal spatnou hodnotu - neni to ani jedno z predchozich, ani K
				else if (!zadano.equalsIgnoreCase("k")){
					System.out.println("Chybne zadani prikazu");
				}
				//jen tak si vypisu hodnoty auta
				System.out.println("Auto: "+auto.toString());
			}
		}
	
}
}