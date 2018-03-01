
package ui;

import javax.swing.JOptionPane;

import models.Car;
import models.ColorNotFoundException;

public class Main {

	public static void main(String[] args) {

		//prompt the user for input
		String registrationNumber = null;
		String color = null;
		Integer numberOfWheels = null;

		numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number Of Wheels..."));
		color = JOptionPane.showInputDialog("Input Color of the Car...");
		registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");


		try
		{
			Car car = new Car(registrationNumber, color, numberOfWheels.intValue());
			System.out.println(car.toString());
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color);
		}

	}
}

