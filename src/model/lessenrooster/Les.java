package model.lessenrooster;

import java.util.Date;

import model.abstracten.TijdsInterval;

public class Les extends TijdsInterval
{

	public Les(Date startDatum, Date eindDatum) {
		super(startDatum, eindDatum);
	}
	
}
