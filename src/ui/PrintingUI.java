package ui;

import java.util.TreeMap;

import phone.Cellphone;

public class PrintingUI {

	public void printCellphoneCatalog(TreeMap<String,Cellphone> cellphoneCatalog) {

		for (Cellphone nextCellphone : cellphoneCatalog.values() ) {
			System.out.println(nextCellphone.toString() );

		}
	}


	/*	public void printCellphoneCatalogHTML(TreeMap<String,Cellphone> cellphoneCatalog, String productId) {

		for (Cellphone nextCellphone : cellphoneCatalog.values() ) {
			String outputHTML = "<html> " + Inventory.getCellphoneMap().get(productId).toString() + " </html>";

			System.out.println(nextCellphone.toString() );

		}
	}*/

}
