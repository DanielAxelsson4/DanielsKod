package ui;

import java.util.TreeMap;

import models.Vehicle;

public class PrintingUI {

	public void printVehicleCatalog(TreeMap<String,Vehicle> garageCatalog) {

		for (Vehicle nextVehicle : garageCatalog.values() ) {
			System.out.println(nextVehicle.toString() );

		}
	}

}
