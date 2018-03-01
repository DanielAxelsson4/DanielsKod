
package ui;

import javax.swing.JOptionPane;

import models.Boat;
import models.ColorNotFoundException;
import models.Garage;

public class Main {

	public static void main(String[] args) {

		//prompt the user for input
		String registrationNumber = null;
		String color = null;
		Integer numberOfWheels = null;
		int cylinderVolume = 0;
		int numberOfSeats = 0;
		int lifeboats = 0;
		int length = 0;
		Garage garageCatalog = new Garage();





		numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number of wheels..."));
		color = JOptionPane.showInputDialog("Input Color of the Car...");
		registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");
		cylinderVolume = Integer.parseInt(JOptionPane.showInputDialog("Input volume of cylinder in litres"));
		numberOfSeats = Integer.parseInt(JOptionPane.showInputDialog("Input Number of seats"));
		lifeboats = Integer.parseInt(JOptionPane.showInputDialog("Input number of lifeboats"));
		length = Integer.parseInt(JOptionPane.showInputDialog("Input length in metres"));


		try
		{
			Boat boat = new Boat(registrationNumber, color, length, lifeboats);
			garageCatalog.addVehicle(boat);

			System.out.println(boat.toString());
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color);
		}

	}
}

