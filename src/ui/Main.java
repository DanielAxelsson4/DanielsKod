
package ui;

import javax.swing.JOptionPane;

import models.Garage;

public class Main {

	public static void main(String[] args) {

		//prompt the user for input

		int optionInput = 0;

		optionInput = Integer.parseInt(JOptionPane.showInputDialog("1. Create car     2. Create Motorcycle     3. Create Airplane     4. Create Boat     5. Create Bus"));
		Garage garage = new Garage();

		switch (optionInput) {
		case 1:		optionInput = 1;
		garage.createCar();
		break;

		case 2:  	optionInput = 2;
		garage.createMotorcycle();
		break;

		case 3:  	optionInput = 3;
		garage.createAirplane();
		break;

		case 4:  	optionInput = 4;
		garage.createBoat();
		break;

		case 5:		optionInput = 5;
		garage.createBus();
		break;

		}

		garage.listVehicles(Garage.garageMap);








	}
}

