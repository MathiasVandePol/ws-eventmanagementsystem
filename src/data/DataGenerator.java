package data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import model.lessenrooster.*;
import model.locatie.Locatie;

public class DataGenerator {

	private static final int aantal_dagen = 42;
	private static int aantal_studenten = 50;
	private static final int aantal_lessen = 10;
	private static final int aantal_locaties = 50;
	private static final boolean weekends = false;

	static Random random = new Random();


	private static Calendar getCalendar(int uur, int minuten, Calendar dag) {
		dag.set(Calendar.HOUR_OF_DAY, uur);
		dag.set(Calendar.MINUTE, minuten);
		return dag;
	}

	public static ArrayList<Dag> maakRooster() {

		ArrayList<Dag> rooster = new ArrayList<Dag>();
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i <= aantal_dagen; i++) {
			cal.add(Calendar.DAY_OF_MONTH, 1); // Altijd 1 dag er bij
			if (!(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && cal
					.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) || weekends) { // in	weekend geenles
				if (random.nextInt(5) >2) { // 2op5 kans dat je les hebt
					Dag dag = new Dag((Calendar)cal.clone());
					for (int l = 1; l <= aantal_lessen; l++) {
						if (random.nextInt(5) > 1) { // 3op5 kans dat je op dat uur les hebt
							dag.voegLesToe(
									getCalendar(l + 7, 0,(Calendar) dag.getDatum().clone()),
									getCalendar(l + 8, 0,(Calendar) dag.getDatum().clone()));
						}
					}
					rooster.add(dag);
				}
			}
		}
		return rooster;

	}

	public static ArrayList<Student> maakStudenten() {
		ArrayList<Student> studenten = new ArrayList<Student>();
		for (int i = 0; i < aantal_studenten; i++) {
			Student student = new Student("KdG" + i);
			student.setLesdagen(maakRooster());
			studenten.add(student);
		}
		return studenten;
	}

	public static ArrayList<Locatie> maakLocaties() {
		ArrayList<Locatie> locaties = new ArrayList<Locatie>();
		for (int i = 0; i < aantal_locaties; i++) {
			Locatie locatie = new Locatie("Lokaal", "GR" + i+1,
					random.nextInt(200) + 20);
			locatie.setDagen(maakLocatiesSlots());
			locaties.add(locatie);
		}
		return locaties;
	}
	
	public static ArrayList<model.locatie.Dag> maakLocatiesSlots() {

		ArrayList<model.locatie.Dag> rooster = new ArrayList<model.locatie.Dag>();
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i <= aantal_dagen; i++) {
			cal.add(Calendar.DAY_OF_MONTH, 1); // Altijd 1 dag er bij
			model.locatie.Dag dag = new model.locatie.Dag((Calendar)cal.clone());
			//System.out.println(dag.getDatum().getTime());
			for (int s=0; s<dag.getSlots().size(); s++){	//Hoeveelste slot van de dag
				//System.out.println("StartSlot:" + s);
				if (random.nextInt(3) > 0){	//2op3kans dat het lokaal op dat slot bezet is
					int aantal = random.nextInt(7) + 4; //Minimaal les van 1 uur (4 slots), maximum 2.5 uur);
					for (int j = 0; j < aantal; j++){
						try{
							dag.getSlots().get(s + j).setBezet(true);	 
							//System.out.println("Slot:" + (s + j) + " is bezet");
						} catch (IndexOutOfBoundsException ie){
							//Einde van slotlijst bereikt
						}
					}
					s += aantal;	//Volgend slot om te beginnen in loop is ten vroegste kwartier later dan eind vorige les
				}
			}
			//System.out.println();
			rooster.add(dag);					
		}
		return rooster;

	}

}
