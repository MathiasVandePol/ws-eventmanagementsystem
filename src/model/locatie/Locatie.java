package model.locatie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Locatie {
	
	private String plaatsNaam;	//bv de View
	private String adres;	//bv G202
	private int capaciteit;
	private List<Dag> dagen;
	
	public Locatie(String plaatsNaam, String adres, int capaciteit) {
		this.plaatsNaam = plaatsNaam;
		this.adres = adres;
		this.capaciteit = capaciteit;
		dagen = new ArrayList<Dag>();	
	}
	
	public void voegDagToe(Calendar dag){
		dagen.add(new Dag(dag));
	}

	public boolean isBeschikbaar(Calendar begin, Calendar eind){
		for (Dag d : dagen){
			if (d.getDatum().get(Calendar.DATE) == begin.get(Calendar.DATE)
					&& d.getDatum().get(Calendar.MONTH) == begin.get(Calendar.MONTH) 
						&& d.getDatum().get(Calendar.YEAR) == begin.get(Calendar.YEAR) )
			{
				return d.isBeschikbaar(begin, eind);
			}
		}
		return true;
	}
	
	public int getCapaciteit() {
		return capaciteit;
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
