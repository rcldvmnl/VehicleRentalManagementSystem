package com.rental.model;

import com.rental.exception.VehicleUnavailableException;
import java.time.LocalDate;
import com.rental.service.Rentable;

public abstract class Vehicle implements Rentable{
	
		public void rentVehicle(int days) throws VehicleUnavailableException {
			if (this.status == RentalStatus.RENTED) 
			{
				throw new VehicleUnavailableException("This Vehicle is already Rented");
				
			}else this.status = RentalStatus.RENTED;
				
		}
		
		public void returnVehicle() 
		{
			this.status = RentalStatus.AVAILABLE;
		}
	
		private String id;
		public void setID(String id) {this.id = id;}
		public String getID() {return id;}
		
		private String brand;
		public void setBrand(String brand) {this.brand = brand;}
		public String getBrand() {return brand;}
		
		private double baseRate;
		public void setBaseRate(double baseRate) {this.baseRate = baseRate;}
		public double getBaseRate() {return baseRate;}
		
		private VehicleType type;
		public void setType(VehicleType type) {this.type = type;}
		public VehicleType getType() {return type;}
		
		private RentalStatus status = RentalStatus.AVAILABLE;
		public void setStatus(RentalStatus status) {this.status = status;}
		public RentalStatus getStatus() {return status;}
		
		public abstract double calculateTotalFee(int days);
		
		public Vehicle (String id, String brand, double baseRate,VehicleType type) 
		{
			this.id = id;
			this.brand = brand;
			this.baseRate = baseRate;
			this.type = type;
		}
		
		public void DisplayVehicle() {
			System.out.println("[ID: "+ getID() +"] Brand: "+ getBrand() + " | Type: "
		+ getType() + " | Status: " + getStatus() + " | Rate: " + getBaseRate() +"/day");
		}
		
		public class RentalReceipt {
			String receiptID;
			LocalDate startDate;
			LocalDate returnDate;
			double finalAmount;
			int durationDays;
			
			public RentalReceipt(int durationDays, int loyaltyAmount){
				this.receiptID = "REC-" + Math.round(Math.random() * 9000 + 1000);
				this.startDate = LocalDate.now();

				this.durationDays = durationDays;
				this.returnDate = LocalDate.now().plusDays(durationDays);
				this.finalAmount = calculateTotalFee(durationDays);
				
				
			}
			
			public void displayReceipt() {
				System.out.println("ID Receipt: " + receiptID);
				System.out.println("Start Date: " + startDate);
				System.out.println("Return Date : " + returnDate);
				System.out.println("Rent Duration: " + durationDays);
				System.out.println(calculateTotalFee(durationDays));
				System.out.println("Final Amount: " + finalAmount);
			}
			
		}
		
		
}


