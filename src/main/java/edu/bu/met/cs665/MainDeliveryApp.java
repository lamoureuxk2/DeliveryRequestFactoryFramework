package edu.bu.met.cs665;
import java.util.*;

import org.apache.log4j.Logger;

public class MainDeliveryApp {
	
	private static Logger logger = Logger.getLogger(MainDeliveryApp.class);
	
	static ArrayList<Shop> shops = new ArrayList<>();
	static ArrayList<Driver> drivers = new ArrayList<>();


	public static void main(String[] args) {
		shops.add( new Shop("Shop1", "300 Commonwealth avenue") );
		drivers.add( new Driver("John"));
		drivers.add( new Driver("Mark"));
		drivers.add( new Driver("Shawn"));
		
		String requestedShop = "Shop1";
		String reqDetails = "One Large Pizza";
		String deliveryAddress = "100 Blue Street";
		
		DeliveryRequest req = makeRequest(requestedShop, reqDetails, deliveryAddress);
		
		if(req == null) {
			logger.error("Null DeliveryRequest, no matching shop name");
			System.exit(1);
		}
		
		if( !assignRequest(req) ) {
			logger.info("All drivers already have requests");
			System.exit(1);
		}
		
		System.out.println("Sucessfully Assigned Request");
		
	}
	
	public static DeliveryRequest makeRequest(String shop, String desc, String addr) {
		for(Shop s : shops) {
			if( s.getName().equals(shop)) {
				return s.makeRequest(desc, addr);
			}
		}
		return null;
	}
	
	public static boolean assignRequest(DeliveryRequest req) {
		for( Driver d : drivers) {
			if( d.setNewRequest(req) ) {
				logger.info(d.getName() + " assigned Request");
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
