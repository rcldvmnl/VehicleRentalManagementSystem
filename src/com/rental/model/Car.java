package com.rental.model;

public class Car extends Vehicle{

	public Car(String id, String brand, double baseRate, VehicleType type) {
		super(id, brand, baseRate, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateTotalFee(int days) {
		// TODO Auto-generated method stub
		return (getBaseRate() + 15.0) * days;
	}

}
