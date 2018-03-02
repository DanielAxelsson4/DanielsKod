package models;

import utilities.VehicleType;


public class Car extends Vehicle {

	private int power;
<<<<<<< HEAD
	

	public int getPower() {
		return power;
=======


	public int getPower() throws CarNotFoundException{
		if( this.power > 0)
			return power;
		else
			throw new CarNotFoundException();
>>>>>>> 4ac3e0b4205f8299447a167cd594f3013e2da050
	}

	public Car(String registrationNumber, String color, int numberOfWheels, int power) throws ColorNotFoundException, CarNotFoundException {
		super(registrationNumber);
		this.SetColor(color);
		this.numberOfWheels = numberOfWheels;
		this.vehicleType = VehicleType.CAR;
		this.power = power;
	}

	protected void SetColor(String color) throws ColorNotFoundException
	{
		if(color.equalsIgnoreCase("Black"))
			this.color = color;
		else if(color.equalsIgnoreCase("White"))
			this.color = color;
		else if(color.equalsIgnoreCase("Green"))
			this.color = color;
		else if(color.equalsIgnoreCase("Red"))
			this.color = color;
		else if(color.equalsIgnoreCase("Yellow"))
			this.color = color;
		else
			throw new ColorNotFoundException();
	}

	public String getColor()
	{
		return this.color;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("-------- " + vehicleType + " ---------\n");
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

		return sb.toString();
	}
<<<<<<< HEAD
	

		
		
	}
	

=======

	



}


>>>>>>> 4ac3e0b4205f8299447a167cd594f3013e2da050
