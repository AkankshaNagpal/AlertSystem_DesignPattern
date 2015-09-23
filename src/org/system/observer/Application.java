package org.system.observer;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Application {
	
	public static void main(String[] args) 
	{
		//Create Alert
		WeatherAlert wa = new WeatherAlert();
		WeatherAlert wa1 = new WeatherAlert();
		
		//Create Subscribers
		Subscriber sub1 = new SmsSubsciber("TMobile");
		Subscriber sub2 = new SmsSubsciber("AT&T");
		Subscriber sub3 = new SmsSubsciber("Verizon");
		
		//Register Subscribers with Publisher
		wa.register(sub1);
		wa.register(sub2);
		wa.register(sub3);
		
		wa1.register(sub1);
		wa1.register(sub2);
		
		//attach Subscribers to EmergencyAlertPublisher
		sub1.setSubject(wa);
		sub2.setSubject(wa);
		sub3.setSubject(wa);
		
		sub1.setSubject(wa1);
		sub2.setSubject(wa1);
		
		//Check if there is any update
		sub1.update();
		
		//Send Alert to Publisher
		Queue<EmergencyAlertPublisher> q = new LinkedList<EmergencyAlertPublisher>();
		q.add(wa);
		q.add(wa1);
		
		Iterator<EmergencyAlertPublisher> i = q.iterator();
		if(!q.isEmpty())
		{
		wa.postAlert("There will be flood tonight. Public Transportation will not be available");
		//wa1.postAlert("Earthquake Warning");
		
		}
		
	}

}
