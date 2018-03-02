package models;

import utilities.GarageType;

public class BoatGarage extends Garage {
	
	public BoatGarage(String garageName, GarageType garageType) {
		super(garageName);
		this.garageType = GarageType.CAR_GARAGE;
	}
	
	public GarageType getGarageType() {
		return this.garageType;
	}

	@Override
	public void addVehicle(String registrationNumber, Vehicle newVehicle){
		this.addVehicle(registrationNumber, newVehicle);
		//add something if you need
	}

	public void removeVehicle(Vehicle newVehicle ) {
		this.removeVehicle(newVehicle);
	}
}
