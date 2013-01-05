package model.lessenrooster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentenChecker {
	private List<Student> studenten;
	private final int PERCENTAGE_BESCHIKBAAR = 75; //Percentage van studenten dat tenminste beschikbaar moet zijn om de voorgestelde datum te accepteren
	
	public StudentenChecker() {
		studenten = new ArrayList<Student>();
	}
	
	public boolean isEenGepastVoorstel(Date dag, Date uur){
		int aantalBeschikbaar = 0;
		for (Student student: studenten){
			if (student.isBeschikbaar(dag, uur)){
				aantalBeschikbaar++;
			}
		}
		if (aantalBeschikbaar / studenten.size() * 100  >= PERCENTAGE_BESCHIKBAAR ){
			return true;
		}
		return false;
	}
	
	
}
