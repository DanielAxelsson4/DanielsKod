
package ui;

import javax.swing.JOptionPane;

import models.AirPlane;
import models.AirlineNameNotFoundException;
import models.Car;
import models.ColorNotFoundException;

public class Main {

	public static void main(String[] args) {

		//prompt the user for input
		String registrationNumber = null;
		String color = null;
		Integer numberOfWheels = null;
		Integer airplaneNumOfWheels = null;
		Integer power = null;

		numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number Of Wheels..."));
		color = JOptionPane.showInputDialog("Input Color of the Car...");
		registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");
		power = Integer.parseInt(JOptionPane.showInputDialog("Input engine power of vehicle"));
		airplaneNumOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input number of wheels for airplane"));
		String airlineName = JOptionPane.showInputDialog("Input air line name");
		String airplaneRegNum = JOptionPane.showInputDialog("Input airplane registeration number");


		try
		{
			Car car = new Car(registrationNumber, color, numberOfWheels.intValue(), power.intValue());
			System.out.println(car.toString());
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color + " was not found");
		}
		try
		{
			AirPlane ap = new AirPlane(airplaneRegNum, airplaneNumOfWheels.intValue(), airlineName);
			System.out.println(ap.toString());
		}
		catch(AirlineNameNotFoundException e)
		{
			System.out.println("The airline name " + airlineName + " was not found" );
		}


	}
}

