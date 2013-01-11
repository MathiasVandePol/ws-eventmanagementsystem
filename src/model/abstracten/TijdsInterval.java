package model.abstracten;

import java.util.Calendar;

public abstract class TijdsInterval {
	protected Calendar startDatum;
	protected Calendar eindDatum;
	
	public TijdsInterval(Calendar startDatum, Calendar eindDatum) {
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
	}

	public Calendar getEindDatum() {
		return eindDatum;
	}
	
	public Calendar getStartDatum() {
		return startDatum;
	}
	
	public boolean inDitInterval(Calendar uur){	//kijkt of het meegegeven uur tussen het begin en einduur liggen
	//	System.out.println("Uur om te kijken:" + uur.getTime());
	//	System.out.println("Begin interval:" + startDatum.getTime());
	//	System.out.println("Eind interval:" + eindDatum.getTime());

		if (startDatum.compareTo(uur) * uur.compareTo(eindDatum) > 0){
		
			return true;
		}
		return false;
	}
}
