package model.locatie;

import java.util.Calendar;

import model.abstracten.TijdsInterval;

public class Slot extends TijdsInterval {
	private boolean bezet = false;
	
	public Slot(Calendar beginuur, Calendar einduur) {
		super(beginuur, einduur);
	}

	
	public boolean isBezet() {
		return bezet;
	}
	
	public void setBezet(boolean bezet) {
		this.bezet = bezet;
	}
}
