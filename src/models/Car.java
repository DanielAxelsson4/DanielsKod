package models;

import utilities.VehicleType;

public class Car extends Vehicle {

	public Car(String registrationNumber, String color, int numberOfWheels) throws ColorNotFoundException {
		super(registrationNumber);
		this.SetColor(color);
		this.numberOfWheels = numberOfWheels;
		this.vehicleType = VehicleType.CAR;
	}

	protected void SetColor(String color) throws ColorNotFoundException
	{
		if(color.equals("Black"))
			this.color = color;
		else if(color.equals("White"))
			this.color = color;
		else if(color.equals("Green"))
			this.color = color;
		else if(color.equals("Red"))
			this.color = color;
		else if(color.equals("Yellow"))
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
		sb.append("registration number is: ");
		sb.append(this.registrationNumber);
		sb.append("\n");
		sb.append("color is: ");
		sb.append(this.color);
		sb.append("\n");
		sb.append("number of wheels: ");
		sb.append(numberOfWheels);

		return sb.toString();
	}
}
