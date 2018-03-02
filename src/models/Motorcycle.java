
<<<<<<< HEAD
package models;

import utilities.VehicleType;

public class Motorcycle extends Vehicle {

	private int cylinderVolume;

	public Motorcycle(String registrationNumber, String color, int cylinderVolume) throws ColorNotFoundException {
		super(registrationNumber);
		this.SetColor(color);
		this.numberOfWheels = 2;
		this.vehicleType = VehicleType.MOTORCYCLE;
		this.cylinderVolume = cylinderVolume;
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



	public int isCylinderVolume() {
		return cylinderVolume;
	}

	public void setCylinderVolume(int cylinderVolume) {
		this.cylinderVolume = cylinderVolume;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("--------MOTORCYCLE--------");
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
		sb.append(" litres");
		sb.append("\n");
		return sb.toString();
	}
}
=======
package models;

import utilities.VehicleType;

public class Motorcycle extends Vehicle {

	private int cylinderVolume;

	public Motorcycle(String registrationNumber, String color, int cylinderVolume) throws ColorNotFoundException, MotorCycleNotFoundException {
		super(registrationNumber);
		this.SetColor(color);
		this.numberOfWheels = 2;
		this.vehicleType = VehicleType.MOTORCYCLE;
		this.cylinderVolume = cylinderVolume;
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



	public int getCylinderVolume() {
		return cylinderVolume;
	}

	public void setCylinderVolume(int cylinderVolume) throws MotorCycleNotFoundException {
		if(cylinderVolume > 0)
			this.cylinderVolume = cylinderVolume;
		else
			throw new MotorCycleNotFoundException();
	}

	@Override
	public String toString() {

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
		sb.append("Cylinder volume: ");
		sb.append(cylinderVolume);
		sb.append(" litres");
		sb.append("\n");
		return sb.toString();
	}
}
>>>>>>> 4ac3e0b4205f8299447a167cd594f3013e2da050
