package edu.bu.met.cs665;

public class Shop {
	
	private String name;
	private String address;
	
	public Shop(String n, String a) { name = n; address = a; }

	public DeliveryRequest makeRequest(String desc, String addr) {
		return new DeliveryRequest(this.name, addr, desc);
	}
	
	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }
	
	

}
