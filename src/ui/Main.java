package ui;import models.Car;
import models.ColorNotFoundException;

public class Main {

	public static void main(String[] args) {

		// input


		try {

			Car car = new Car("12313", "Red", 4);
		}
		catch(ColorNotFoundException e) {
			System.out.println("The color: " + color);

		}






	}

}
