
package com.github.DanielAxelsson4.Garage.UI;

import javax.swing.JOptionPane;

import com.github.DanielAxelsson4.Garage.Exceptions.GarageAlreadyExistsException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageIsFullException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.MVVM.ConsoleGarageHandler;

/**
 *
 * @author Daniel Axelsson and Sohrab Azami
 * Class description: Main class for executing the Garage application.
 *
 */


public class Main {

	static ConsoleGarageHandler conGarHandler = new ConsoleGarageHandler();
	static int response = 0;
	static String[] options = null;

	public static void main(String[] args) throws GarageAlreadyExistsException, GarageNotFoundException, GarageIsFullException, VehicleNotFoundException
	{
		callMainMenu();
	}


	private static void callMainMenu() throws GarageAlreadyExistsException, GarageNotFoundException, GarageIsFullException, VehicleNotFoundException
	{
		String[] options = new String[] {"Garage menu", "Vehicle menu", "Close"};
		response = JOptionPane.showOptionDialog(null, "What would menu would you like to enter", "Main menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);

		if (response == 0) {
			callGarageMenu();
		}
		if (response == 1) {
			callVehicleMenu();
		}
		if (response == 2) {
			System.exit(0);
		}
	}



	public static void callGarageMenu() throws GarageAlreadyExistsException, GarageNotFoundException, GarageIsFullException, VehicleNotFoundException
	{
		options = new String[] {"Add garage", "Remove garage", "List garage", "Go to main menu"};
		response = JOptionPane.showOptionDialog(null, "What would you like to do", "Garage menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);

		if (response == 0)
		{
			//add garage
			try
			{
				conGarHandler.addGarage();
				callGarageMenu();
			}
			catch(GarageNotFoundException e) {
				System.out.println("Garage was not found");
				callGarageMenu();
			}
		}
		if (response == 1)
		{
			//remove garage
			try
			{
				conGarHandler.removeGarage();
				callGarageMenu();
			}
			catch(GarageNotFoundException e) {
				System.out.println("Garage was not found");
				callGarageMenu();
			}
		}
		if (response == 2) {
			//list garage
			conGarHandler.listGarage();
			callGarageMenu();
		}
		if (response == 3) {
			// Go to main menu
			callMainMenu();
		}
	}


	public static void callVehicleMenu() throws GarageAlreadyExistsException, GarageNotFoundException, GarageIsFullException, VehicleNotFoundException
	{
		options = new String[] {"Park vehicle", "Unpark vehicle", "List all parked vehicles", "List parked vehicles in specific garage", "List vehicle with registernumber", "Go back"};
		response = JOptionPane.showOptionDialog(null, "What would you like to do?", "Vehicle menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);

		if (response == 0)
		{
			// Calls the park menu
			callParkMenu();
		}
		if (response == 1)
		{
			// Unparks specific vehicle
			conGarHandler.removeSpecificVehicle();
			callVehicleMenu();
		}
		if (response == 2)
		{
			// Lists all vehicles
			conGarHandler.listAllVehicles();
			callVehicleMenu();
		}
		if (response == 3)
		{
			// Lists vehicles in specified garage
			conGarHandler.listVehicles();
			callVehicleMenu();
		}
		if (response == 4)
		{
			// List specific vehicle
			conGarHandler.listSpecificVehicle();
			callVehicleMenu();
		}
		if (response == 5)
		{
			callMainMenu();
		}
	}


	public static void callParkMenu() throws GarageAlreadyExistsException, GarageNotFoundException, GarageIsFullException, VehicleNotFoundException
	{
		String[]options = new String[] {"Car", "Motorcycle", "Airplane", "Boat", "Bus", "Go back"};
		int response = JOptionPane.showOptionDialog(null, "What vehicle would you like to park?", "Park menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);

		if (response == 0)
		{
			// creates and parks a car in the collection
			conGarHandler.createCar();
			callVehicleMenu();

		}
		if (response == 1)
		{
			// creates and parks a motorcycle in the collection
			conGarHandler.createMotorcycle();
			callVehicleMenu();
		}
		if (response == 2)
		{
			// creates and parks an airplane in the collection
			conGarHandler.createAirplane();
			callVehicleMenu();
		}
		if (response == 3)
		{
			// creates and parks a boat in the collection
			conGarHandler.createBoat();
			callVehicleMenu();
		}
		if (response == 4)
		{
			// creates and parks a bus in the collection
			conGarHandler.createBus();
			callVehicleMenu();
		}
		if (response == 5)
		{
			// Go to main menu
			callVehicleMenu();
		}



	}












}


