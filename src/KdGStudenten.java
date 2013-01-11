

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.lessenrooster.Student;

import data.DataGenerator;

public class KdGStudenten {
	private List<Student> studenten;
	private final int PERCENTAGE_BESCHIKBAAR = 75; //Percentage van studenten dat tenminste beschikbaar moet zijn om de voorgestelde datum te accepteren
	
	public KdGStudenten() {
		studenten = new ArrayList<Student>();
		studenten.addAll(DataGenerator.maakStudenten());
	}
	
	public boolean isEenGepastVoorstel(Calendar begin, Calendar eind){			//We gaan er vanuit dat het afspraken zijn die voor elke student in het systeem zijn
		int aantalBeschikbaar = 0;
		for (Student student: studenten){
			if (student.isBeschikbaar(begin, eind)){
				aantalBeschikbaar++;
			}
		}
		double huidigPercentage = (double) aantalBeschikbaar / studenten.size() * 100 ;
		if (huidigPercentage  >= PERCENTAGE_BESCHIKBAAR ){
			return true;
		}
		return false;
	}
	
	public void planLes(int id){
		//plan les
		
	}
		
	public void annuleerLes(int id){
		//annuleer les
		
	}
	
	
}
