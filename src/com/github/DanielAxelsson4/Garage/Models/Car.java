package com.github.DanielAxelsson4.Garage.Models;

import com.github.DanielAxelsson4.Garage.Exceptions.VehicleNotFoundException;
import com.github.DanielAxelsson4.Garage.Exceptions.ColorNotFoundException;

/**
 * Class description: Car Class
 * @author Daniel Axelsson and Sohrab Azami
 *
 *
 */

public class Car extends Vehicle {

	private int power;


	public int getPower() throws VehicleNotFoundException{
		if( this.power > 0)
			return power;
		else
			throw new VehicleNotFoundException();
	}

	public Car(String registrationNumber, String color, int numberOfWheels, int power, String parkedGarage) throws ColorNotFoundException, VehicleNotFoundException {
		super(registrationNumber);
		this.setColor(color);
		this.numberOfWheels = numberOfWheels;
		this.power = power;
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
		return parkedGarage;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("-------- " + "Car" + " ---------\n");
		sb.append("registration number is: ");
		sb.append(this.registrationNumber);
		sb.append("\n");
		sb.append("color is: ");
		sb.append(this.getColor().toUpperCase());
		sb.append("\n");
		sb.append("number of wheels: ");
		sb.append(numberOfWheels);
		sb.append("\n");
		sb.append("Horse Power is: ");
		sb.append(this.power);
		sb.append("\n");
		sb.append("Car is currently parked in: ");
		sb.append(getParkedGarage());

		return sb.toString();
	}





}


