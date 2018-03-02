
package ui;

import javax.swing.JOptionPane;

<<<<<<< HEAD

import models.Garage;
import models.Vehicle;
=======
import mvvm.GarageHandler;
>>>>>>> 4ac3e0b4205f8299447a167cd594f3013e2da050

public class Main {

	public static void main(String[] args) {

		//prompt the user for input

<<<<<<< HEAD
		int optionInput = 0;

		optionInput = Integer.parseInt(JOptionPane.showInputDialog("1. Create car     2. Create Motorcycle     3. Create Airplane     4. Create Boat     5. Create Bus"));
		System.out.println("test");
		Garage garageCatalog = new Garage();
		PrintingUI ui = new PrintingUI();
=======
		callMainMenu();
		}


	private static void callMainMenu() {
>>>>>>> 4ac3e0b4205f8299447a167cd594f3013e2da050

		switch (optionInput) {
		case 1:		optionInput = 1;
		garageCatalog.createCar();
		break;

<<<<<<< HEAD
		case 2:  	optionInput = 2;
		garageCatalog.createMotorcycle();
		break;

		case 3:  	optionInput = 3;
		garageCatalog.createAirplane();
		break;
=======
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
>>>>>>> 4ac3e0b4205f8299447a167cd594f3013e2da050

		case 4:  	optionInput = 4;
		garageCatalog.createBoat();
		break;

<<<<<<< HEAD
		case 5:		optionInput = 5;
		garageCatalog.createBus();
		break;

		}
		
		
		ui.printVehicleCatalog(Garage.getVehicleMap());
		
=======

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
>>>>>>> 4ac3e0b4205f8299447a167cd594f3013e2da050


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

<<<<<<< HEAD

=======
		}
		if (response == 4) {
			// GaraHanler.createBus()
		}
		if (response == 5) {
			// Go to main menu
			callVehicleMenu();
		}

>>>>>>> 4ac3e0b4205f8299447a167cd594f3013e2da050


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


