import java.util.Calendar;

import model.lessenrooster.StudentenChecker;
import model.locatie.LocatieChecker;

public class Run {

	static Calendar begin;
	static Calendar eind;
	static StudentenChecker sc;
	static LocatieChecker lc;

	public static void main(String[] args) {
		sc = new StudentenChecker();
		lc = new LocatieChecker();
		begin = Calendar.getInstance();
		eind = (Calendar) begin.clone();
		eind.add(Calendar.HOUR, 2);
		for (int i = 0; i < 10; i++) {
			testLocaties();
		}
	}

	public static void testStudenten() {
			begin.add(Calendar.DATE, 1);
			System.out.println(begin.getTime());
			eind.add(Calendar.DATE, 1);
			System.out.println(eind.getTime());
			System.out.println(sc.isEenGepastVoorstel(begin, eind));
			System.out.println();
	}
	
	public static void testLocaties(){
		begin.add(Calendar.DATE, 1);
		System.out.println(begin.getTime());
		eind.add(Calendar.DATE, 1);
		System.out.println(eind.getTime());
		System.out.println(lc.geefBeschikbareLocatie(begin, eind, 50));
		System.out.println();
	}
}
