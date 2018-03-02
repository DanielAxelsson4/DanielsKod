package mvvm;

import java.util.TreeMap;

import models.Garage;
import models.Vehicle;

public abstract class GarageHandler {
	
	private TreeMap<String, Garage> garageList;
	
	public Garage getGarage(String garageName)
	{
		return null;
	}

	public void addVehicle(Vehicle v)
	{
		//create vehicle
		//Garage.addVehicle
		//i am done
	}
	
	public void removeVehicle(Vehicle v) 
	{
		//Garage.removeVehicle
	}
	
	public Vehicle findVehicle(String registerNumber) 
	{
		
		return null;
	}
	
	public Garage getlistGarage()
	{
		
		return null;
	}
}
