package com.github.DanielAxelsson4.Garage.MVVM;


import javax.swing.JOptionPane;

import com.github.DanielAxelsson4.Garage.Exceptions.AirlineNameNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.ColorNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageAlreadyExistsException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageIsFullException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.NumberBelowOneException;
import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.Models.AirPlane;
import com.github.DanielAxelsson4.Garage.Models.Boat;
import com.github.DanielAxelsson4.Garage.Models.Bus;
import com.github.DanielAxelsson4.Garage.Models.Car;
import com.github.DanielAxelsson4.Garage.Models.Garage;
import com.github.DanielAxelsson4.Garage.Models.Motorcycle;
import com.github.DanielAxelsson4.Garage.UI.Main;

/**
 * Class description: Console GarageHandler class
 * @author Daniel Axelsson and Sohrab Azami
 *
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
	protected Main menu = new Main();

	public ConsoleGarageHandler() {
	}

	/**
	 * Prompts the user for inputs and adds a garage
	 */

	public void addGarage()
	{
		try
		{
			garageName = JOptionPane.showInputDialog("What's the name of your garage?");
			capacity = Integer.parseInt(JOptionPane.showInputDialog("What is the maximum amount of vehicles that can be parked here?")) - 1;
			if (garageName == null || capacity < 0) {
				throw new NumberFormatException();
			}
			Garage garage = super.createGarage(garageName, capacity);
			super.addGarage(garageName, garage);

		}
		catch(GarageAlreadyExistsException e)
		{
			System.out.println("Garage already exists");
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please input a correct value");
			return;
		}
	}
	/**
	 * Prompts the user for inputs and removes a garage
	 */
	public void removeGarage()
	{
		try
		{
			garageName = JOptionPane.showInputDialog("What's the name of the garage you want to remove?");
			if (garageName == null || capacity < 0) {
				throw new NumberFormatException();
			}
			super.removeGarage(garageName);
		}
		catch(GarageNotFoundException e)
		{
			System.out.println("\n" +  "The garage was not found \n");
			return;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please input a correct value");
			return;
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
	 */
	public void listVehicles()
	{
		try {
			garageName = JOptionPane.showInputDialog("\n" + "What is the name of the garage you would you like to view?");
			garage = super.findGarage(garageName);
			System.out.println("\n" + "Now viewing garage: "  + garageName + "\n");
			super.viewGarage(garage);
		}
		catch (GarageNotFoundException e) {
			System.out.println("\n" +  "The garage was not found \n");
			return;
		}

	}
	/**
	 * Lists all parked vehicles in all garages
	 */
	@Override
	public void listAllVehicles()
	{
		System.out.println("\n" + "Now viewing all parked vehicles: \n");
		super.listAllVehicles();
	}
	/**
	 * Prompts the user for inputs and lists the vehicle with specified register number
	 */
	public void listSpecificVehicle()
	{
		try
		{
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the vehicle you would like to find?");
			super.listSpecificVehicle(registrationNumber);
		}
		catch(VehicleNotFoundException e)
		{
			System.out.println("\n" + "Vehicle not found! \n");
			return;
		}
	}
	/**
	 * Prompts the user for inputs and removes the vehicle with the specified register number
	 */
	public void removeSpecificVehicle()
	{
		try
		{
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the vehicle you would like to unpark?");
			super.removeSpecificVehicle(registrationNumber);
		}
		catch(VehicleNotFoundException e)
		{
			System.out.println("\n" + "Vehicle is not parked \n");
			return;
		}
	}

	/**
	 * Prompts the user for inputs and creates a car
	 */

	public void createCar()
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
			if(numberOfWheels <= 0 || power <= 0 ) {
				throw new NumberBelowOneException();
			}
			//car = super.createCar(registrationNumber, numberOfWheels, color, power, garageName);
			car = new Car(registrationNumber, color, numberOfWheels, power, garageName);
			super.addVehicle(car, garageName);
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please input a correct value");
			return;
		}
		catch (GarageIsFullException e)
		{
			System.out.println("\n" +  "The garage is full \n ");
			return;
		}
		catch (NullPointerException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageNotFoundException e)
		{
			System.out.println("\n" + "Garage was not found \n");
			return;
		}
		catch (NumberBelowOneException e)
		{
			System.out.println("\n" + "Number must be above 0 \n");
			return;
		}
		catch (ColorNotFoundException e) {
			System.out.println("The color was not found \n Valid colors are: Black, White, Red, Orange, Yellow, Green, Cyan, Blue, Purple, Magenta, Grey");
			return;
		}
		catch(VehicleNotFoundException e)
		{
			System.out.println("Car was not found");
			return;
		}
	}
	/**
	 * Prompts the user for inputs and creates a motorcycle
	 */
	public void createMotorcycle() {
		try {
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the motorcycle?");
			color = JOptionPane.showInputDialog("What color does the motorcycle have?");
			cylinderVolume = Integer.parseInt(JOptionPane.showInputDialog("What is the volume of the cylinder in liters?"));
			garageName = JOptionPane.showInputDialog("In what garage would you like to park the motorcycle?");
			if(registrationNumber == null || color == null || garageName == null) {
				throw new NullPointerException();
			}
			if(cylinderVolume <= 0) {
				throw new NumberBelowOneException();
			}
			//motorcycle = super.createMotorcycle(registrationNumber, color, cylinderVolume, garageName);
			motorcycle = new Motorcycle(registrationNumber, color, cylinderVolume, garageName);
			super.addVehicle(motorcycle, garageName);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageIsFullException e)
		{
			System.out.println("\n" +  "The garage is full \n ");
			return;
		}
		catch (NullPointerException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageNotFoundException e)
		{
			System.out.println("\n" + "Garage was not found \n");
			return;
		}
		catch (NumberBelowOneException e)
		{
			System.out.println("\n" + "Number must be above 0 \n");
			return;
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Red, Orange, Yellow, Green, Cyan, Blue, Purple, Magenta, Grey");
			return;
		}
		catch(VehicleNotFoundException e)
		{
			System.out.println("MotorCycle not found");
			return;
		}
	}
	/**
	 * Prompts the user for inputs and creates a bus
	 */
	public void createBus()
	{
		try {
			Bus bus = null;
			registrationNumber = JOptionPane.showInputDialog("What's the registrationnumber of the bus?");
			numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("How many wheels does the bus have?"));
			color = JOptionPane.showInputDialog("What color does the bus have?");
			numberOfSeats = Integer.parseInt(JOptionPane.showInputDialog("How many seats does the bus have?"));
			garageName = JOptionPane.showInputDialog("In what garage would you like to park the bus?");
			if(registrationNumber == null || color == null || garageName == null)
			{
				throw new NullPointerException();
			}
			if(numberOfWheels <= 0 || numberOfSeats <= 0)
			{
				throw new NumberBelowOneException();
			}
			bus = new Bus(registrationNumber, color, numberOfWheels, numberOfSeats, garageName);
			super.addVehicle(bus, garageName);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageIsFullException e)
		{
			System.out.println("\n" +  "The garage is full \n ");
			return;
		}
		catch (NullPointerException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageNotFoundException e)
		{
			System.out.println("\n" + "Garage was not found \n");
			return;
		}
		catch (NumberBelowOneException e)
		{
			System.out.println("\n" + "Number must be above 0 \n");
			return;
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Red, Orange, Yellow, Green, Cyan, Blue, Purple, Magenta, Grey");
			return;
		}
		catch(VehicleNotFoundException e)
		{
			System.out.println("Bus not found");
			return;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	/**
	 * Prompts the user for inputs and creates an airplane
	 */
	public void createAirplane()
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
			if(numberOfWheels <= 0)
			{
				throw new NumberBelowOneException();
			}
			//airplane = super.createAirplane(registrationNumber, numberOfWheels, airlineName, garageName);
			airplane = new AirPlane(registrationNumber, numberOfWheels, airlineName, garageName);
			super.addVehicle(airplane, garageName);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageIsFullException e)
		{
			System.out.println("\n" +  "The garage is full \n ");
			return;
		}
		catch (NullPointerException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageNotFoundException e)
		{
			System.out.println("\n" + "Garage was not found \n");
			return;
		}
		catch (NumberBelowOneException e)
		{
			System.out.println("\n" + "Number must be above 0 \n");
			return;
		}
		catch(AirlineNameNotFoundException e)
		{
			System.out.println("The airline name " + airlineName + " was not found \n Valid airlinenames are: SAS, Alitalia, Berlin");
			return;
		}
		catch(VehicleNotFoundException e)
		{
			System.out.println("Airplane not found");
			return;
		}
	}
	/**
	 * Prompts the user for inputs and creates a boat
	 */
	public void createBoat()
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
			if(length <= 0 || lifeboats <= 0)
			{
				throw new NumberBelowOneException();
			}
			//boat = super.createBoat(registrationNumber, color, length, lifeboats, garageName);
			boat = new Boat(registrationNumber, color, length, lifeboats, garageName);
			super.addVehicle(boat, garageName);
		}
		catch(NumberFormatException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageIsFullException e)
		{
			System.out.println("\n" +  "The garage is full \n ");
			return;
		}
		catch (NullPointerException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (GarageNotFoundException e)
		{
			System.out.println("\n" + "Garage was not found \n");
			return;
		}
		catch (NumberBelowOneException e)
		{
			System.out.println("\n" + "Number must be above 0 \n");
			return;
		}
		catch(VehicleNotFoundException e)
		{
			System.out.println("Boat was not found");
			return;
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color was not found \n Valid colors are: Black, White, Red, Orange, Yellow, Green, Cyan, Blue, Purple, Magenta, Grey");
			return;
		}
	}
























}
