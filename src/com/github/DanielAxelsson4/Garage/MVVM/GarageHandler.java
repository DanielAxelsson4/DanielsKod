package com.github.DanielAxelsson4.Garage.MVVM;


import java.util.concurrent.ConcurrentSkipListMap;
import com.github.DanielAxelsson4.Garage.Exceptions.AirlineNameNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.AirplaneNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.BoatNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.BusNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.CarNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.ColorNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageAlreadyExistsException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageIsFullException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.MotorCycleNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.Models.AirPlane;
import com.github.DanielAxelsson4.Garage.Models.Boat;
import com.github.DanielAxelsson4.Garage.Models.Bus;
import com.github.DanielAxelsson4.Garage.Models.Car;
import com.github.DanielAxelsson4.Garage.Models.Garage;
import com.github.DanielAxelsson4.Garage.Models.Motorcycle;
import com.github.DanielAxelsson4.Garage.Models.Vehicle;

/**
 * 
 * @author Daniel Axelsson and Sohrab Azami
 * Class description: GarageHandler class
 *
 */


public abstract class GarageHandler {

	static Garage garage;
	protected Garage apg;
	private ConcurrentSkipListMap<String, Garage> garageList = new ConcurrentSkipListMap<String, Garage>(String.CASE_INSENSITIVE_ORDER);
	protected Vehicle vehicle;
	private boolean exists;

	public GarageHandler() 
	{
		super();
		this.garageList = new ConcurrentSkipListMap<String, Garage>();
	}

	/**
	 * Creates and returns a garage
	 * @param garageName Name of garage
	 * @param capacity Capacity of the garage
	 * @return apg Garage
	 */
	public Garage createGarage(String garageName, int capacity)
	{
		apg = new Garage(garageName, capacity);
		return apg;
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



	/**
	 * Creates a new Airplane vehicle
	 * @param registrationNumber RegistrationNumber of vehicle
	 * @param numberOfWheels Number of wheels on the vehicle
	 * @param airlineName Airline name of the vehicle
	 * @param parkedGarage Name of the garage the airplane is stored in
	 * @return
	 */
	public AirPlane createAirplane(String registrationNumber, int numberOfWheels, String airlineName, String parkedGarage ) 
	{
		AirPlane airplane = null;
		try 
		{
			airplane = new AirPlane(registrationNumber, numberOfWheels, airlineName, parkedGarage);
		}
		catch(AirlineNameNotFoundException e)
		{
			System.out.println("The airline name " + airlineName + " was not found \n Valid airlinenames are: SAS, Alitalia, Berlin");
			return null;
		}
		catch(AirplaneNotFoundException e)
		{
			System.out.println("Airplane not found");
			return null;
		}
		return airplane;
	}

	/**
	 * Creates a new Car vehicle
	 * @param registrationNumber RegistrationNumber of vehicle
	 * @param numberOfWheels Number of wheels on the vehicle
	 * @param color Color of the vehicle
	 * @param power Horsepower of the vehicle
	 * @param parkedGarage Name of the garage the car is stored in
	 * @return
	 */
	public Car createCar(String registrationNumber, int numberOfWheels, String color, int power, String parkedGarage) 
	{
		Car car = null;
		try 
		{
			car = new Car(registrationNumber, color, numberOfWheels, power, parkedGarage);
		}
		catch (ColorNotFoundException e) {
			System.out.println("The color was not found \n Valid colors are: Black, White, Red, Orange, Yellow, Green, Cyan, Blue, Purple, Magenta, Grey");
			return null;
		}
		catch(CarNotFoundException e)
		{
			System.out.println("Car was not found");
			return null;
		}
		return car;
	}
	/**
	 * Creates a new Boat vehicle
	 * @param registrationNumber RegistrationNumber of vehicle
	 * @param color Color of vehicle
	 * @param length Length of vehicle
	 * @param lifeboats Lifeboats of vehicle
	 * @param parkedGarage Name of the garage the boat is stored in
	 * @return
	 */
	public Boat createBoat(String registrationNumber, String color, int length, int lifeboats, String parkedGarage ) 
	{
		Boat boat = null;
		try 
		{
			boat = new Boat(registrationNumber, color, length, lifeboats, parkedGarage);
		}
		catch(BoatNotFoundException e)
		{
			System.out.println("Boat was not found");
			return null;
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Red, Orange, Yellow, Green, Cyan, Blue, Purple, Magenta, Grey");
			return null;
		}
		return boat;
	}
	/**
	 * Creates a new Motorcycle vehicle
	 * @param registrationNumber RegistrationNumber of vehicle
	 * @param color Color of vehicle
	 * @param cylinderVolume Cylinder volume of vehicle in liters
	 * @param parkedGarage Name of the garage the motorcycle is stored in
	 * @return
	 */
	public Motorcycle createMotorcycle(String registrationNumber, String color, int cylinderVolume, String parkedGarage) 
	{
		Motorcycle motorcycle = null;
		try 
		{
			motorcycle = new Motorcycle(registrationNumber, color, cylinderVolume, parkedGarage);
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Red, Orange, Yellow, Green, Cyan, Blue, Purple, Magenta, Grey");
			return null;
		}
		catch(MotorCycleNotFoundException e)
		{
			System.out.println("MotorCycle not found");
			return null;
		}
		return motorcycle;
	}

	/**
	 * Creates a new Bus vehicle
	 * @param registrationNumber RegistrationNumber of vehicle
	 * @param color Color of vehicle
	 * @param numberOfWheels Number of wheels on the vehicle
	 * @param numberOfSeats Number of seats on the vehicle
	 * @param parkedGarage Name of the garage the bus is stored in
	 * @return
	 */
	public Bus createBus(String registrationNumber, String color, int numberOfWheels, int numberOfSeats, String parkedGarage) 
	{
		Bus bus = null;
		try 
		{
			bus = new Bus(registrationNumber, color, numberOfWheels, numberOfSeats, parkedGarage);
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Red, Orange, Yellow, Green, Cyan, Blue, Purple, Magenta, Grey");
			return null;
		}
		catch(BusNotFoundException e)
		{
			System.out.println("Bus not found");
			return null;
		}
		return bus;
	}

	public ConcurrentSkipListMap<String, Garage> getNotFullGarageList()
	{
		return this.garageList;
	}


}
