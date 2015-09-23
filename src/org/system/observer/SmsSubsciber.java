package org.system.observer;

public class SmsSubsciber implements Subscriber {

	private String name;
	private EmergencyAlertPublisher alert;
	
	public SmsSubsciber(String nm)
	{
		this.name = nm;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		String msg = (String) alert.getUpdate(this);
		
		if(msg==null)
		{
			System.out.println(name + " No new Alert ");
			
		}
		else
		{
			System.out.println(name + " Consuming message " + msg);
		}

	}

	@Override
	public void setSubject(EmergencyAlertPublisher pub) {
		
		this.alert = pub;

	}

}
