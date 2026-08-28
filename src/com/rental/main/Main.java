package com.rental.main;
import com.rental.service.FleetManager;
import com.rental.model.*;
import java.util.Scanner;
import com.rental.service.*;
import com.rental.exception.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FleetManager fleett = new FleetManager();
		
		int inputNum = 0;
		
		Car car1 = new Car("C-001","Toyota Fortuner", 4500.0, VehicleType.CAR );
		Motorcycle motor1 = new Motorcycle("M-001", "Honda ADV (Scooter)", 450.0, VehicleType.MOTORCYCLE);
		Truck truck1 = new Truck("T-001", "Isuzu Elf", 7000.0, VehicleType.TRUCK, 5.0);
		
		fleett.addVehicle(car1);
		fleett.addVehicle(motor1);
		fleett.addVehicle(truck1);
		
		System.out.println("VEHICLE RENTAL MANAGEMENT SYSTEM");
		System.out.println();
		System.out.println("1. Display All Vehicle");
		System.out.println("2. Rent a Vehicle");
		System.out.println("3. Return a Vehicle");
		System.out.println("4. Calculate Loyalty Discount:");
		System.out.println("5. Exit");
		
		try (Scanner userInput = new Scanner(System.in)){
			while(inputNum >= 0) {
				
				System.out.print("\nSelect an option: ");
				inputNum = userInput.nextInt(); 
				userInput.nextLine();
			
			
			switch (inputNum){
			case 1:
				fleett.DisplayFleet();
				break;
			case 2:
				
				System.out.print("Enter Vehicle ID to rent: ");
				String VID = userInput.nextLine();
				//userInput.nextLine();
				
				System.out.print("Enter Rental Duration (days): ");
				int inputDays = userInput.nextInt();
				//userInput.nextLine();
				
				System.out.print("Enter customer loyalty years: ");
				int inputLoyalYears = userInput.nextInt();
				//userInput.nextLine();
				
				Vehicle foundVehicle = fleett.findVehicle(VID);
				
				if (foundVehicle == null) {
					throw new NullPointerException("Error: Vehicle not found.");
					} else {
						try {
					        foundVehicle.rentVehicle(inputDays);
					        
					        
					        Vehicle.RentalReceipt receipt = foundVehicle.new RentalReceipt(inputDays, inputLoyalYears); 
					        receipt.displayReceipt();
					        
					    } catch (VehicleUnavailableException e) {
					        System.out.println(e.getMessage());
					    }
					}
				
				
				
				break;
			case 3:
					System.out.print("Enter Vehicle ID to return: ");
					String returnID = userInput.nextLine();
					//userInput.nextLine();
	                Vehicle vehicleToReturn = fleett.findVehicle(returnID);
	                
	                if (vehicleToReturn == null) {
	                    System.out.println("Error: Vehicle not found.");
	                } else {
	                    vehicleToReturn.returnVehicle();
	                    System.out.println("Success: Vehicle returned successfully!");
	                }
					
				break;
			case 4:
				System.out.print("Enter Customer Loyalty: ");
				int years = userInput.nextInt();
				//userInput.nextLine();
				
				double discount = fleett.calculateLoyaltyDiscount(years);
				System.out.println("Loyalty Discount Earned: " + discount + "%");
				break;
			case 5:
				System.out.println("Bye");
				inputNum = -1;
				break;
				
			default:
				System.out.println("Out of range, Please input number again");
				break;
		}
			
			
		}
		
			
		
			
		}
		
		
	
		
		
		
		
		
		
	}

}
