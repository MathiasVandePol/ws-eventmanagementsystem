package model.locatie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import data.DataGenerator;

public class LocatieChecker {
	
	private List<Locatie> locaties;

	public LocatieChecker() {
		locaties = new ArrayList<Locatie>();
		locaties.addAll(DataGenerator.maakLocaties());
	}
	
	public Locatie geefBeschikbareLocatie(Calendar begin, Calendar eind, int aantalPersonen){
		for (Locatie l : locaties){
			if (l.getCapaciteit() >= aantalPersonen && l.isBeschikbaar(begin, eind)){
				return l;
			}
		}
		return null;
	}

}
