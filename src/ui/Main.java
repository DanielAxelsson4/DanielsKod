
package ui;

import javax.swing.JOptionPane;


import models.Garage;
import models.Vehicle;

public class Main {

	public static void main(String[] args) {

		//prompt the user for input

		int optionInput = 0;

		optionInput = Integer.parseInt(JOptionPane.showInputDialog("1. Create car     2. Create Motorcycle     3. Create Airplane     4. Create Boat     5. Create Bus"));
		System.out.println("test");
		Garage garageCatalog = new Garage();
		PrintingUI ui = new PrintingUI();

		switch (optionInput) {
		case 1:		optionInput = 1;
		garageCatalog.createCar();
		break;

		case 2:  	optionInput = 2;
		garageCatalog.createMotorcycle();
		break;

		case 3:  	optionInput = 3;
		garageCatalog.createAirplane();
		break;

		case 4:  	optionInput = 4;
		garageCatalog.createBoat();
		break;

		case 5:		optionInput = 5;
		garageCatalog.createBus();
		break;

		}
		
		
		ui.printVehicleCatalog(Garage.getVehicleMap());
		







	}
}

