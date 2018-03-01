package vehicle;

import utilities.VehicleType;



public abstract class Vehicle {

	protected String registrationNumber;
	protected String color;
	protected int numberOfWheels;
	protected VehicleType vehicleType;



	// Konstruktor
	protected Vehicle(String registrationNumber,String color,int numberOfWheels,VehicleType vehicleType, int price) {
		this.registrationNumber = registrationNumber;
		this.color = color;
		this.numberOfWheels = numberOfWheels;
		this.vehicleType = vehicleType;
	}













	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() == obj.getClass())
		{
			// Konvertera objekt
			Vehicle otherClass = (Vehicle)obj;
			if (registrationNumber == otherClass.registrationNumber) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "RegistrationNumber = " + registrationNumber + " \n" + "color = " + color + " \n " + "Number of wheels= " + numberOfWheels + " \n" + "vehicle type= "
				+ vehicleType +  " \n ";
	}
























}
