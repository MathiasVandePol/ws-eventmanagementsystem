import java.util.Calendar;

import model.lessenrooster.StudentenChecker;
import model.locatie.LocatieChecker;


public class Run {
	public static void main(String[] args) {
		StudentenChecker sc = new StudentenChecker();
		LocatieChecker lc = new LocatieChecker();
		Calendar begin = Calendar.getInstance();
		Calendar eind = (Calendar) begin.clone();
		eind.add(Calendar.HOUR, 2);
		for (int i = 0; i < 10; i++){
			begin.add(Calendar.DATE, 1);
			System.out.println(begin.getTime());
			eind.add(Calendar.DATE, 1);
			System.out.println(eind.getTime());
			System.out.println(sc.isEenGepastVoorstel(begin, eind));
			System.out.println();
		}
		
	}
}
