package model.lessenrooster;


import java.util.Calendar;

import model.abstracten.TijdsInterval;

public class Les extends TijdsInterval
{

	public Les(Calendar startDatum, Calendar eindDatum) {
		super(startDatum, eindDatum);
	}
	
}
