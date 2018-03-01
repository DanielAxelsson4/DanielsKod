
package models;

import utilities.VehicleType;

public class Bus extends Vehicle {

	public Bus(String registrationNumber, String color, int numberOfWheels, int numberOfSeats) {
		super(registrationNumber);
		this.numberOfWheels = numberOfWheels;
		this.vehicleType = VehicleType.BUS;

	}



}

