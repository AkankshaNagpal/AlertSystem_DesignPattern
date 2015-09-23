package org.system.observer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WeatherAlert implements EmergencyAlertPublisher {

	private List<Subscriber> subscribers;
	private String AlertMessage;
	private boolean changed;
	private final Object MUTEX = new Object();
	
	public WeatherAlert()
	{
		this.subscribers = new ArrayList<>();
	}
	
	@Override
	public void register(Subscriber sub) {
	if(sub == null)
		throw new NullPointerException("Null Subscriber");
	 synchronized (MUTEX) {
	        if(!subscribers.contains(sub)) 
	        	subscribers.add(sub);
	        }

	}

	@Override
	public void unregister(Subscriber sub) {
		// TODO Auto-generated method stub
		synchronized (MUTEX) {
	        subscribers.remove(sub);
	        }

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Subscriber sub : subscribers)
		{
			sub.update();
		}

	}

	@Override
	public Object getUpdate(Subscriber sub) {
		// TODO Auto-generated method stub
		return this.AlertMessage;
	}
	
	public void postAlert(String msg)
	{
		
		System.out.println(" Message Alert " + msg);
		this.AlertMessage = msg;
		this.changed = true;
		notifyObservers();
	}

}
