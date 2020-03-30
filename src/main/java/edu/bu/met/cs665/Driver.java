package edu.bu.met.cs665;

public class Driver {
	
	private String name;
	private DeliveryRequest currentRequest;
	
	public Driver(String name) { this.name = name; }
	
	public boolean setNewRequest(DeliveryRequest req) {
		if(currentRequest == null) {
			currentRequest = req;
			return true;
		}
		else return false;
	}
	
	public void completeRequest() { currentRequest = null; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }

	public DeliveryRequest getCurrentRequest() { return currentRequest; }

	public void setCurrentRequest(DeliveryRequest currentRequest) {
		this.currentRequest = currentRequest;
	}

}
