package model.lessenrooster;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Dag{
	private List<Les> lessen;
	private Calendar datum;

	public Dag(Calendar dag) {
		lessen = new ArrayList<Les>();
		this.datum = dag;
	}

	public List<Les> getLessen() {
		return lessen;
	}
	
	public void voegLesToe(Calendar beginUur, Calendar eindUur){
		lessen.add(new Les(beginUur, eindUur));
	}
	
	public boolean isBeschikbaar(Calendar begin, Calendar eind){
		for (Les les : lessen){
			if (les.inDitInterval(begin)	|| 
			les.inDitInterval(eind)){ //begin of eind datum zit in de les
				return false;
			}
		}
		return true;		
	}
	
	public Calendar getDatum() {
		return datum;
	}


}
