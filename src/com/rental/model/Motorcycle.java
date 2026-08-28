package com.rental.model;

public class Motorcycle extends Vehicle{

	public Motorcycle(String id, String brand, double baseRate, VehicleType type) {
		super(id, brand, baseRate, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateTotalFee(int days) {
		// TODO Auto-generated method stub
		double discount;
		if(days > 7) 
		{
			discount = (getBaseRate() * days);
			discount = discount * 0.90;
			return Math.round(discount);
			
		}
		//notSevenDays = (getBaseRate() + 30.0) * days;
		return (getBaseRate()* days);
	}

}
