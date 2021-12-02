package by.jwd.task01basic.controller;

import by.jwd.task01basic.controller.impl.AbsValueOfExpressionControllerImpl;
import by.jwd.task01basic.controller.impl.AccessByPasswordControllerImpl;
import by.jwd.task01basic.controller.impl.AverageOfTwoNumberControllerImpl;
import by.jwd.task01basic.controller.impl.CharOperationsControllerImpl;
import by.jwd.task01basic.controller.impl.DoesBrickFitRectangleControllerImpl;
import by.jwd.task01basic.controller.impl.FunctionValueControllerImpl;
import by.jwd.task01basic.controller.impl.GuessNumberControllerImpl;
import by.jwd.task01basic.controller.impl.MaxDigitOfNumberControllerImpl;
import by.jwd.task01basic.controller.impl.MinOfTwoNumberControllerImpl;
import by.jwd.task01basic.controller.impl.PhysicsControllerImpl;
import by.jwd.task01basic.controller.impl.QuantityOfPositiveNumberControllerImpl;
import by.jwd.task01basic.controller.impl.RectangleAreaControllerImpl;
import by.jwd.task01basic.controller.impl.SumOfOddNumberControllerImpl;
import by.jwd.task01basic.controller.impl.SumOfPositiveRowMemberControllerImpl;
import by.jwd.task01basic.controller.impl.SwapExtraTaskControllerImpl;
import by.jwd.task01basic.controller.impl.TriangleControllerImpl;
import by.jwd.task01basic.view.Input;
import by.jwd.task01basic.view.Output;

/*
 * show the respective tasks for the chosen menu point ('commandName'), then ask
 * user to choose the task and to input the respective data for the task; pass
 * data as parameters to the method execute () 
 */

public class TaskProvider {

	String commandName;

	public void doAction(String commandName) {

		Output output = new Output();
		Input input = new Input();

		String taskNumber;
		String[] params = null;
		Command command;

		switch (commandName) {

		/* case 1 - java linear tasks */
		case "1": {
			output.showLinearTasks();
			output.print("Please input 1, 2, 3, 4 or 5 to choose the task\n>>");
			taskNumber = input.read();

			switch (taskNumber) {
			case "1": {
				output.print("Please input two numbers with space\n>>");
				params = input.read().split("\\s+");
				command = new AverageOfTwoNumberControllerImpl();
				command.execute(params);
			}
				break;
			case "2": {
				output.print("Please input the length of rectangle\n>>");
				params = input.read().split("\\s+");
				command = new RectangleAreaControllerImpl();
				command.execute(params);
			}
				break;
			case "3": {
				output.print("Please input the side of an equilateral triangle\n>>");
				params = input.read().split("\\s+");
				command = new TriangleControllerImpl();
				command.execute(params);
			}
				break;
			case "4": {
				output.print("Please input four numbers for V, V1, T1 and T2 respectively (with spaces)\n>>");
				params = input.read().split("\\s+");
				command = new PhysicsControllerImpl();
				command.execute(params);
			}
				break;
			case "5": {
				output.print("Please input any character\n>>");
				params = input.read().split("\\s+");
				command = new CharOperationsControllerImpl();
				command.execute(params);
			}
				break;
			default:
				output.print("Incorrect menu point");
			}
		}
			break;

		/* case 2 - java conditional tasks */
		case "2": {
			output.showConditionalTasks();
			output.print("Please input 1, 2, 3, 4 or 5 to choose the task\n>>");
			taskNumber = input.read();

			switch (taskNumber) {
			case "1": {
				output.print("Please input two numbers with space\n>>");
				params = input.read().split("\\s+");
				command = new MinOfTwoNumberControllerImpl();
				command.execute(params);
			}
				break;
			case "2": {
				output.print("Please input four numbers for a, b, c and x with spaces\n>>");
				params = input.read().split("\\s+");
				command = new AbsValueOfExpressionControllerImpl();
				command.execute(params);
			}
				break;
			case "3": {
				output.print("Please input three numbers for a, b and c with spaces\n>>");
				params = input.read().split("\\s+");
				command = new QuantityOfPositiveNumberControllerImpl();
				command.execute(params);
			}
				break;
			case "4": {
				output.print("Please input five numbers for the length and width of the rectangle"
						+ " and for the measures of the brick x,y,z respectively (with spaces)\n>>");
				params = input.read().split("\\s+");
				command = new DoesBrickFitRectangleControllerImpl();
				command.execute(params);
			}
				break;
			case "5": {
				output.print("Please input your password\n>>");
				params = input.read().split("\\s+");
				command = new AccessByPasswordControllerImpl();
				command.execute(params);
			}
				break;
			default:
				output.print("Incorrect menu point");
			}
		}
			break;

		/* java loops tasks */
		case "3": {
			output.showLoopTasks();
			output.print("Please input 1, 2, 3, 4 or 5 to choose the task\n>>");
			taskNumber = input.read();

			switch (taskNumber) {
			case "1": {
				command = new SumOfOddNumberControllerImpl();
				command.execute(params);
			}
				break;
			case "2": {
				output.print("Please input three numbers for a, b and h respectively with spaces\n>>");
				params = input.read().split("\\s+");
				command = new FunctionValueControllerImpl();
				command.execute(params);
			}
				break;
			case "3": {
				output.print("Please input two numbers for e and the length of the row (with spaces)\n>>");
				params = input.read().split("\\s+");
				command = new SumOfPositiveRowMemberControllerImpl();
				command.execute(params);
			}
				break;
			case "4": {
				output.print("Please input five numbers with spaces\n>>");
				params = input.read().split("\\s+");
				command = new GuessNumberControllerImpl();
				command.execute(params);
			}
				break;
			case "5": {
				output.print("Please input any natural number\n>>");
				params = input.read().split("\\s+");
				command = new MaxDigitOfNumberControllerImpl();
				command.execute(params);
			}
				break;
			default:
				output.print("Incorrect menu point");
			}
		}
			break;

		/* extra swap task */
		case "4": {
			output.showExtraTask();
			output.print("Please input two numbers with spaces\n>>");
			params = input.read().split("\\s+");
			command = new SwapExtraTaskControllerImpl();
			command.execute(params);
		}
			break;

		default:
			output.print("Incorrect menu point");
		}
	}
}