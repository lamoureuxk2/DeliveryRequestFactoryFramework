package edu.bu.met.cs665;

public class Driver {
	
	private String name;
	private DeliveryRequest currentRequest;
	
	public Driver(String name) { this.name = name; }
	
	/**
	 * If driver has no current request, it takes the request and returns true.
	 * Otherwise does not take reuqest and returns false
	 * @param req - Request to be taken or rejected
	 * @return
	 */
	public boolean setNewRequest(DeliveryRequest req) {
		if(currentRequest == null) {
			currentRequest = req;
			return true;
		}
		else return false;
	}
	
	/**
	 * If request is completed, will set request back to null.
	 * 
	 */
	public void completeRequest() { currentRequest = null; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }

	public DeliveryRequest getCurrentRequest() { return currentRequest; }

	public void setCurrentRequest(DeliveryRequest currentRequest) {
		this.currentRequest = currentRequest;
	}

}
