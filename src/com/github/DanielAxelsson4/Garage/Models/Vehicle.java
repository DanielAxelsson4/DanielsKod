package com.github.DanielAxelsson4.Garage.Models;



/**
 * Class description: Vehicle class
 * @author Daniel Axelsson and Sohrab Azami
 *
 *
 */

public abstract class Vehicle {

	protected String registrationNumber;
	protected String color;
	protected int numberOfWheels;
	//protected VehicleType vehicleType;
	protected String parkedGarage;

	protected Vehicle(String registrationNumber) {
		this.registrationNumber = registrationNumber;
		this.color = "";
		this.numberOfWheels = 0;
	//	this.vehicleType = VehicleType.NOTYPE;
	}

	public String getRegistrationNumber()  {
		return registrationNumber;
	}

	@Override
	public String toString() {
		return "RegistrationNumber = " + registrationNumber + " \n" + "color = " + color + " \n " + "Number of wheels= " + numberOfWheels + " \n";
	}

































}
