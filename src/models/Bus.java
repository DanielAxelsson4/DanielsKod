
package models;

import utilities.VehicleType;

public class Bus extends Vehicle {

	public Bus(String registrationNumber, String color, int numberOfWheels, int numberOfSeats) throws ColorNotFoundException {
		super(registrationNumber);
		this.setColor(color);	
		this.numberOfWheels = numberOfWheels;
		this.vehicleType = VehicleType.BUS;

	}



	protected void setColor(String color) throws ColorNotFoundException{
		if (color.equals("Black")) {
			this.color = color;
		}
		else if (color.equals("White") ) {
			this.color = color;
		}
		else if (color.equals("Green") ) {
			this.color = color;
		}
		else if (color.equals("Red") ) {
			this.color = color;
		}
		else if (color.equals("Yellow") ) {
			this.color = color;
		}
		else {
			throw new ColorNotFoundException();
		}
	}
	
	public String getColor() throws ColorNotFoundException {
		return this.color;
	}

}


