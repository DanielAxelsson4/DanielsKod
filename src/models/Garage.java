
package models;

import java.util.TreeMap;

import javax.swing.JOptionPane;

public class Garage {
	
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
	


	public Garage() {
		garageMap = new TreeMap<String, Vehicle>();
	}

	public static TreeMap<String,Vehicle> getVehicleMap() {
		return garageMap;
	}

	public void addVehicle(Vehicle newVehicle ) {
		if (garageMap.containsKey(newVehicle.getRegistrationNumber())){
			garageMap.put(newVehicle.getRegistrationNumber(), newVehicle);
		}
		
	}



	public void listVehicles(TreeMap<String,Vehicle> garageMap) {

		for (Vehicle nextVehicle : garageMap.values() ) {
			System.out.println(nextVehicle.toString() );
		}
	}

	public void deleteVehicle(Vehicle newVehicle ) {
		if (garageMap.containsKey(newVehicle.getRegistrationNumber())){
			garageMap.remove(newVehicle.getRegistrationNumber());
		}
	}


	public void printVehicles(TreeMap<String,Vehicle> garageMap) {
		for (Vehicle nextVehicle : garageMap.values() ) {
			System.out.println(nextVehicle.toString());
		}
	}

	public int getNumberOfVehicles() {
		return garageMap.size();
	}

	public void createCar() {
		try {
			Garage vehicleCatalog = new Garage();
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");
			color = JOptionPane.showInputDialog("Input Color of the Car...");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number of wheels..."));
			power = Integer.parseInt(JOptionPane.showInputDialog("Input engine power of vehicle"));
			Car car = new Car(registrationNumber, color, numberOfWheels, power);
			vehicleCatalog.addVehicle(car);
			
			if (garageMap.containsKey(car.getRegistrationNumber())){
				
			}
			garageMap.put(car.getRegistrationNumber(), car);
			
			
			
			
			
			
			
			
			
			
		}
		catch (ColorNotFoundException e) {
			System.out.println("The color : " + color + " was not found");
		}
	}

	public void createBoat() {

		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");
			color = JOptionPane.showInputDialog("Input Color of the Car...");
			length = Integer.parseInt(JOptionPane.showInputDialog("Input length in metres"));
			lifeboats = Integer.parseInt(JOptionPane.showInputDialog("Input number of lifeboats"));
			Boat boat = new Boat(registrationNumber, color, length, lifeboats);
			addVehicle(boat);
		}
		catch(BoatNotFoundException e)
		{
			System.out.println("Boat was not found");
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color + " was not found");
		}
	}
	
	public void createAirplane() {
		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number of wheels..."));
			airlineName = JOptionPane.showInputDialog("Input air line name");
			AirPlane airplane = new AirPlane(registrationNumber, numberOfWheels, airlineName);
			this.addVehicle(airplane);
		}
		catch(AirlineNameNotFoundException e)
		{
			System.out.println("The airline name " + airlineName + " was not found" );
		}
	}
	
	public void createMotorcycle() {
		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");
			color = JOptionPane.showInputDialog("Input Color of the Car...");
			Motorcycle motorcycle = new Motorcycle(registrationNumber, color, cylinderVolume);
			addVehicle(motorcycle);
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color + " was not found");
		}
	}
	
	
	public void createBus() {
		try {
			registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");
			color = JOptionPane.showInputDialog("Input Color of the Car...");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number of wheels..."));
			numberOfSeats = Integer.parseInt(JOptionPane.showInputDialog("Input Number of seats"));
			Bus bus = new Bus(registrationNumber, color, numberOfWheels, numberOfSeats);
			addVehicle(bus);
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color + " was not found");
		}
	}

	
	
	
	
	



}


