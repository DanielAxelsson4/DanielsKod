package mvvm;

import java.util.TreeMap;

import javax.swing.JOptionPane;

import models.AirPlane;
import models.AirlineNameNotFoundException;
import models.AirplaneGarage;
import models.AirplaneNotFoundException;
import models.Boat;
import models.BoatGarage;
import models.BoatNotFoundException;
import models.Bus;
import models.BusGarage;
import models.BusNotFoundException;
import models.Car;
import models.CarGarage;
import models.CarNotFoundException;
import models.ColorNotFoundException;
import models.Garage;
import models.GarageNotFoundException;
import models.MotorCycleNotFoundException;
import models.Motorcycle;
import models.MotorcycleGarage;
import models.Vehicle;
import utilities.GarageType;

public abstract class GarageHandler {

	protected TreeMap<String, Garage> NotFullGarageList;
	protected TreeMap<String, Garage> fullGarageList;
	protected AirplaneGarage apg;
	protected BoatGarage bog;
	protected BusGarage bug;
	protected CarGarage cag;
	protected MotorcycleGarage mog;


	public void addVehicle(Vehicle vehicle, String garageName) throws GarageNotFoundException
	{
		//create vehicle
		//Garage.addVehicle
		Garage garage = findGarage(garageName);
		garage.addVehicle(vehicle.getRegistrationNumber(), vehicle);
		//i am done
	}

	public GarageHandler() {
		super();
		this.NotFullGarageList = new TreeMap<String, Garage>();
		this.fullGarageList = new TreeMap<String, Garage>();
	}

	public void removeVehicle(Vehicle vehicle, String garageName) throws GarageNotFoundException
	{
		//find vehicle
		Garage garage = findGarage(garageName);
		//Garage.removeVehicle
		garage.removeVehicle(vehicle);
	}

	public Garage CreateGarage(String garageName, GarageType garageType)
	{
		Garage genGarage = null;

		switch(garageType)
		{
		case	AIRPLANE_GARAGE:
			apg = new AirplaneGarage(garageName, garageType);
			genGarage = apg;
			break;
		case	BOAT_GARAGE:
			bog = new BoatGarage(garageName, garageType);
			genGarage = apg;
			break;
		case	BUS_GARAGE:
			bug = new BusGarage(garageName, garageType);
			genGarage = apg;
			break;
		case	CAR_GARAGE:
			cag = new CarGarage(garageName, garageType);
			genGarage = apg;
			break;
		case	MOTORCYCLE_GARAGE:
			mog = new MotorcycleGarage(garageName, garageType);
			genGarage = apg;
			break;
		}

		return genGarage;

	}

	public void addToEmptyGarage(String garageName, Garage garage) throws GarageAlreadyExistsException
	{
		if(NotFullGarageList.containsKey(garageName))
		{
			throw new GarageAlreadyExistsException();
		}else {
			NotFullGarageList.put(garageName, garage);
		}
	}

	public void addToFullGarage(String garageName, Garage garage) throws GarageAlreadyExistsException
	{
		if(fullGarageList.containsKey(garageName))
		{
			throw new GarageAlreadyExistsException();
		}else {
			fullGarageList.put(garageName, garage);
		}
	}

	public void removeFromEmptyGarage(String garageName) throws GarageNotFoundException
	{
		if(NotFullGarageList.containsKey(garageName))
		{
			throw new GarageNotFoundException();
		}else {
			NotFullGarageList.remove(garageName);
		}
	}

	public void removeFromFullGarage(String garageName) throws GarageNotFoundException
	{

		if(fullGarageList.containsKey(garageName))
		{
			throw new GarageNotFoundException();
		}else {
			fullGarageList.remove(garageName);
		}
	}

	public Garage findGarage(String garageName) throws GarageNotFoundException
	{
		//go intot the collection of Garages in this class and find a Garage
		//check if the Garage is not full!
		//check the Garage Type is Airplane, Car, ....
		for(Garage garage : this.NotFullGarageList.values())
		{
			if(garage.getGarageName().equalsIgnoreCase(garageName))
				return garage;
		}
		for(Garage garage : this.fullGarageList.values())
		{
			if(garage.getGarageName().equalsIgnoreCase(garageName))
				return garage;
		}

		throw new GarageNotFoundException();
	}

	public TreeMap<String, Garage> getEmptyGarageList()
	{
		return this.NotFullGarageList;
	}

	public AirPlane createAirplane(String registrationNumber, int numberOfWheels, String airlineName ) {

		AirPlane airplane = null;
		try {
			airplane = new AirPlane(registrationNumber, numberOfWheels, airlineName);
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

	public Car createCar(String registrationNumber, int numberOfWheels, String color, int power) {
		Car car = null;
		try {
			car = new Car(registrationNumber, color, numberOfWheels, power);
		}
		catch (ColorNotFoundException e) {
			System.out.println("The color was not found \n Valid colors are: Black, White, Green, Red, Yellow");
			return null;
		}
		catch(CarNotFoundException e)
		{
			System.out.println("Car was not found");
			return null;
		}
		return car;
	}

	public Boat createBoat(String registrationNumber, String color, int length, int lifeboats ) {

		Boat boat = null;
		try {
			boat = new Boat(registrationNumber, color, length, lifeboats);
		}
		catch(BoatNotFoundException e)
		{
			System.out.println("Boat was not found");
			return null;
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Green, Red, Yellow");
			return null;
		}
		return boat;
	}

	public Motorcycle createMotorcycle(String registrationNumber, String color, int cylinderVolume) {
		Motorcycle motorcycle = null;
		try {
			motorcycle = new Motorcycle(registrationNumber, color, cylinderVolume);
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Green, Red, Yellow");
			return null;
		}
		catch(MotorCycleNotFoundException e)
		{
			System.out.println("MotorCycle not found");
			return null;
		}
		return motorcycle;
	}


	public Bus createBus(String registrationNumber, String color, int numberOfWheels, int numberOfSeats) 
	{

		Bus bus = null;
		try {
			bus = new Bus(registrationNumber, color, numberOfWheels, numberOfSeats);
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Green, Red, Yellow");
			return null;
		}
		catch(BusNotFoundException e)
		{
			System.out.println("Bus not found");
			return null;
		}
		return bus;
	}
	
	private void dummy()
	{
		
	}

}
