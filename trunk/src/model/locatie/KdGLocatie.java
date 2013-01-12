package model.locatie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import data.DataGenerator;

public class KdGLocatie {
	
	private List<Locatie> locaties;

	public KdGLocatie() {
		locaties = new ArrayList<Locatie>();
		locaties.addAll(DataGenerator.maakLocaties());
	}
	
	public String geefBeschikbareLocatie(Calendar begin, Calendar eind, int aantalPersonen){
		for (Locatie l : locaties){
			if (l.getCapaciteit() >= aantalPersonen && l.isBeschikbaar(begin, eind)){
				return l.toString();
			}
		}
		return null;
	}
	
	public void annuleerReservering(int id){
		
	}

}
