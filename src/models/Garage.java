
package models;

import java.util.TreeMap;

import utilities.GarageType;

public abstract class Garage {

	protected String garageName;
	protected GarageType garageType;
//	protected String registrationNumber = null;
//	protected String color = null;
//	protected Integer numberOfWheels = null;
//	protected int cylinderVolume = 0;
//	protected int numberOfSeats = 0;
//	protected int lifeboats = 0;
//	protected int length = 0;
//	protected Integer power = null;
//	protected String airlineName = null;


	protected TreeMap<String, Vehicle> garageMap;

	
	public TreeMap<String, Vehicle> getGarageMap() {
		return garageMap;
	}

	public Garage(String garageName) {
		super();
		this.garageName = garageName;
		garageMap = new TreeMap<String, Vehicle>();
	}

	protected TreeMap<String,Vehicle> getVehicleMap() {
		return garageMap;
	}

	public void addVehicle(String registragtionNumber, Vehicle newVehicle ) {
		garageMap.put(newVehicle.getRegistrationNumber(), newVehicle);

	}
	
	protected void listVehicles(TreeMap<String,Vehicle> garageMap) {

		for (Vehicle nextVehicle : garageMap.values() ) {
			System.out.println(nextVehicle.toString() );
		}
	}

	public void removeVehicle(Vehicle newVehicle ) {
		if (garageMap.containsKey(newVehicle.getRegistrationNumber())){
			garageMap.remove(newVehicle.getRegistrationNumber());
		}
	}

	protected int getNumberOfVehicles() {
		return garageMap.size();
	}

	public Vehicle findVehicle(String registerNumber) throws VehicleNotFoundException
	{
		for(Vehicle vehicle : garageMap.values())
		{
			if(vehicle.getRegistrationNumber().equalsIgnoreCase(registerNumber))
			{
				return vehicle;
			}
			else
				throw new VehicleNotFoundException();
		}
		return null;
	}

	public String getGarageName() {
		return garageName;
	}
	
	









}


