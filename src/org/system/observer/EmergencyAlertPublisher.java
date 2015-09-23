package org.system.observer;

public interface EmergencyAlertPublisher {
	
	public void register(Subscriber sub);
    public void unregister(Subscriber sub);
     
    //method to notify observers of change
    public void notifyObservers();
     
    //method to get updates from subject
    public Object getUpdate(Subscriber sub);

}
