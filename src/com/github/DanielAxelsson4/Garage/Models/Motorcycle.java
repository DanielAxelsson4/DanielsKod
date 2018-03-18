
package com.github.DanielAxelsson4.Garage.Models;

import com.github.DanielAxelsson4.Garage.Exceptions.ColorNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;

/**
 * Class description: Motorcycle class
 * @author Daniel Axelsson and Sohrab Azami
 *
 *
 */

public class Motorcycle extends Vehicle {

	private int cylinderVolume;

	public Motorcycle(String registrationNumber, String color, int cylinderVolume, String parkedGarage) throws ColorNotFoundException, VehicleNotFoundException {
		super(registrationNumber);
		this.setColor(color);
		this.numberOfWheels = 2;
		this.cylinderVolume = cylinderVolume;
		this.parkedGarage = parkedGarage;
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

	public String getColor()
	{
		return this.color;
	}
	public String getParkedGarage()
	{
		return this.parkedGarage;
	}



	public int getCylinderVolume() {
		return cylinderVolume;
	}

	public void setCylinderVolume(int cylinderVolume) throws VehicleNotFoundException {
		if(cylinderVolume > 0)
			this.cylinderVolume = cylinderVolume;
		else
			throw new VehicleNotFoundException();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("-------- " + "Motorcycle" + " ---------\n");
		sb.append("Registration number is: ");
		sb.append(this.registrationNumber);
		sb.append("\n");
		sb.append("Color is: ");
		sb.append(this.color);
		sb.append("\n");
		sb.append("Number of wheels: ");
		sb.append(numberOfWheels);
		sb.append("\n");
		sb.append("Cylinder volume: ");
		sb.append(cylinderVolume);
		sb.append(" liters");
		sb.append("\n");
		sb.append("Motorcycle is currently parked in: ");
		sb.append(getParkedGarage());
		return sb.toString();
	}
}
