package com.github.DanielAxelsson4.Garage.Models;

/**
 * Class description: Boat class
 * @author Daniel Axelsson and Sohrab Azami
 *
 *
 */

import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.ColorNotFoundException;

public class Boat extends Vehicle {

	private int length;
	private int lifeboats;

	public Boat(String registrationNumber, String color, int length, int lifeboats, String parkedGarage) throws ColorNotFoundException, VehicleNotFoundException {
		super(registrationNumber);
		this.setColor(color);
		this.numberOfWheels = 0;
		this.setLength(length);
		this.lifeboats = lifeboats;
		this.parkedGarage = parkedGarage;
	}



	public int getLength() {
		return length;
	}

	public String getParkedGarage() {
		return parkedGarage;
	}

	public void setLength(int length) throws VehicleNotFoundException{
		if(length > 0 )
			this.length = length;
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
		sb.append("-------- " + "Boat" + " ---------\n");
		sb.append("Registration number is: ");
		sb.append(this.registrationNumber);
		sb.append("\n");
		sb.append("Color is: ");
		sb.append(this.color);
		sb.append("\n");
		sb.append("Length is ");
		sb.append(length);
		sb.append("\n");
		sb.append("It has ");
		sb.append(lifeboats);
		sb.append(" lifeboats");
		sb.append("\n");
		sb.append("Boat is currently parked in: ");
		sb.append(getParkedGarage());



		return sb.toString();
	}





	public String getColor() throws ColorNotFoundException {
		return this.color;
	}

}



