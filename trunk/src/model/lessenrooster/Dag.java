package model.lessenrooster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Dag{
	private List<Les> lessen;
	private Date dag;

	public Dag(Date dag) {
		lessen = new ArrayList<Les>();
		this.dag = dag;
	}

	public List<Les> getLessen() {
		return lessen;
	}
	
	public void voegLesToe(Date beginUur, Date eindUur){
		lessen.add(new Les(beginUur, eindUur));
	}
	
	public boolean isBeschikbaar(Date uur){
		for (Les les : lessen){
			if (les.getStartDatum().compareTo(uur) * uur.compareTo(les.getEindDatum()) > 0){
				return false;
			}
		}
		return true;		
	}
	
	public Date getDag() {
		return dag;
	}

}
