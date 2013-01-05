package model.locatie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.abstracten.TijdsInterval;

public class Dag{
	private List<Reservatie> reservaties;

	public Dag() {
		reservaties = new ArrayList<Reservatie>();
	}

	public List<Reservatie> getReservaties() {
		return reservaties;
	}
	
	public void voegReservatieToe(Date beginUur, Date eindUur){
		
	}
	
	

}
