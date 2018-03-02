
package models;

import java.util.TreeMap;

import javax.swing.JOptionPane;

public abstract class Garage {

	private String registrationNumber = null;
	private String color = null;
	private Integer numberOfWheels = null;
	private int cylinderVolume = 0;
	private int numberOfSeats = 0;
	private int lifeboats = 0;
	private int length = 0;
	private Integer power = null;
	private String airlineName = null;


	public static TreeMap<String, Vehicle> garageMap;



	protected Garage() {
		garageMap = new TreeMap<String, Vehicle>();
	}

	protected static TreeMap<String,Vehicle> getVehicleMap() {
		return garageMap;
	}

	protected void addVehicle(Vehicle newVehicle ) {
		garageMap.put(newVehicle.getRegistrationNumber(), newVehicle);

	}


	protected void listVehicles(TreeMap<String,Vehicle> garageMap) {

		for (Vehicle nextVehicle : garageMap.values() ) {
			System.out.println(nextVehicle.toString() );
		}
	}

	protected void deleteVehicle(Vehicle newVehicle ) {
		if (garageMap.containsKey(newVehicle.getRegistrationNumber())){
			garageMap.remove(newVehicle.getRegistrationNumber());
		}
	}

	protected int getNumberOfVehicles() {
		return garageMap.size();
	}

	protected void createCar() {
		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");
			color = JOptionPane.showInputDialog("Input Color of the Car...");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number of wheels..."));
			power = Integer.parseInt(JOptionPane.showInputDialog("Input engine power of vehicle"));
			Car car = new Car(registrationNumber, color, numberOfWheels, power);
			garageMap.put(car.getRegistrationNumber(), car);
		}
		catch (ColorNotFoundException e) {
			System.out.println("The color : " + color + " was not found \n Valid colors are: Black, White, Green, Red, Yellow");
		}
	}

	protected void createBoat() {

		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the boat ...");
			color = JOptionPane.showInputDialog("Input Color of the Car...");
			length = Integer.parseInt(JOptionPane.showInputDialog("Input length in metres"));
			lifeboats = Integer.parseInt(JOptionPane.showInputDialog("Input number of lifeboats"));
			Boat boat = new Boat(registrationNumber, color, length, lifeboats);
			garageMap.put(boat.getRegistrationNumber(), boat);
		}
		catch(BoatNotFoundException e)
		{
			System.out.println("Boat was not found");
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color + " was not found" + " was not found \n Valid colors are: Black, White, Green, Red, Yellow");
		}
	}

	protected void createAirplane() {
		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the airplane ...");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number of wheels..."));
			airlineName = JOptionPane.showInputDialog("Input air line name");
			AirPlane airplane = new AirPlane(registrationNumber, numberOfWheels, airlineName);
			garageMap.put(airplane.getRegistrationNumber(), airplane);
		}
		catch(AirlineNameNotFoundException e)
		{
			System.out.println("The airline name " + airlineName + " was not found \n Valid airlinenames are: SAS, Alitalia, Berlin");

		}
	}

	protected void createMotorcycle() {
		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the motorcycle ...");
			color = JOptionPane.showInputDialog("Input Color of the Car...");
			cylinderVolume = Integer.parseInt(JOptionPane.showInputDialog("Input cylinder volume in litres..."));
			Motorcycle motorcycle = new Motorcycle(registrationNumber, color, cylinderVolume);
			garageMap.put(motorcycle.getRegistrationNumber(), motorcycle);
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color + " was not found \n Valid colors are: Black, White, Green, Red, Yellow");
		}
	}


	protected void createBus() {
		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the bus ...");
			color = JOptionPane.showInputDialog("Input Color of the Car...");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number of wheels..."));
			numberOfSeats = Integer.parseInt(JOptionPane.showInputDialog("Input Number of seats"));
			Bus bus = new Bus(registrationNumber, color, numberOfWheels, numberOfSeats);
			garageMap.put(bus.getRegistrationNumber(), bus);
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color + " was not found \n Valid colors are: Black, White, Green, Red, Yellow");
		}
	}









}


