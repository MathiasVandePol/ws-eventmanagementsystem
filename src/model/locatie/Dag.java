package model.locatie;

import java.util.Calendar;
import java.util.List;

import model.lessenrooster.Les;


public class Dag{
	
	private final static int slotDuur = 15; //in minuten
	private final static int aantalUur = 8; //in minuten
	private final static int beginUur = 8; 
	private List<Slot> slots;
	private Calendar datum;

	public Dag(Calendar datum) {
		this.datum = datum;
		for (int i = 0; i < aantalUur * 60/slotDuur; i++){
			Calendar begin = Calendar.getInstance();
			begin.set(datum.get(Calendar.DATE), datum.get(Calendar.MONTH), datum.get(Calendar.MINUTE), 
					beginUur, 0, 0);
			begin.add(Calendar.MINUTE, i * slotDuur);
			Calendar eind = (Calendar) begin.clone();
			eind.add(Calendar.MINUTE, slotDuur - 1); 
			Slot slot = new Slot(begin, eind);
			slots.add(slot);
		}
	}
	
	public boolean isBeschikbaar(Calendar begin, Calendar eind){
		for (Slot slot : slots){
			if (slot.inDitInterval(begin)	|| 
					slot.inDitInterval(eind)){ //begin of eind datum zit in het slot
					if (slot.isBezet()){
						return false;
					}
			}
		}
		return true;		
	}
	
	public Calendar getDatum() {
		return datum;
	}
}
