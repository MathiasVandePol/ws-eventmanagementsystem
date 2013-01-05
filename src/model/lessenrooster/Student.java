package model.lessenrooster;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
	private String studentenNummer;
	private List<Dag> lesdagen;
	
	public Student(String studentenNummer) {
		this.studentenNummer = studentenNummer;
		lesdagen = new ArrayList<Dag>();
	}
	
	public void voegLesDagToe(Date dag){
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
	
	public boolean isBeschikbaar(Date dag, Date uur){
		for (Dag ld : lesdagen){
			if (ld.getDag().compareTo(dag) == 0){
				return ld.isBeschikbaar(uur);
			}
		}
		return true;		
	}
	
}
