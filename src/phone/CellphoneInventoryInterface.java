package phone;


public interface CellphoneInventoryInterface {

	public void addCellphone(Cellphone newCellphone);
	//public TreeMap<String, Cellphone> getCellphoneMap();
	public Cellphone findCellphone(String title) throws CellphoneNotFoundException ;
	public int getNumberOfCellphones();
	
	
}
