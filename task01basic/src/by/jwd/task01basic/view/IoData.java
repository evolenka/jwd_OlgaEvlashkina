package by.jwd.task01basic.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IoData {

	// show available menu to user
	public void showMenu() {
		System.out.println("+++Task menu+++:\n" + "1 - Arithmetic\n" + "2 - Geometry:\n" + "    1 - Rectangle\n"
				+ "    2 - Triangle\n" + "3 - Physics\n" + "4 - Text/char operations\n");
	}

	// description of each task
	public void showArithmeticTask() {
		System.out.println("++Task: Find average of two numbers++");
	}

	public void showTaskRectangle() {
		System.out.println("++Task: The width of rectangle is half the length. Find the area of a rectangle++");
	}

	public void showTaskTriangle() {
		System.out.println(
				"++Task: Find the area of the equilateral triangle, its height, the radius of the inscribed and circumscribed circles++");
	}

	public void showPhysicsTask() {
		System.out.println(
				"++Task: Calculate the distance traveled by the boat, if its speed in still water is V (km / h), the speed of the river is V1 (km / h), the time of movement on the river is T1 (h), and time against the stream of the river - T2 (h)++");
	}

	public void showTextTask() {
		System.out.println(
				"++Task: Input any character and find its number designation, the previous and the next characters++");
	}

	// read data inputed by user
	public String input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str;
			str = br.readLine();
			return str;
		} catch (IOException e) {
			return "Incorrect input";
		}
	}

	// output message to user
	public String print(String message) {
		System.out.println(message);
		return " ";
	}

	// output responce to user
	public String printResponce(String message, String result) {
		System.out.println(message + result);
		return " ";
	}
}