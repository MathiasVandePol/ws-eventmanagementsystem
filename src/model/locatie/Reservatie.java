package model.locatie;

import java.util.Date;

import model.abstracten.TijdsInterval;

public class Reservatie extends TijdsInterval{ 
	private Locatie locatie;
	
	public Reservatie(Date startDatum, Date eindDatum) {
		super(startDatum, eindDatum);
	}

	public Date getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(Date startDatum) {
		this.startDatum = startDatum;
	}

	public Date getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(Date eindDatum) {
		this.eindDatum = eindDatum;
	}

	public Locatie getLocatie() {
		return locatie;
	}

	public void setLocatie(Locatie locatie) {
		this.locatie = locatie;
	}
	
	
	
	

}
