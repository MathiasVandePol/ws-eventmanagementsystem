package model.lessenrooster;

import data.*;

import java.util.Calendar;
import java.util.List;

public class StudentenChecker {
	private List<Student> studenten;
	private final int PERCENTAGE_BESCHIKBAAR = 75; //Percentage van studenten dat tenminste beschikbaar moet zijn om de voorgestelde datum te accepteren
	
	public StudentenChecker() {
		studenten.addAll(DataGenerator.maakStudenten());
	}
	
	public boolean isEenGepastVoorstel(Calendar begin, Calendar eind){			//We gaan er vanuit dat het afspraken zijn die voor elke student in het systeem zijn
		int aantalBeschikbaar = 0;
		for (Student student: studenten){
			if (student.isBeschikbaar(begin, eind)){
				aantalBeschikbaar++;
			}
		}
		if (aantalBeschikbaar / studenten.size() * 100  >= PERCENTAGE_BESCHIKBAAR ){
			return true;
		}
		return false;
	}
	
	
}
