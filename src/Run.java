import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import model.lessenrooster.*;
import model.locatie.Locatie;

public class Run {

	private static final int aantal_dagen = 42;
	private static int aantal_studenten = 50;
	private static final int aantal_lessen = 10;
	private static final int aantal_locaties = 50;
	
	static Random random = new Random();

	private static ArrayList<Student> studenten = new ArrayList<Student>();
	private static ArrayList<Dag> rooster = new ArrayList<Dag>();
	private static ArrayList<Locatie> locaties = new ArrayList<Locatie>();
	
	public static void main() {
		maakRooster();
		maakStudenten();
		maakLocaties();
	}

	public static Calendar getCalendar(int day, int month, int year) {
	    Calendar date = Calendar.getInstance();
	    date.set(Calendar.YEAR, year);
	    date.set(Calendar.MONTH, month);
	    date.set(Calendar.DAY_OF_MONTH, day);

	    return date;
	}
	
	public static Calendar getCalendar(int uur, int minuten){
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR, uur);
		date.set(Calendar.MINUTE, minuten);
		return date;
	}
	
	public static void maakRooster() {
		int j = 1;
		
		for (int i = 1; i <= aantal_dagen; i++) {
			
			Dag dag = new Dag(getCalendar(i,j,2013));
			
			if(i >=30){
				j++;
			}
			
			for(int l = 1; l <= aantal_lessen; l++){
				dag.voegLesToe(getCalendar(l+7,0), getCalendar(l+8,0));		
			}
			
			rooster.add(dag);
		}

	}

	public static void maakStudenten() {
		for (int i = 0; i < aantal_studenten; i++) {
			Student student = new Student("KdG" + i);
			student.voegLesDagToe(getCalendar(random.nextInt(31),1,2013));
			student.voegLesDagToe(getCalendar(random.nextInt(28),2,2013));
			student.voegLesDagToe(getCalendar(random.nextInt(31),3,2013));
			studenten.add(student);
		}

	}

	
	public static void maakLocaties(){
		for(int i = 0; i < aantal_locaties; i++){
			Locatie locatie = new Locatie("Lokaal", "GR" + random.nextInt(300), 20);
			locaties.add(locatie);
		}
		
	}
	
 	public static ArrayList<Student> getStudenten() {
		return studenten;
	}
	

	public static ArrayList<Dag> getRooster() {
		return rooster;
	}



	public static ArrayList<Locatie> getLocaties() {
		return locaties;
	}


	
}
