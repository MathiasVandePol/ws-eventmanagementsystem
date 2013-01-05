package model.locatie;

import java.util.List;

public class Locatie {
	
	public String plaatsNaam;	//bv de View
	public String adres;	//bv G202
	public int capaciteit;	
	
	public Locatie(String plaatsNaam, String adres, int capaciteit) {
		this.plaatsNaam = plaatsNaam;
		this.adres = adres;
		this.capaciteit = capaciteit;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Plaatsnaam: %s\n", plaatsNaam));
		sb.append(String.format("Adres: %s\n", adres));
		sb.append(String.format("Capaciteit: %s\n", capaciteit));
		return sb.toString();
	}
	
	
	
	
	

}
