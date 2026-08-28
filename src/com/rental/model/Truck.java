package com.rental.model;

public class Truck extends Vehicle{

	private double cargoCapacityInTons;
	
	public Truck(String id, String brand, double baseRate, VehicleType type,double cargoCapacityInTons) {
		super(id, brand, baseRate, type);
		// TODO Auto-generated constructor stub
		this.cargoCapacityInTons = cargoCapacityInTons;
	}

	public Truck(String id, String brand, double baseRate, VehicleType type) {
		super(id, brand, baseRate, type);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public double calculateTotalFee(int days) {
		// TODO Auto-generated method stub
		return (getBaseRate() + (cargoCapacityInTons * 10)) * days;
	}

}
