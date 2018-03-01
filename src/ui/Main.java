
package ui;

import javax.swing.JOptionPane;

import models.AirPlane;
import models.AirlineNameNotFoundException;
import models.Boat;
import models.BoatNotFoundException;
import models.Car;
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
		Integer airplaneNumOfWheels = null;
		Integer power = null;





		numberOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input Number of wheels..."));
		color = JOptionPane.showInputDialog("Input Color of the Car...");
		registrationNumber = JOptionPane.showInputDialog("Input registration number of the car ...");

		cylinderVolume = Integer.parseInt(JOptionPane.showInputDialog("Input volume of cylinder in litres"));
		numberOfSeats = Integer.parseInt(JOptionPane.showInputDialog("Input Number of seats"));
		lifeboats = Integer.parseInt(JOptionPane.showInputDialog("Input number of lifeboats"));
		length = Integer.parseInt(JOptionPane.showInputDialog("Input length in metres"));

		power = Integer.parseInt(JOptionPane.showInputDialog("Input engine power of vehicle"));
		airplaneNumOfWheels = Integer.parseInt(JOptionPane.showInputDialog("Input number of wheels for airplane"));
		String airlineName = JOptionPane.showInputDialog("Input air line name");
		String airplaneRegNum = JOptionPane.showInputDialog("Input airplane registeration number");



		try
		{
			Car car = new Car(registrationNumber, color, numberOfWheels.intValue(), power.intValue());
			System.out.println(car.toString());
			AirPlane ap = new AirPlane(airplaneRegNum, airplaneNumOfWheels.intValue(), airlineName);
			System.out.println(ap.toString());
			Boat boat = new Boat(registrationNumber, color, length, lifeboats);
			System.out.println(boat.toString());
		}
		catch(ColorNotFoundException e)
		{
			System.out.println("The color : " + color + " was not found");
		}
		catch(AirlineNameNotFoundException e)
		{
			System.out.println("The airline name " + airlineName + " was not found" );
		}
		catch(BoatNotFoundException e)
		{
			System.out.println("Boat was not found");
		}
		//garageCatalog.addVehicle(boat);


	}
}
