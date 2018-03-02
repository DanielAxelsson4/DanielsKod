

package models;

import utilities.VehicleType;

public class Boat extends Vehicle {

	private int length;
	private int lifeboats;

	public Boat(String registrationNumber, String color, int length, int lifeboats) throws ColorNotFoundException, BoatNotFoundException {
		super(registrationNumber);
		this.setColor(color);
		this.numberOfWheels = 0;
		this.vehicleType = VehicleType.BOAT;
		this.setLength(length);
		this.lifeboats = lifeboats;
	}



	public int getLength() {
		return length;
	}



	public void setLength(int length) throws BoatNotFoundException{
		if(length > 0 )
			this.length = length;
		else
			throw new BoatNotFoundException();
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
		sb.append("Length is ");
		sb.append(length);
		sb.append("\n");
		sb.append("It has ");
		sb.append(lifeboats);
		sb.append(" lifeboats");
		sb.append("\n");


		return sb.toString();
	}





	public String getColor() throws ColorNotFoundException {
		return this.color;
	}

}



