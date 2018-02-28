package phone;

import java.util.TreeMap;

public class Inventory implements CellphoneInventoryInterface {


	private static TreeMap<String, Cellphone> cellphoneMap;



	public Inventory() {
		cellphoneMap = new TreeMap<String, Cellphone>();
	}

	@Override
	public void addCellphone(Cellphone newCellphone ) {
		if (cellphoneMap.containsKey(newCellphone.getProductId())){
		}
		// Lägg till cellphone
		cellphoneMap.put(newCellphone.getProductId(), newCellphone);
	}

	public static TreeMap<String,Cellphone> getCellphoneMap() {
		return cellphoneMap;
	}

	@Override
	public Cellphone findCellphone(String name) throws CellphoneNotFoundException {
		// tar bort extra spaces framför och bakåt
		name = name.trim();
		// Enhanced for loop
		// For (Objekt-typ temporärt-namn: värden)
		for (Cellphone nextCellphone: cellphoneMap.values() ) {
			// Om det har samma namn
			if (nextCellphone.getName().equalsIgnoreCase(name) ) {
				return nextCellphone;
			}
		}
		// Om inget hittas kasta ett exception
		throw new CellphoneNotFoundException();

	}

	public void listCellPhones(TreeMap<String,Cellphone> cellphoneMap) {

		for (Cellphone nextCellphone : cellphoneMap.values() ) {
			System.out.println(nextCellphone.toString() );
		}
	}

	public void deleteCellphone(Cellphone newCellphone ) {
		if (cellphoneMap.containsKey(newCellphone.getProductId())){
			cellphoneMap.remove(newCellphone.getProductId());
		}
	}


	public void printCellphoneCatalog(TreeMap<String,Cellphone> cellphoneCatalog) {
		for (Cellphone nextCellphone : cellphoneCatalog.values() ) {
			System.out.println(nextCellphone.toString());
		}
	}

	@Override
	public int getNumberOfCellphones() {
		return cellphoneMap.size();
	}


}


