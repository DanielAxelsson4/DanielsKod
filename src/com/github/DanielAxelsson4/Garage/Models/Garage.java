
package com.github.DanielAxelsson4.Garage.Models;

import java.util.concurrent.ConcurrentSkipListMap;

import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;

/**
 * 
 * @author Daniel Axelsson and Sohrab Azami
 * Class description: Garage class
 *
 */

public class Garage {

	protected String garageName;
	private ConcurrentSkipListMap<String, Vehicle> garageMap;
	protected int capacity;
	public boolean exists;




	public Garage(String garageName, int capacity) 
	{
		this.garageName = garageName;
		this.capacity = capacity;
		garageMap = new ConcurrentSkipListMap<String, Vehicle>(String.CASE_INSENSITIVE_ORDER);
	}
	/**
	 * Adds the Vehicle to the collection
	 * @param registragtionNumber Registration number of the vehicle
	 * @param newVehicle Vehicle
	 */
	public void addVehicle(String registragtionNumber, Vehicle newVehicle ) 
	{
		garageMap.put(newVehicle.getRegistrationNumber(), newVehicle);
		System.out.println("\n" + "Vehicle parked! \n ");
	}

	/**
	 * Removes the Vehicle from the collection
	 * @param newVehicle Vehicle
	 */
	public void removeVehicle(Vehicle newVehicle ) 
	{
		if (garageMap.containsKey(newVehicle.getRegistrationNumber())){
			garageMap.remove(newVehicle.getRegistrationNumber());
		}
	}
	/**
	 * For each vehicle in the collection call its toString method which lists its properties
	 * @param concurrentSkipListMap Collection of vehicles
	 */
	public void listVehicles(ConcurrentSkipListMap<String,Vehicle> concurrentSkipListMap) 
	{
		for (Vehicle nextVehicle : concurrentSkipListMap.values() ) {
			System.out.println(nextVehicle.toString() );
		}
	}
	/**
	 * See if a vehicle with the specified registerNumber exists in the collection and call it's toString method
	 * @param registerNumber Registration number of the vehicle
	 */
	public void listSpecificVehicle(String registerNumber) 
	{
		if(garageMap.containsKey(registerNumber)) {
			for (Vehicle nextVehicle : garageMap.values() ) {
				if(nextVehicle.getRegistrationNumber().equals(registerNumber)) 
				{
					exists = true;
					System.out.println("\n" + "Vehicle Found! \n");
					System.out.println(nextVehicle.toString() );	
				}
			}
		}
		else {
			exists = false;
		}
	}
	/**
	 * See if a vehicle with the specified registerNumber exists in the collection and remove it from the collection
	 * @param registerNumber Registration number of the vehicle
	 */
	public void removeSpecificVehicle(String registerNumber) 
	{
		for (Vehicle nextVehicle : garageMap.values() ) {
			if(nextVehicle.getRegistrationNumber().equals(registerNumber)) 
			{
				garageMap.remove(registerNumber);
				System.out.println("\n" + "Vehicle removed! \n");
			}
		}
	}
	/**
	 * Go inside the collection and returns the vehicle with the specified registerNumber 
	 * @param registerNumber Registration number of the vehicle
	 * @return vehicle Vehicle object
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
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

	@Override
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("-------- " + "Garage" + " ---------\n");
		sb.append("Name: ");
		sb.append(this.garageName);
		sb.append("\n");
		sb.append("Amount of Vehicles: ");
		sb.append(this.getGarageMap().size());
		sb.append("\n");
		sb.append("Capacity: ");
		sb.append(capacity + 1);
		return sb.toString();
	}

	public String getGarageName() 
	{
		return garageName;
	}

	public int getCapacity() 
	{
		return capacity;
	}

	public ConcurrentSkipListMap<String,Vehicle> getGarageMap() 
	{
		return garageMap;
	}

	protected int getNumberOfVehicles() {
		return garageMap.size();
	}












}


