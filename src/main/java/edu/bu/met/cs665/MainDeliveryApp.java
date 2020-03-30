package edu.bu.met.cs665;
import java.util.*;

import org.apache.log4j.Logger;

/**
 * Generates a shop list with one shop and a Driver list with 3 drivers.
 * Makes one requests and assigns it to first available driver.
 * 
 * @author lamoureuxk
 *
 */
public class MainDeliveryApp {
	
	private static Logger logger = Logger.getLogger(MainDeliveryApp.class);
	
	//These lists are used here and also by the JUnit tests
	static ArrayList<Shop> shops = new ArrayList<>();
	static ArrayList<Driver> drivers = new ArrayList<>();


	public static void main(String[] args) {
		
		//Populate the lists
		shops.add( new Shop("Shop1", "300 Commonwealth avenue") );
		drivers.add( new Driver("John"));
		drivers.add( new Driver("Mark"));
		drivers.add( new Driver("Shawn"));
		
		//Parameters for the Delivery Request
		String requestedShop = "Shop1";
		String reqDetails = "One Large Pizza";
		String deliveryAddress = "100 Blue Street";
		
		//Generate a Request, see method comments for details
		DeliveryRequest req = makeRequest(requestedShop, reqDetails, deliveryAddress);
		
		//If program attempts to make a request with a shop name that is not in the list, the 
		//DeliveryRequest object will be null
		if(req == null) {
			logger.error("Null DeliveryRequest, no matching shop name");
			System.exit(1);
		}
		
		//If all drivers have requests already, the request will not be assigned
		if( !assignRequest(req) ) {
			logger.info("All drivers already have requests");
			System.exit(1);
		}
	}
	
	/**
	 * Searches if there is a Shop object whose name matches the name that is requested.
	 * If not, null is returned. If yes, then the method calls the Shop object's 
	 * "makeRequest" method (different from this method) to generate a request.
	 * @param shop - name of shop to make request with
	 * @param desc  -description of delivery request
	 * @param addr - address to delivery to
	 * @return
	 */
	public static DeliveryRequest makeRequest(String shop, String desc, String addr) {
		for(Shop s : shops) {
			if( s.getName().equals(shop)) {
				return s.makeRequest(desc, addr);
			}
		}
		return null;
	}
	
	/**
	 * Searches list of drivers for first driver that is free to accept the request
	 * Returns true if a request is taken, false if no available drivers.
	 * @param req - The Delivery request to assign
	 * @return
	 */
	public static boolean assignRequest(DeliveryRequest req) {
		for( Driver d : drivers) {
			if( d.setNewRequest(req) ) {
				logger.info(d.getName() + " assigned Request: " + d.getCurrentRequest());
				return true;
			}
		}
		return false;
	}
	
	static void clearRequests() {
		for(Driver d : drivers) {
			d.completeRequest();
		}
	}
	
	static void clearShops() {
		shops.clear();
	} 

}
