package model.locatie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Dag{
	
	private final static int slotDuur = 15; //in minuten
	private final static int aantalUur = 8; //in minuten
	private final static int beginUur = 8; 
	private List<Slot> slots;
	private Calendar datum;

	public Dag(Calendar datum) {
		this.datum = datum; 
		slots = new ArrayList<Slot>();
		for (int i = 0; i < aantalUur * 60/slotDuur; i++){
			Calendar begin = (Calendar) datum.clone();
			begin.set(Calendar.HOUR_OF_DAY, beginUur);
			begin.set(Calendar.MINUTE, 0);
			begin.set(Calendar.SECOND, 0);
			begin.add(Calendar.MINUTE, i * slotDuur);
			Calendar eind = (Calendar) begin.clone();
			eind.add(Calendar.MINUTE, slotDuur-1); 
			Slot slot = new Slot((Calendar)begin.clone(), (Calendar)eind.clone());
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
	
	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
	
	public Calendar getDatum() {
		return datum;
	}
	
	public List<Slot> getSlots() {
		return slots;
	}
}
