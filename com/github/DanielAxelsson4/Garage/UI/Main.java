
package com.github.DanielAxelsson4.Garage.UI;

import javax.swing.JOptionPane;
import com.github.DanielAxelsson4.Garage.MVVM.ConsoleGarageHandler;

/**
 * Main class for executing the Garage application.
=======
import com.github.DanielAxelsson4.Garage.Exceptions.GarageAlreadyExistsException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageIsFullException;
import com.github.DanielAxelsson4.Garage.Exceptions.GarageNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.MVVM.ConsoleGarageHandler;

/**
 * Class description: Main class for executing the Garage application.
 * @author Daniel Axelsson and Sohrab Azami
 *
 *
 */

public class Main {

	static ConsoleGarageHandler conGarHandler = new ConsoleGarageHandler();
	static int response = 0;
	static String[] options = null;
	boolean choice = true;


/**
 * Main method that instantiate menu and calls the main menu.
 * @param args
 */

	public static void main(String[] args)
	{
		Main menu = new Main();
		menu.callMainMenu();
	}

/**
 * Main menu method
 */
	public void callMainMenu() 
	{
		String[] options = new String[] {"Garage menu", "Vehicle menu", "Close"};
		while(choice = true) {

			response = JOptionPane.showOptionDialog(null, "What would menu would you like to enter", "Main menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);

			switch (response) {
			// Open garage menu
			case 0: callGarageMenu();
			break;
			// Open vehicle menu
			case 1: callVehicleMenu();
			break;
			// Exit application
			case 2: return;
			}
		}


	}


/**
 * Garage menu method
 */
	public void callGarageMenu() 
	{
		options = new String[] {"Add garage", "Remove garage", "List garage", "Go to main menu"};
		while(choice = true) {

			response = JOptionPane.showOptionDialog(null, "What would you like to do", "Garage menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);

			switch (response) {
			// Add garage
			case 0: conGarHandler.addGarage();
			break;
			// Remove garage	
			case 1: conGarHandler.removeGarage();
			break;
			// List garage
			case 2: conGarHandler.listGarage();
			break;
			// Back to main menu	
			case 3:	return;

			}	
		}
	}

/**
 * Vehicle menu method
 */
	public void callVehicleMenu() 
	{
		options = new String[] {"Park vehicle", "Unpark vehicle", "List all parked vehicles", "List parked vehicles in specific garage", "List vehicle with registernumber", "Go back"};

		while(choice = true) {


			response = JOptionPane.showOptionDialog(null, "What would you like to do?", "Vehicle menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);

			switch (response) {
			// Calls the park menu
			case 0: callParkMenu();
			break;
			// Unparks specific vehicle
			case 1: conGarHandler.removeSpecificVehicle();
			break;
			// Lists all vehicles
			case 2: conGarHandler.listAllVehicles();
			break;
			// Lists vehicles in specified garage
			case 3:	conGarHandler.listVehicles();
			break;
			// List specific vehicle
			case 4:	conGarHandler.listSpecificVehicle();
			break;
			// Back to main menu
			case 5:	return;
			}
		}
	}

/**
 * Park menu method
 */
	public void callParkMenu() 
	{

		String[]options = new String[] {"Car", "Motorcycle", "Airplane", "Boat", "Bus", "Go back"};

		while (choice = true) {

			int response = JOptionPane.showOptionDialog(null, "What vehicle would you like to park?", "Park menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);

			switch (response) {
			// Creates and parks a car in the collection
			case 0: conGarHandler.createCar();
			break;
			// Creates and parks a motorcycle in the collection
			case 1: conGarHandler.createMotorcycle();
			break;
			// Creates and parks an airplane in the collection
			case 2: conGarHandler.createAirplane();
			break;
			// Creates and parks a boat in the collection
			case 3:	conGarHandler.createBoat();
			break;
			// Creates and parks a bus in the collection
			case 4:	conGarHandler.createBus();
			break;
			// Back to main menu
			case 5:	return;
			}
		}

	




	












}
}


