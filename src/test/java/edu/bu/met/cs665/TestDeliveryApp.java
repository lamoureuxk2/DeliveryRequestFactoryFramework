package edu.bu.met.cs665;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class TestDeliveryApp {
	
	static ArrayList<Shop> shops = MainDeliveryApp.shops;
	static ArrayList<Driver> drivers = MainDeliveryApp.drivers;
	 
	/**
	 * Tests if request is successfully assigned, rechecks all drivers to check if request is held by a driver.
	 */
	@Test
	public void testSuccessfulRequest() {
		shops.clear();
		drivers.clear();
		shops.add( new Shop("Shop1", "300 Commonwealth avenue") );
		drivers.add( new Driver("John"));
		drivers.add( new Driver("Mark"));
		drivers.add( new Driver("Shawn"));
		
		DeliveryRequest req = MainDeliveryApp.makeRequest("Shop1", "Pizza", "3 Blue Street");
		assertTrue(MainDeliveryApp.assignRequest(req));
		
		boolean requestInDriverList = false;
		for(Driver d : drivers) {
			if(d.getCurrentRequest() == null) continue;
			if(d.getCurrentRequest().equals(req)) {
				requestInDriverList = true;
				break;
			}
		}
		assertTrue(requestInDriverList);
	}
	
	/**
	 * Gives all Drivers requests. Tests that an attempt at assigning another will be rejected.
	 */
	@Test
	public void testFailIfDriversOccupied() {
		MainDeliveryApp.clearRequests();
		MainDeliveryApp.assignRequest(MainDeliveryApp.makeRequest("Shop1", "Pizza", "3 Blue Street"));
		MainDeliveryApp.assignRequest(MainDeliveryApp.makeRequest("Shop1", "Calzone", "5 Red Street"));
		MainDeliveryApp.assignRequest(MainDeliveryApp.makeRequest("Shop1", "Pupusa", "7 Green Street"));
		 
		assertFalse(MainDeliveryApp.assignRequest(new DeliveryRequest("Shop1", "Food", "Valid addr")));
	}
	
	/**
	 * Tests that a null request object is returned if an invalid shop name is used.
	 */
	@Test
	public void testNullIfWrongShopName() {
		shops.clear();
		shops.add( new Shop("Shop1", "300 Commonwealth avenue") );
		assertNull(MainDeliveryApp.makeRequest("WrongName", "Valid Desc", "Valid Addr"));
		shops.clear();
		assertNull(MainDeliveryApp.makeRequest("Shop1", "Valid Desc", "Valid Addr"));
	}

}
