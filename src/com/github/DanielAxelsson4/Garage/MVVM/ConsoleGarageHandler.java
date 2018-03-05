package com.github.DanielAxelsson4.Garage.MVVM;


import javax.swing.JOptionPane;

import com.github.DanielAxelsson4.Garage.Exceptions.GarageAlreadyExistsException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageIsFullException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.Models.AirPlane;
import com.github.DanielAxelsson4.Garage.Models.Boat;
import com.github.DanielAxelsson4.Garage.Models.Bus;
import com.github.DanielAxelsson4.Garage.Models.Car;
import com.github.DanielAxelsson4.Garage.Models.Garage;
import com.github.DanielAxelsson4.Garage.Models.Motorcycle;
import com.github.DanielAxelsson4.Garage.UI.Main;
import com.github.DanielAxelsson4.Garage.Utilities.GarageType;

/**
 * 
 * @author Daniel Axelsson and tempName
 * Class description: Main class for executing the Garage application.
 *
 */


public class ConsoleGarageHandler extends GarageHandler {

	protected String registrationNumber = null;
	protected String color = null;
	protected Integer numberOfWheels = null;
	protected int cylinderVolume = 0;
	protected int numberOfSeats = 0;
	protected int lifeboats = 0;
	protected int length = 0;
	protected int capacity = 0;
	protected Integer power = null;
	protected String airlineName = null;
	protected String garageName = null;
	protected String garageType = null;
	protected Car car = null;
	protected Motorcycle motorcycle = null;
	protected Bus bus = null;
	protected AirPlane airplane = null;
	protected Boat boat = null;
	protected Garage garage = null;
	GarageType gt = null;

	public ConsoleGarageHandler() {
	}

	/**
	 * Prompts the user for inputs and adds a garage
	 * @throws GarageAlreadyExistsException Garage already exists
	 */

	public void addGarage() throws GarageAlreadyExistsException 
	{
		garageName = JOptionPane.showInputDialog("What's the name of your garage?");
		capacity = Integer.parseInt(JOptionPane.showInputDialog("What is the maximum amount of vehicles that can be parked here?")) - 1;
		Garage garage = super.createGarage(garageName, capacity);
		try 
		{
			super.addGarage(garageName, garage);
		}
		catch(GarageAlreadyExistsException e) 
		{
			System.out.println("Garage already exists");
		}
	}
	/**
	 * Prompts the user for inputs and removes a garage
	 * @throws GarageNotFoundException Garage was not found
	 * @throws VehicleNotFoundException Vehicle was not found
	 * @throws GarageIsFullException Garage is full
	 * @throws GarageAlreadyExistsException Garage already exists
	 */
	public void removeGarage() throws GarageNotFoundException, GarageAlreadyExistsException, GarageIsFullException, VehicleNotFoundException 
	{
		try 
		{
			garageName = JOptionPane.showInputDialog("What's the name of the garage you want to remove?");
			super.removeGarage(garageName);
		}
		catch(GarageNotFoundException e) 
		{
			System.out.println("\n" +  "The garage was not found \n");
			Main.callGarageMenu();
		}
	}
	/**
	 * Lists all garages
	 */
	public void listGarage() 
	{
		System.out.println("\n" +  "Now viewing all garages: \n ");
		super.listGarages();	
	}
	/**
	 * Prompts the user for inputs and lists all vehicles in specified garage
	 * @throws GarageNotFoundException Garage was not found
	 * @throws VehicleNotFoundException Vehicle was not found
	 * @throws GarageIsFullException Garage is full
	 * @throws GarageAlreadyExistsException Garage already exists
	 */
	public void listVehicles() throws GarageNotFoundException, GarageAlreadyExistsException, GarageIsFullException, VehicleNotFoundException 
	{
		try {
			garageName = JOptionPane.showInputDialog("\n" + "What is the name of the garage you would you like to view?");
			garage = findGarage(garageName);
			System.out.println("\n" + "Now viewing garage: "  + garageName + "\n");
			super.viewGarage(garage);
		}
		catch (GarageNotFoundException e) {
			System.out.println("\n" +  "The garage was not found \n");
			Main.callVehicleMenu();
		}

	}
	/**
	 * Lists all parked vehicles in all garages
	 */
	public void listAllVehicles() 
	{
		System.out.println("\n" + "Now viewing all parked vehicles: \n");
		super.listAllVehicles();
	}
	/**
	 * Prompts the user for inputs and lists the vehicle with specified register number
	 * @throws GarageNotFoundException Garage was not found
	 * @throws VehicleNotFoundException Vehicle was not found
	 * @throws GarageAlreadyExistsException Garage already exists
	 * @throws GarageIsFullException Garage is full
	 */
	public void listSpecificVehicle() throws GarageNotFoundException, VehicleNotFoundException, GarageAlreadyExistsException, GarageIsFullException 
	{
		try 
		{
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the vehicle you would like to find?");
			super.listSpecificVehicle(registrationNumber);
		}
		catch(VehicleNotFoundException e) 
		{
			System.out.println("\n" + "Vehicle not found! \n");
			Main.callVehicleMenu();
		}
	}
	/**
	 * Prompts the user for inputs and removes the vehicle with the specified register number
	 * @throws GarageAlreadyExistsException Garage already exists
	 * @throws GarageNotFoundException Garage was not found
	 * @throws GarageIsFullException Garage is full
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
	public void removeSpecificVehicle() throws GarageAlreadyExistsException, GarageNotFoundException, GarageIsFullException, VehicleNotFoundException 
	{
		try 
		{
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the vehicle you would like to unpark?");
			super.removeSpecificVehicle(registrationNumber);
		}
		catch(VehicleNotFoundException e) 
		{
			System.out.println("\n" + "Vehicle is not parked \n");
			Main.callParkMenu();
		}
	}

	/**
	 * Prompts the user for inputs and creates a car
	 * @throws GarageNotFoundException Garage was not found
	 * @throws GarageIsFullException Garage is full
	 * @throws GarageAlreadyExistsException Garage already exists
	 * @throws VehicleNotFoundException Vehicle was not found
	 */

	public void createCar() throws GarageNotFoundException, GarageIsFullException, GarageAlreadyExistsException, VehicleNotFoundException 
	{
		try {
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the car?");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("How many wheels does the car have?"));
			color = JOptionPane.showInputDialog("What color does the car have?");
			power = Integer.parseInt(JOptionPane.showInputDialog("How many horsepowers does the car have?"));
			garageName = JOptionPane.showInputDialog("In what garage would you like to park the car?");
			if(registrationNumber == null || color == null || power == null || garageName == null) {
				throw new NullPointerException();
			}
			car = super.createCar(registrationNumber, numberOfWheels, color, power, garageName);
			super.addVehicle(car, garageName);
		}
		catch(NumberFormatException e) 
		{
			System.out.println("Please input a correct value");
			Main.callParkMenu();
		}
		catch (GarageIsFullException e) 
		{
			System.out.println("\n" +  "The garage is full \n ");
			Main.callParkMenu();
		}
		catch (NullPointerException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageNotFoundException e) 
		{
			System.out.println("\n" + "Garage was not found \n");
			Main.callParkMenu();
		}
	}
	/**
	 * Prompts the user for inputs and creates a motorcycle
	 * @throws GarageNotFoundException Garage was not found
	 * @throws GarageIsFullException Garage is full
	 * @throws GarageAlreadyExistsException Garage already exists
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
	public void createMotorcycle() throws GarageNotFoundException, GarageIsFullException, GarageAlreadyExistsException, VehicleNotFoundException {
		try {
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the motorcycle?");
			color = JOptionPane.showInputDialog("What color does the motorcycle have?");
			cylinderVolume = Integer.parseInt(JOptionPane.showInputDialog("What is the volume of the cylinder in liters?"));
			garageName = JOptionPane.showInputDialog("In what garage would you like to park the motorcycle?");
			if(registrationNumber == null || color == null || garageName == null) {
				throw new NullPointerException();
			}
			motorcycle = super.createMotorcycle(registrationNumber, color, cylinderVolume, garageName);
			super.addVehicle(motorcycle, garageName);
		}
		catch(NumberFormatException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageIsFullException e) 
		{
			System.out.println("\n" +  "The garage is full \n ");
			Main.callParkMenu();
		}
		catch (NullPointerException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageNotFoundException e) 
		{
			System.out.println("\n" + "Garage was not found \n");
			Main.callParkMenu();
		}
	}
	/**
	 * Prompts the user for inputs and creates a bus
	 * @throws GarageNotFoundException Garage was not found
	 * @throws GarageIsFullException Garage is full
	 * @throws GarageAlreadyExistsException Garage already exists
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
	public void createBus() throws GarageNotFoundException, GarageIsFullException, GarageAlreadyExistsException, VehicleNotFoundException 
	{
		try {
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the bus?");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("How many wheels does the bus have?"));
			color = JOptionPane.showInputDialog("What color does the bus have?");
			numberOfSeats = Integer.parseInt(JOptionPane.showInputDialog("How many seats does the bus have?"));
			garageName = JOptionPane.showInputDialog("In what garage would you like to park the bus?");
			if(registrationNumber == null || color == null || garageName == null) 
			{
				throw new NullPointerException();
			}
			bus = super.createBus(registrationNumber, color, numberOfWheels, numberOfSeats, garageName);
			super.addVehicle(bus, garageName);
		}
		catch(NumberFormatException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageIsFullException e) 
		{
			System.out.println("\n" +  "The garage is full \n ");
			Main.callParkMenu();
		}
		catch (NullPointerException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageNotFoundException e) 
		{
			System.out.println("\n" + "Garage was not found \n");
			Main.callParkMenu();
		}
	}
	/**
	 * Prompts the user for inputs and creates an airplane
	 * @throws GarageNotFoundException Garage was not found
	 * @throws GarageIsFullException Garage is full
	 * @throws GarageAlreadyExistsException Garage already exists
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
	public void createAirplane() throws GarageNotFoundException, GarageIsFullException, GarageAlreadyExistsException, VehicleNotFoundException 
	{
		try {
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the airplane?");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("How many wheels does the airplane have?"));
			airlineName = JOptionPane.showInputDialog("What is the airline name of the airplane?");
			garageName = JOptionPane.showInputDialog("In what garage would you like to park the airplane?");
			if(registrationNumber == null || airlineName == null || garageName == null) 
			{
				throw new NullPointerException();
			}
			airplane = super.createAirplane(registrationNumber, numberOfWheels, airlineName, garageName);
			super.addVehicle(airplane, garageName);
		}
		catch(NumberFormatException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageIsFullException e) 
		{
			System.out.println("\n" +  "The garage is full \n ");
			Main.callParkMenu();
		}
		catch (NullPointerException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageNotFoundException e) 
		{
			System.out.println("\n" + "Garage was not found \n");
			Main.callParkMenu();
		}
	}
	/**
	 * Prompts the user for inputs and creates a boat
	 * @throws GarageNotFoundException Garage was not found
	 * @throws GarageIsFullException Garage is full
	 * @throws GarageAlreadyExistsException Garage already exists
	 * @throws VehicleNotFoundException Vehicle was not found
	 */
	public void createBoat() throws GarageNotFoundException, GarageIsFullException, GarageAlreadyExistsException, VehicleNotFoundException 
	{
		try {
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the boat?");
			color = JOptionPane.showInputDialog("What color does the boat have?");
			length = Integer.parseInt(JOptionPane.showInputDialog("What is the length of the boat in metres?"));
			lifeboats = Integer.parseInt(JOptionPane.showInputDialog("How many lifeboats does the boat have?"));
			garageName = JOptionPane.showInputDialog("In what garage would you like to park the boat?");
			if(registrationNumber == null || color == null || garageName == null) 
			{
				throw new NullPointerException();
			}
			boat = super.createBoat(registrationNumber, color, length, lifeboats, garageName);
			super.addVehicle(boat, garageName);
		}
		catch(NumberFormatException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageIsFullException e) 
		{
			System.out.println("\n" +  "The garage is full \n ");
			Main.callParkMenu();
		}
		catch (NullPointerException e) 
		{
			System.out.println("\n" + "Please input a correct value \n");
			Main.callParkMenu();
		}
		catch (GarageNotFoundException e) 
		{
			System.out.println("\n" + "Garage was not found \n");
			Main.callParkMenu();
		}
	}
























}
