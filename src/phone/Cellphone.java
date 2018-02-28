package phone;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;



public class Cellphone {

	static String productCounter;
	private String model;
	private String name;
	private int price;
	private String productId;
	private String serialnumber;



	// Konstruktor
	public Cellphone(String productId,String name,String model,String serialnumber, int price) {
		this.productId = productId;
		this.name = name;
		this.model = model;
		this.serialnumber = serialnumber;
		this.price = price;
	}

	public static void setProductCounter(String productCounter) {
		Cellphone.productCounter = productCounter;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() == obj.getClass())
		{
			// Konvertera objekt
			Cellphone otherClass = (Cellphone)obj;
			if (productId == otherClass.productId) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	public String getModel() {
		return model;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}


	public String getPriceInString(int price) {
		NumberFormat ukCostFormat = NumberFormat.getCurrencyInstance(Locale.UK);
		ukCostFormat.setMinimumFractionDigits( 1 );
		ukCostFormat.setMaximumFractionDigits( 2 );
		BigDecimal modelVal = new BigDecimal(Integer.toString(price));
		BigDecimal displayVal = modelVal.setScale(2, RoundingMode.HALF_EVEN);
		return ukCostFormat.format(displayVal.doubleValue() );
	}


	public String getProductCounter() {
		return productCounter;
	}


	public String getProductId() {
		return productId;
	}


	public String getSerialnumber() {
		return serialnumber;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}


	@Override
	public String toString() {
		return "ProductId = " + productId + " \n" + "Name = " + name + " \n " + "Model= " + model + " \n" + "Serialnumber= "
				+ serialnumber + " \n " +  "Price= " + getPriceInString(price) +  " \n ";
	}
























}
