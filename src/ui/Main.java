
package ui;

import javax.swing.JOptionPane;

import mvvm.GarageHandler;

public class Main {

	public static void main(String[] args) {

		//prompt the user for input

		callMainMenu();
		}


	private static void callMainMenu() {


		String[] options = new String[] {"Garage menu", "Vehicle menu", "Close"};
		int response = JOptionPane.showOptionDialog(null, "What would menu would you like to enter", "Main menu",
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


	private static void callVehicleMenu() {
		String[]options = new String[] {"Park vehicle", "Unpark vehicle", "List all parked vehicles", "List specific type of vehicles", "Go back"};
		int response = JOptionPane.showOptionDialog(null, "What would you like to do?", "Vehicles",
		JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		null, options, options[0]);
	if (response == 0) {
		callParkMenu();
	}
	if (response == 1) {
		int regInput = Integer.parseInt(JOptionPane.showInputDialog("Input the registrationnumber of the vehicle you would like to unpark"));
		//		GarageHandler.removeVehicle(regInput)
	}
	if (response == 2) {
		Garageh
		//		GarageHandler.listVehicle
	}
	if (response == 3) {
		// List specic vehicles
		// GarageHandler.listSpecificVehicles
	}
	if (response == 4) {
		callMainMenu();
	}


	}


	private static void callParkMenu() {
		String[]options = new String[] {"Car", "Motorcycle", "Airplane", "Boat", "Bus", "Go back"};
		int response = JOptionPane.showOptionDialog(null, "What vehicle would you like to park?", "Park Vehicles",
		JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		null, options, options[0]);

		if (response == 0) {
		// // GaraHanler.createCar()
		}
		if (response == 1) {
			// GaraHanler.createMotorcycle()
		}
		if (response == 2) {
			// GaraHanler.createAirplane()
		}
		if (response == 3) {
			// GaraHanler.createBoat()

		}
		if (response == 4) {
			// GaraHanler.createBus()
		}
		if (response == 5) {
			// Go to main menu
			callVehicleMenu();
		}



	}


	private static void callGarageMenu() {
		String[]options = new String[] {"Add garage", "Remove garage", "List garage", "Go to main menu"};
		int response = JOptionPane.showOptionDialog(null, "What would you like to do", "Garage menu",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		if (response == 0) {
			//add garage
			//		System.out.println("Garage: " + garageHandler.getGarageName + " was added");
		}
		if (response == 1) {
			//remove garage
			//		System.out.println("Garage: " + garageHandler.getGarageName + " was removed");
		}
		if (response == 2) {
			//list garage
		}
		if (response == 3) {
			// Go to main menu
			callMainMenu();
		}




	}













	}


