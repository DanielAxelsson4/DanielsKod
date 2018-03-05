package com.github.DanielAxelsson4.Garage.Models;

/**
 * 
 * @author Daniel Axelsson and tempName
 * Class description: Main class for executing the Garage application.
 *
 */

import com.github.DanielAxelsson4.Garage.Exceptions.AirlineNameNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.AirplaneNotFoundException;
import com.github.DanielAxelsson4.Garage.Utilities.VehicleType;

public class AirPlane extends Vehicle {

	private String airlineName;

	public AirPlane(String registrationNumber, int numberOfWheels, String airlineName, String parkedGarage) throws AirlineNameNotFoundException, AirplaneNotFoundException {
		super(registrationNumber);
		this.setNumberOfWheels(numberOfWheels);
		this.vehicleType = VehicleType.AIRPLANE;
		this.setAirlineName(airlineName);
		this.parkedGarage = parkedGarage;
	}

	public void setAirlineName(String airlineName) throws AirlineNameNotFoundException
	{
		if(airlineName.equalsIgnoreCase("SAS")) {
			this.color = "white";
			this.airlineName = airlineName;
		}
		else if(airlineName.equalsIgnoreCase("Alitalia")) {
			this.color = "Green";
			this.airlineName = airlineName;
		}
		else if(airlineName.equalsIgnoreCase("Berlin")) {
			this.color = "Red";
			this.airlineName = airlineName;
		}

		else
			throw new AirlineNameNotFoundException();
	}

	@Override
	public String toString() {
		System.out.println();
		StringBuilder sb = new StringBuilder();
		sb.append("-------- " + vehicleType + " ---------\n");
		sb.append("Registration number is: ");
		sb.append(this.registrationNumber);
		sb.append("\n");
		sb.append("Color is: ");
		sb.append(this.color);
		sb.append("\n");
		sb.append("Number of wheels: ");
		sb.append(numberOfWheels);
		sb.append("\n");
		sb.append("Airplane name is: ");
		sb.append(this.getAirlineName().toUpperCase());
		sb.append("\n");
		sb.append("Airplane is currently parked in: ");
		sb.append(getparkedGarage());

		return sb.toString();
	}

	public String getparkedGarage() {
		
		return parkedGarage;
	}
	
	public String getAirlineName() {
		return airlineName;
	}

	public int getNumberOfWheels()
	{
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) throws AirplaneNotFoundException
	{
		if(numberOfWheels > 0)
			this.numberOfWheels = numberOfWheels;
		else
			throw new AirplaneNotFoundException();
	}
}
