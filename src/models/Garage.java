
package models;

import java.util.TreeMap;

public class Garage {


	private static TreeMap<String, Vehicle> garageMap;



	public Garage() {
		garageMap = new TreeMap<String, Vehicle>();
	}

	public static TreeMap<String,Vehicle> getVehicleMap() {
		return garageMap;
	}

	public void addVehicle(Vehicle newVehicle ) {
		if (garageMap.containsKey(newVehicle.getRegistrationNumber())){
		}
		// Lägg till vehicle
		garageMap.put(newVehicle.getRegistrationNumber(), newVehicle);
	}



	public void listVehicles(TreeMap<String,Vehicle> garageMap) {

		for (Vehicle nextVehicle : garageMap.values() ) {
			System.out.println(nextVehicle.toString() );
		}
	}

	public void deleteVehicle(Vehicle newVehicle ) {
		if (garageMap.containsKey(newVehicle.getRegistrationNumber())){
			garageMap.remove(newVehicle.getRegistrationNumber());
		}
	}


	public void printVehicles(TreeMap<String,Vehicle> garageMap) {
		for (Vehicle nextVehicle : garageMap.values() ) {
			System.out.println(nextVehicle.toString());
		}
	}

	public int getNumberOfVehicles() {
		return garageMap.size();
	}


}


