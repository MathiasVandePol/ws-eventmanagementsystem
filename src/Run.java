import java.util.Calendar;

import model.lessenrooster.KdGStudenten;
import model.locatie.KdGLocatie;

public class Run {

	static Calendar begin;
	static Calendar eind;
	static KdGStudenten sc;
	static KdGLocatie lc;

	public static void main(String[] args) {
		sc = new KdGStudenten();
		lc = new KdGLocatie();
		begin = Calendar.getInstance();
		eind = (Calendar) begin.clone();
		eind.add(Calendar.HOUR, 2);
		for (int i = 0; i < 10; i++) {
			testStudenten();
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
