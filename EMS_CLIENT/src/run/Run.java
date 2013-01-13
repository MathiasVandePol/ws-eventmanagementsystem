package run;

import java.rmi.RemoteException;
import java.util.Calendar;

import org.apache.axis.AxisFault;
import serviceCall.*;
import serviceCall.CreateEventServiceStub.CreateEventRequest;

public class Run {
	
	static Calendar begin = Calendar.getInstance();
	static Calendar eind = Calendar.getInstance();
	static final int aantal = 50;
		
	
	public static void main(String[] args) {
		begin.set(2013, 0, 13, 12, 0);
		eind.set(2013, 0, 13, 16, 0);
		System.out.println(begin.getTime());
		System.out.println(eind.getTime());

		try {
			CreateEventServiceStub cesch = new CreateEventServiceStub();
			CreateEventServiceStub.CreateEventRequest cer = new CreateEventRequest();
			cer.setAantal(50);
			cer.setBegin(begin);
			cer.setEind(eind);
			CreateEventServiceStub.CreateEventResponse res = cesch.process(cer);
			System.out.println(res.getResult());
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
