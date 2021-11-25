package by.jwd.task01basic.runner;

import by.jwd.task01basic.controller.Command;
import by.jwd.task01basic.controller.impl.ArithmeticControllerImpl;
import by.jwd.task01basic.controller.impl.GeometricControllerImpl;
import by.jwd.task01basic.controller.impl.PhysicsControllerImpl;
import by.jwd.task01basic.controller.impl.CharOperationsControllerImpl;
import by.jwd.task01basic.view.IoData;

/* Java basics:
 1. Arithmetic:
   Task: Find average of two numbers (5)
 2. Geometric Arithmetic:
   2.1. Rectangle:
        Task: The width of rectangle is half the length. Find the area of a rectangle (7)
   2.2. Triangle:
        Task: Find the area of the equilateral triangle, its height, the radius of the inscribed and circumscribed circles(19)
 3. Physics:
   Task: Calculate the distance traveled by the boat, if its speed in still water is V (km / h), the speed of the river is V1 (km / h), the time of movement on the river is T1 (h), and time against the stream of the river - T2 (h)++ (31)
 4. Text:
   Task: Input any character and find its number designation, the previous and the next characters(33)*/

public class Runner {

	public static void main(String[] args) {

		// show menu to user

		IoData iodata = new IoData();
		iodata.showMenu();

		// ask user to choose point in menu, then depending on point, show the
		// respective task and ask to input data

		String commandName;
		iodata.print("Please choose the respective point of menu (1, 2, 3, or 4)\n>>");
		commandName = iodata.input();

		String[] params;
		Command command;

		switch (commandName) {

		// case 1 - arithmetic task
		// pass the inputed numbers as parameters (params)to the method execute()

		case "1": {
			iodata.showArithmeticTask();
			iodata.print("Please input two numbers with space\n>>");
			params = iodata.input().split("\\s+");
			command = new ArithmeticControllerImpl();
			command.execute(params);
		}
			break;

		// case 2 - geometric tasks
		// ask user to choose the point in submenu and then to input data, pass the
		// point of submenu and data as parameters (params) to the method execute()

		case "2": {

			iodata.print("Please input 1 to choose operations for rectangle or 2  - for triangle\n>>");
			params = new String[2];
			params[0] = iodata.input();
			if (params[0].equals("1")) {
				iodata.showTaskRectangle();
				iodata.print("Please input the length of rectangle>>");
			} else if (params[0].equals("2")) {
				iodata.showTaskTriangle();
				iodata.print("Please input the side of an equilateral triangle\n>>");
			} else {
				iodata.print("Incorrect menu point");
				break;
			}
			params[1] = iodata.input();
			command = new GeometricControllerImpl();
			command.execute(params);
		}
			break;

		// case 3 - physics
		// pass the inputed data as parameters (params)to the method execute()

		case "3": {
			iodata.showPhysicsTask();
			iodata.print("Please input four numbers for V, V1, T1 and T2 respectively (with spaces)\n>> ");
			params = iodata.input().split("\\s+");
			command = new PhysicsControllerImpl();
			command.execute(params);
		}
			break;

		// case 4 - text task
		// pass the inputed character as parameter (params) to the method execute()

		case "4": {
			iodata.showTextTask();
			iodata.print("Please input any character\n>>");
			params = new String[1];
			params[0] = iodata.input();
			command = new CharOperationsControllerImpl();
			command.execute(params);
		}
			break;
		default:
			iodata.print("Incorrect menu point");
		}
	}
}