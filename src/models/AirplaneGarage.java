package models;

import utilities.GarageType;

public class AirplaneGarage extends Garage{

	GarageType garageType;
	
	public AirplaneGarage() {
		this.garageType = GarageType.AIRPLANE_GARAGE;
		
	}
	
	@Override
	public void addVehicle(Vehicle newVehicle){
		
		this.addVehicle(newVehicle);
		//add something if you need
	}
	
	public void createAirplane()
	{
		this.createAirplane();
		//add something if you need
		
	}
}
