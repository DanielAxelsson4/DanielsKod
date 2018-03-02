

package models;

import utilities.VehicleType;

public class Bus extends Vehicle {

	private int numberOfSeats;

	public Bus(String registrationNumber, String color, int numberOfWheels, int numberOfSeats) throws ColorNotFoundException, BusNotFoundException {
		super(registrationNumber);
		this.setColor(color);
		this.numberOfWheels = numberOfWheels;
		this.vehicleType = VehicleType.BUS;
		this.setNumberOfSeats(numberOfSeats);

	}



	public int getNumberOfSeats() {
		return numberOfSeats;
	}


	public void setNumberOfSeats(int numberOfSeats) throws BusNotFoundException 
	{
		if(numberOfSeats > 0)
			this.numberOfSeats = numberOfSeats;
		else
			throw new BusNotFoundException();
	}


	protected void setColor(String color) throws ColorNotFoundException{
		if (color.equals("Black")) {
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
		else {
			throw new ColorNotFoundException();
		}
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
		sb.append("Number of seats: ");
		sb.append(numberOfSeats);
		sb.append("\n");
		return sb.toString();
	}


	public String getColor() throws ColorNotFoundException {
		return this.color;
	}

}
