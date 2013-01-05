package model.lessenrooster;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Student {
	private String studentenNummer;
	private List<Dag> lesdagen;
	
	public Student(String studentenNummer) {
		this.studentenNummer = studentenNummer;
		lesdagen = new ArrayList<Dag>();
	}
	
	public void voegLesDagToe(Calendar dag){
		lesdagen.add(new Dag(dag));
	}

	public String getStudentenNummer() {
		return studentenNummer;
	}

	public void setStudentenNummer(String studentenNummer) {
		this.studentenNummer = studentenNummer;
	}

	public List<Dag> getLesdagen() {
		return lesdagen;
	}
	
	public boolean isBeschikbaar(Calendar begin, Calendar eind){
		for (Dag ld : lesdagen){
			if (ld.getDatum().get(Calendar.DATE) == begin.get(Calendar.DATE)
					&& ld.getDatum().get(Calendar.MONTH) == begin.get(Calendar.MONTH) 
						&& ld.getDatum().get(Calendar.YEAR) == begin.get(Calendar.YEAR) )
			{
				return ld.isBeschikbaar(begin, eind);
			}
		}
		return true;		
	}
	
}
