package phone;

import java.math.BigDecimal;

import ui.FrameWindow;
import ui.PrintingUI;





public class Main {

	public static void main(String[] args) {


		new BigDecimal(0.1);
		PrintingUI ui = new PrintingUI();
		FrameWindow window = new FrameWindow();
		Inventory cellphoneCatalog = new Inventory();

		Cellphone cellphone1 = new Cellphone("0001","Samsung Galaxy S9","Galaxy 9","SG-M093",900);
		Cellphone cellphone2 = new Cellphone("0150","Iphone X","iPhone-X","i-P010e01",950);
		Cellphone cellphone3 = new Cellphone("6031","Infinix Hot S3","Hot S3","inf-P0130",500);
		Cellphone cellphone4 = new Cellphone("7301","Sony Xperia XA2","XA2","X-XA2.01",650);
		Cellphone cellphone5 = new Cellphone("0530","Nokia 6","Nokia-6","NOK-N9368",700);

		cellphoneCatalog.addCellphone(cellphone1);
		cellphoneCatalog.addCellphone(cellphone2);
		cellphoneCatalog.addCellphone(cellphone3);
		cellphoneCatalog.addCellphone(cellphone4);
		cellphoneCatalog.addCellphone(cellphone5);

		window.runUI();
		//	ui.printCellphoneCatalog(Inventory.getCellphoneMap());


		//	System.out.println(cellphoneCatalog.getCellphoneMap().size());

		//		System.out.println( cellphone1.getPriceInString() );





	}

}
