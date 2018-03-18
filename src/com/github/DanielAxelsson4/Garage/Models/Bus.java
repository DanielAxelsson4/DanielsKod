

package com.github.DanielAxelsson4.Garage.Models;

/**
 * Class description: Bus class
 * @author Daniel Axelsson and Sohrab Azami
 *
 *
 */

import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.ColorNotFoundException;

public class Bus extends Vehicle {

	private int numberOfSeats;

	public Bus(String registrationNumber, String color, int numberOfWheels, int numberOfSeats, String parkedGarage) throws ColorNotFoundException, VehicleNotFoundException {
		super(registrationNumber);
		this.setColor(color);
		this.numberOfWheels = numberOfWheels;
		this.setNumberOfSeats(numberOfSeats);
		this.parkedGarage = parkedGarage;

	}



	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public String getParkedGarage() {
		return parkedGarage;
	}


	public void setNumberOfSeats(int numberOfSeats) throws VehicleNotFoundException
	{
		if(numberOfSeats > 0)
			this.numberOfSeats = numberOfSeats;
		else
			throw new VehicleNotFoundException();
	}


	protected void setColor(String color) throws ColorNotFoundException{
		if (color.equalsIgnoreCase("Black")) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("White") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Green") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Red") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Yellow") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Blue") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Orange") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Purple") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Grey") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Black") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Brown") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Pink") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Cyan") ) {
			this.color = color;
		}
		else if (color.equalsIgnoreCase("Magenta") ) {
			this.color = color;
		}
		else {
			throw new ColorNotFoundException();
		}
	}


	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("-------- " + "Bus" + " ---------\n");
		sb.append("Registration number is: ");
		sb.append(this.registrationNumber);
		sb.append("\n");
		sb.append("Color is: ");
		sb.append(this.color);
		sb.append("\n");
		sb.append("Number of wheels: ");
		sb.append(numberOfWheels);
		sb.append("\n");
		sb.append("Number of seats: ");
		sb.append(numberOfSeats);
		sb.append("\n");
		sb.append("Bus is currently parked in: ");
		sb.append(getParkedGarage());
		return sb.toString();
	}


	public String getColor() throws ColorNotFoundException {
		return this.color;
	}

}
