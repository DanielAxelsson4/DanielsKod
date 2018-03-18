package com.github.DanielAxelsson4.Garage.MVVM;


import java.util.concurrent.ConcurrentSkipListMap;


import com.github.DanielAxelsson4.Garage.Exceptions.GarageAlreadyExistsException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageIsFullException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.Models.Garage;
import com.github.DanielAxelsson4.Garage.Models.Vehicle;

/**
 * Class description: GarageHandler class
 * @author Daniel Axelsson and Sohrab Azami
 *
 *
 */


public abstract class GarageHandler {

	protected Garage garage;
	//protected Garage apg;
	private ConcurrentSkipListMap<String, Garage> garageList = new ConcurrentSkipListMap<String, Garage>(String.CASE_INSENSITIVE_ORDER);
	protected Vehicle vehicle;
	private boolean exists;

	public GarageHandler()
	{
		super();
		this.garageList = new ConcurrentSkipListMap<String, Garage>(String.CASE_INSENSITIVE_ORDER);
	}
	/**
	 * Creates and returns a garage
	 * @param garageName Name of garage
	 * @param capacity Capacity of the garage
	 * @return apg Garage
	 */
	public Garage createGarage(String garageName, int capacity)
	{
		garage = new Garage(garageName, capacity);
		return garage;
	}
	/**
	 * Adds the garage to the collection
	 * @param garageName Name of garage
	 * @param garage Garage object
	 * @throws GarageAlreadyExistsException Garage already exists
	 */
	public void addGarage(String garageName, Garage garage) throws GarageAlreadyExistsException
	{
		if(garageList.containsKey(garageName))
		{
			throw new GarageAlreadyExistsException();
		}else {
			garageList.put(garageName, garage);
			System.out.println("\n" + "Garage " + garageName + " was added \n");

		}
	}
	/**
	 * Removes the specified garage from the collection
	 * @param garageName Name of garage
	 * @throws GarageNotFoundException Garage was not found
	 */
	public void removeGarage(String garageName) throws GarageNotFoundException
	{
		for(Garage garage : this.garageList.values())
		{
			if(garage.getGarageName().equalsIgnoreCase(garageName))
			{
				garageList.remove(garageName);
				System.out.println("Garage " + garageName + " was removed");
				return;
			}
		}
		throw new GarageNotFoundException();
	}
	/**
	 * Lists all garages
	 */
	public void listGarages()
	{
		for(Garage garage : this.garageList.values())
		{
			System.out.println(garage.toString() );
		}
	}

	/**
	 * Prints all vehicles in the specified garage
	 * @param garageName Name of garage
	 * @throws GarageNotFoundException Garage was not found
	 */
	public void viewGarage(Garage garageName) throws GarageNotFoundException
	{
		garage.listVehicles(garage.getGarageMap());

	}
	/**
	 * Searches the collection of garages and returns the garage with the specified garageName and returns the garage
	 * @param garageName Name of garage
	 * @return garage Garage object
	 * @throws GarageNotFoundException Garage was not found
	 */
	public Garage findGarage(String garageName) throws GarageNotFoundException
	{
		for(Garage garage : this.garageList.values())
		{
			if(garage.getGarageName().equalsIgnoreCase(garageName))
				return garage;
		}
		throw new GarageNotFoundException();
	}
	/**
	 * Searches the collection of garages for a garage not over capacity and with the specified garageName and returns the garage
	 * @param garageName Name of garage
	 * @return garage Garage object
	 * @throws GarageNotFoundException Garage was not found
	 * @throws GarageIsFullException Garage is full
	 */
	public Garage findGarageWithinSize(String garageName) throws GarageNotFoundException, GarageIsFullException
	{
		for(Garage garage : this.garageList.values())
		{
			if(garage.getGarageMap().size() <= garage.getCapacity() && garage.getGarageName().equalsIgnoreCase(garageName))
			{
				return garage;
			}
		}
		if (!this.garageList.containsKey(garageName))
		{
			throw new GarageNotFoundException();
		}
		else
		{
			throw new GarageIsFullException();
		}
	}


	/**
	 * Find the garage and add the vehicle to the collection of vehicles
	 * @param vehicle Specified vehicle
	 * @param garageName Name of garage
	 * @throws GarageNotFoundException Garage was not found
	 * @throws GarageIsFullException Garage is full
	 */
	public void addVehicle(Vehicle vehicle, String garageName) throws GarageNotFoundException, GarageIsFullException
	{
		garage = findGarageWithinSize(garageName);
		garage.addVehicle(vehicle.getRegistrationNumber(), vehicle);
	}
	/**
	 * Find the garage and remove the vehicle from the collection of vehicles
	 * @param vehicle Specified vehicle
	 * @param garageName Name of garage
	 * @throws GarageNotFoundException Garage was not found
	 */
	public void removeVehicle(Vehicle vehicle, String garageName) throws GarageNotFoundException
	{
		Garage garage = findGarage(garageName);
		garage.removeVehicle(vehicle);
	}
	/**
	 * Go inside each garage and call the listVehicles method
	 */
	public void listAllVehicles()
	{
		//
		for(Garage garage : this.garageList.values())
		{
			garage.listVehicles(garage.getGarageMap());
		}
	}
	/**
	 *
	 * @param registerNumber Specified registerNumber
	 * @return vehicle Vehicle
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
	public Vehicle findSpecificVehicle(String registerNumber) throws VehicleNotFoundException
	{
		for(Garage garage : this.garageList.values())
		{
			vehicle = garage.findVehicle(registerNumber);
			return vehicle;
		}
		return null;
	}
	/**
	 * Go inside each garage and see if it contains a vehicle with the specified registerNumber and print it
	 * @param registerNumber Specified registerNumber
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
	public void listSpecificVehicle(String registerNumber) throws VehicleNotFoundException
	{
		exists = false;
		for(Garage garage : this.garageList.values())
		{
			if (garage.getGarageMap().containsKey(registerNumber))
			{
				exists = true;
				garage.listSpecificVehicle(registerNumber);
			}
		}
		if (!exists)
		{
			throw new VehicleNotFoundException();
		}
	}
	/**
	 * Go inside each garage and see if it contains a vehicle with the specified registerNumber and remove it
	 * @param registerNumber Specified registerNumber
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
	public void removeSpecificVehicle(String registerNumber) throws VehicleNotFoundException
	{
		exists = false;
		for(Garage garage : this.garageList.values())
		{
			if (garage.getGarageMap().containsKey(registerNumber))
			{
				exists = true;
				garage.removeSpecificVehicle(registerNumber);
			}
		}
		if (!exists)
		{
			throw new VehicleNotFoundException();
		}

	}

	public ConcurrentSkipListMap<String, Garage> getNotFullGarageList()
	{
		return this.garageList;
	}


}
