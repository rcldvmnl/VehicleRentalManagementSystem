package com.rental.service;
import java.util.ArrayList;
import com.rental.model.Vehicle;
import com.rental.model.VehicleType;

public class FleetManager {
	ArrayList<Vehicle> fleet = new ArrayList<>();
	
	public Vehicle findVehicle (String id) {
		for(Vehicle v : fleet) {
			if(v.getID().equals(id)) {
				return v;
			} 
		}
		return null;
	}
	
	public ArrayList<Vehicle> findVehicle (VehicleType type) {
		ArrayList<Vehicle> findMatch = new ArrayList<>();
		
		for (Vehicle v : fleet) {
			if(v.getType().equals(type)) {
				findMatch.add(v);
			}
		}
		return findMatch;
	}
	
	public void DisplayFleet() {
		for(Vehicle v : fleet) {
			v.DisplayVehicle();
		}
	}
	
	public double calculateLoyaltyDiscount(double years) {
		if (years == 0) {
			return 0.0;
		}
			return 2.0 + calculateLoyaltyDiscount(years - 1);
		}
	
	public void addVehicle(Vehicle v) {
		fleet.add(v);
	}
}
