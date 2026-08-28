package com.rental.service;

import com.rental.exception.VehicleUnavailableException;

public interface Rentable {
	
	
	void rentVehicle(int days) throws VehicleUnavailableException;
	void returnVehicle();
	double calculateTotalFee(int days);
	
}
