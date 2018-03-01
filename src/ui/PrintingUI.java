package ui;

import java.util.TreeMap;

import models.Vehicle;

public class PrintingUI {

	public void printCellphoneCatalog(TreeMap<String,Vehicle> vehicleCatalog) {

		for (Vehicle nextVehicle : vehicleCatalog.values() ) {
			System.out.println(nextVehicle.toString() );

		}
	}

}
