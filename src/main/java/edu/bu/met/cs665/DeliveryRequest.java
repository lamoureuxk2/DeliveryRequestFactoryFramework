package edu.bu.met.cs665;

/**
 * Delivery Request Object, represented by 3 Strings, a shopName, delivery address, and Description of the order
 * @author lamoureuxk
 *
 */
public class DeliveryRequest {
	
	private String shopName;
	private String address;
	private String description;
	
	public DeliveryRequest(String name, String addr, String desc) {
		this.shopName = name;
		this.address = addr;
		this.description = desc;
	}

	public String getShopName() { return shopName; }

	public void setShopName(String shopName) { this.shopName = shopName; }

	public String getAddress() { return address; }

	public void setAddress(String address) { this.address = address; }

	public String getDescription() { return description; }

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Request from " + shopName + "\nDelivery: " + description + "\nTo: " + address;
	}

}
