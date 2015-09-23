package org.system.observer;

public interface Subscriber {
	
	//method to update the observer, used by subject
    public void update();
     
    //attach with subject to observe
    public void setSubject(EmergencyAlertPublisher pub);

}
