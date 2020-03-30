package edu.bu.met.cs665;

/**
 * A shop object is represented by a String for its name and String for its address
 * 
 * @author lamoureuxk
 *
 */
public class Shop {
	
	private String name;
	private String address;
	
	public Shop(String n, String a) { name = n; address = a; }

	/**
	 * Calls constructor for DeliveryRequest, passes in its own name
	 * and this methods arguments.
	 * @param desc - request description
	 * @param addr - delivery address
	 * @return
	 */
	public DeliveryRequest makeRequest(String desc, String addr) {
		return new DeliveryRequest(this.name, addr, desc);
	}
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }
	
	

}
