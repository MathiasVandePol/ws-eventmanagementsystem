package model.abstracten;

import java.util.Date;

public abstract class TijdsInterval {
	protected Date startDatum;
	protected Date eindDatum;
	
	public TijdsInterval(Date startDatum, Date eindDatum) {
		super();
		this.startDatum = startDatum;
		this.eindDatum = eindDatum;
	}

	public Date getEindDatum() {
		return eindDatum;
	}
	
	public Date getStartDatum() {
		return startDatum;
	}
}
