package by.jwd.task01basic.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task01basic.controller.impl.AbsValueOfExpressionCommandImpl;
import by.jwd.task01basic.controller.impl.AccessByPasswordControllerImpl;
import by.jwd.task01basic.controller.impl.AverageOfTwoNumberCommandImpl;
import by.jwd.task01basic.controller.impl.CharOperationsControllerImpl;
import by.jwd.task01basic.controller.impl.DoesBrickFitRectangleCommandImpl;
import by.jwd.task01basic.controller.impl.FunctionValueControllerImpl;
import by.jwd.task01basic.controller.impl.GuessNumberControllerImpl;
import by.jwd.task01basic.controller.impl.MaxDigitOfNumberCommandImpl;
import by.jwd.task01basic.controller.impl.MinOfTwoNumberCommandImpl;
import by.jwd.task01basic.controller.impl.PhysicsCommandImpl;
import by.jwd.task01basic.controller.impl.QuantityOfPositiveNumberControllerImpl;
import by.jwd.task01basic.controller.impl.RectangleAreaCommandImpl;
import by.jwd.task01basic.controller.impl.SumOfOddNumberControllerImpl;
import by.jwd.task01basic.controller.impl.SumOfPositiveRowMemberCommandImpl;
import by.jwd.task01basic.controller.impl.SwapExtraTaskControllerImpl;
import by.jwd.task01basic.controller.impl.TriangleCommandImpl;
import by.jwd.task01basic.entity.NumberData;
import by.jwd.task01basic.entity.PhysicsData;
import by.jwd.task01basic.entity.Rectangle;
import by.jwd.task01basic.entity.Triangle;
import by.jwd.task01basic.service.ArithmeticDoubleService;
import by.jwd.task01basic.service.ArithmeticIntegerService;
import by.jwd.task01basic.service.ConvertToCharService;
import by.jwd.task01basic.service.ConvertToIntService;
import by.jwd.task01basic.service.FunctionValueService;
import by.jwd.task01basic.service.GuessNumberService;
import by.jwd.task01basic.service.PasswordService;
import by.jwd.task01basic.service.PhysicsService;
import by.jwd.task01basic.service.RectangleLogicService;
import by.jwd.task01basic.service.RectangleService;
import by.jwd.task01basic.service.TriangleService;
import by.jwd.task01basic.service.impl.AbsValueOfExpressionServiceImpl;
import by.jwd.task01basic.service.impl.AccessByPasswordServiceImpl;
import by.jwd.task01basic.service.impl.AverageOfTwoNumberServiceImpl;
import by.jwd.task01basic.service.impl.ConvertToCharServiceImpl;
import by.jwd.task01basic.service.impl.ConvertToIntServiceImpl;
import by.jwd.task01basic.service.impl.DoesBrickFitRectangleServiceImpl;
import by.jwd.task01basic.service.impl.FunctionValueServiceImpl;
import by.jwd.task01basic.service.impl.GuessNumberServiceImpl;
import by.jwd.task01basic.service.impl.MaxDigitOfNumberServiceImpl;
import by.jwd.task01basic.service.impl.MinOfTwoNumberServiceImpl;
import by.jwd.task01basic.service.impl.PhysicsServiceImpl;
import by.jwd.task01basic.service.impl.QuantityOfPositiveNumberServiceImpl;
import by.jwd.task01basic.service.impl.RectangleAreaServiceImpl;
import by.jwd.task01basic.service.impl.SumOfOddNumberServiceImpl;
import by.jwd.task01basic.service.impl.SumOfPositiveRowMemberServiceImpl;
import by.jwd.task01basic.service.impl.SwapExtraTaskService;
import by.jwd.task01basic.service.impl.TriangleAreaServiceImpl;
import by.jwd.task01basic.service.impl.TriangleHeightServiceImpl;
import by.jwd.task01basic.service.impl.TriangleRadiusInServiceImpl;
import by.jwd.task01basic.service.impl.TriangleRadiusOutServiceImpl;
import by.jwd.task01basic.view.Input;
import by.jwd.task01basic.view.Output;

/*
 * Java Basics tasks: Linear tasks (5,7,19,31,33) Condidional tasks
 * (5,7,19,31,33) Loops tasks (5,7,19,31,33) Extra task (to swap numbers in 3
 * ways)
 */

public class TaskManager {

	static Logger logger = LogManager.getLogger(TaskManager.class);

	public void doAction() {

		Output output = new Output();
		Input input = new Input();
		Provider provider = new Provider();
		Command command;

		String commandName;
		String taskNumber;
		String[] params = null;

		output.showMessage("Please choose the respective point of menu (1, 2, 3 or 4)\n>>");

		commandName = input.read();

		switch (commandName) {
		/* case 1 - java linear tasks */
		case "1": {
			output.showLinearTasks();
			output.showMessage("Please input 1, 2, 3, 4 or 5 to choose the task\n>>");
			taskNumber = input.read();

			switch (taskNumber) {
			/* Absolute value of expression */
			case "1": {
				output.showMessage("Please input two numbers with space\n>>");
				params = input.read().split("\\s+");

				NumberData<Double> numberdata = new NumberData<>();

				numberdata.addNumberData(Double.parseDouble(params[0]));
				numberdata.addNumberData(Double.parseDouble(params[1]));

				ArithmeticDoubleService service = new AverageOfTwoNumberServiceImpl();

				command = new AverageOfTwoNumberCommandImpl(service, numberdata);

				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "2": {
				output.showMessage("Please input the length of rectangle\n>>");
				params = input.read().split("\\s+");
				Rectangle rectangle = new Rectangle(Double.parseDouble(params[0]), Double.parseDouble(params[0]) / 2);

				RectangleService service = new RectangleAreaServiceImpl();

				command = new RectangleAreaCommandImpl(service, rectangle);

				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "3": {
				output.showMessage("Please input the side of an equilateral triangle\n>>");
				params = input.read().split("\\s+");

				double length = Double.parseDouble(params[0]);

				Triangle triangle = new Triangle(length, length, length);

				TriangleService areaService = new TriangleAreaServiceImpl();
				TriangleService heightService = new TriangleHeightServiceImpl();
				TriangleService radiusInService = new TriangleRadiusInServiceImpl();
				TriangleService radiusOutService = new TriangleRadiusOutServiceImpl();

				command = new TriangleCommandImpl(areaService, heightService, radiusInService, radiusOutService,
						triangle);

				provider.setCommand(command);
				provider.executeCommand();

			}
				break;
			case "4": {
				output.showMessage("Please input four numbers for V, V1, T1 and T2 respectively (with spaces)\n>>");
				params = input.read().split("\\s+");

				PhysicsData physicsData = new PhysicsData();

				physicsData.setBoatSpeed(Integer.parseInt(params[0]));
				physicsData.setRiverSpeed(Integer.parseInt(params[1]));
				physicsData.setTimeWithStream(Integer.parseInt(params[2]));
				physicsData.setTimeAgainstStream(Integer.parseInt(params[3]));

				PhysicsService physicsService = new PhysicsServiceImpl();

				command = new PhysicsCommandImpl(physicsService, physicsData);
				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "5": {
				output.showMessage("Please input any character\n>>");
				params = input.read().split("\\s+");

				ConvertToIntService convertToInt = new ConvertToIntServiceImpl();
				ConvertToCharService convertToChar = new ConvertToCharServiceImpl();

				command = new CharOperationsControllerImpl(convertToInt, convertToChar, params[0].charAt(0));
				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			default:
				output.showMessage("Incorrect menu point");
			}
		}
			break;

		/* case 2 - java conditional tasks */
		case "2":

		{
			output.showConditionalTasks();
			output.showMessage("Please input 1, 2, 3, 4 or 5 to choose the task\n>>");
			taskNumber = input.read();

			switch (taskNumber) {
			case "1": {
				output.showMessage("Please input two numbers with space\n>>");
				params = input.read().split("\\s+");

				NumberData<Double> numberdata = new NumberData<>();

				numberdata.addNumberData(Double.parseDouble(params[0]));
				numberdata.addNumberData(Double.parseDouble(params[1]));

				ArithmeticDoubleService service = new MinOfTwoNumberServiceImpl();

				command = new MinOfTwoNumberCommandImpl(service, numberdata);

				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "2": {
				output.showMessage("Please input four numbers for a, b, c and x with spaces\n>>");
				params = input.read().split("\\s+");

				NumberData<Double> numberdata = new NumberData<>();

				numberdata.addNumberData(Double.parseDouble(params[0]));
				numberdata.addNumberData(Double.parseDouble(params[1]));
				numberdata.addNumberData(Double.parseDouble(params[2]));
				numberdata.addNumberData(Double.parseDouble(params[3]));

				ArithmeticDoubleService service = new AbsValueOfExpressionServiceImpl();

				command = new AbsValueOfExpressionCommandImpl(service, numberdata);
				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "3": {
				output.showMessage("Please input three numbers for a, b and c with spaces\n>>");
				params = input.read().split("\\s+");

				NumberData<Integer> numberdata = new NumberData<>();

				numberdata.addNumberData(Integer.parseInt(params[0]));
				numberdata.addNumberData(Integer.parseInt(params[1]));
				numberdata.addNumberData(Integer.parseInt(params[2]));

				QuantityOfPositiveNumberServiceImpl service = new QuantityOfPositiveNumberServiceImpl();

				command = new QuantityOfPositiveNumberControllerImpl(service, numberdata);
				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "4": {
				output.showMessage("Please input five numbers for the length and width of the rectangle"
						+ " and for the measures of the brick x,y,z respectively (with spaces)\n>>");
				params = input.read().split("\\s+");

				Rectangle rectangle = new Rectangle(Double.parseDouble(params[0]), Double.parseDouble(params[1]));

				NumberData<Double> numberdata = new NumberData<>();

				numberdata.addNumberData(Double.parseDouble(params[2]));
				numberdata.addNumberData(Double.parseDouble(params[3]));
				numberdata.addNumberData(Double.parseDouble(params[4]));

				RectangleLogicService service = new DoesBrickFitRectangleServiceImpl();

				command = new DoesBrickFitRectangleCommandImpl(service, numberdata, rectangle);

				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "5": {
				output.showMessage("Please input your password\n>>");
				String password = input.read();
				PasswordService service = new AccessByPasswordServiceImpl();

				command = new AccessByPasswordControllerImpl(service, password);

				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			default:
				output.showMessage("Incorrect menu point");
			}
		}
			break;

		/* java loops tasks */
		case "3": {
			output.showLoopTasks();
			output.showMessage("Please input 1, 2, 3, 4 or 5 to choose the task\n>>");
			taskNumber = input.read();

			switch (taskNumber) {
			case "1": {

				NumberData<Integer> numberdata = new NumberData<>();

				for (int i = 0; i < 100; i++) {
					numberdata.addNumberData(i);
				}

				SumOfOddNumberServiceImpl service = new SumOfOddNumberServiceImpl();

				command = new SumOfOddNumberControllerImpl(service, numberdata);

				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "2": {
				output.showMessage("Please input three numbers for a, b and h respectively with spaces\n>>");
				params = input.read().split("\\s+");

				NumberData<Double> numberdata = new NumberData<>();

				numberdata.addNumberData(Double.parseDouble(params[0]));
				numberdata.addNumberData(Double.parseDouble(params[1]));
				numberdata.addNumberData(Double.parseDouble(params[2]));

				FunctionValueService service = new FunctionValueServiceImpl();

				command = new FunctionValueControllerImpl(service, numberdata);

				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "3": {
				output.showMessage("Please input two numbers for e and the length of the row (with spaces)\n>>");
				params = input.read().split("\\s+");

				NumberData<Double> numberdata = new NumberData<>();

				numberdata.addNumberData(Double.parseDouble(params[0]));
				numberdata.addNumberData(Double.parseDouble(params[1]));

				ArithmeticDoubleService service = new SumOfPositiveRowMemberServiceImpl();

				command = new SumOfPositiveRowMemberCommandImpl(service, numberdata);
				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			case "4": {
				output.showMessage("Please input five numbers with spaces\n>>");
				params = input.read().split("\\s+");

				NumberData<Integer> numberData = new NumberData<>();

				numberData.addNumberData(Integer.parseInt(params[0]));
				numberData.addNumberData(Integer.parseInt(params[1]));
				numberData.addNumberData(Integer.parseInt(params[2]));
				numberData.addNumberData(Integer.parseInt(params[3]));
				numberData.addNumberData(Integer.parseInt(params[4]));

				GuessNumberService service = new GuessNumberServiceImpl();

				command = new GuessNumberControllerImpl(service, numberData);
				provider.setCommand(command);
				provider.executeCommand();

			}
				break;
			case "5": {
				output.showMessage("Please input any natural number\n>>");
				params = input.read().split("\\s+");
				ArithmeticIntegerService service = new MaxDigitOfNumberServiceImpl();

				NumberData<Integer> numberData = new NumberData<>();

				numberData.addNumberData(Integer.parseInt(params[0]));

				command = new MaxDigitOfNumberCommandImpl(service, numberData);

				provider.setCommand(command);
				provider.executeCommand();
			}
				break;
			default:
				output.showMessage("Incorrect menu point");
			}
		}
			break;

		/* extra swap task */
		case "4": {
			output.showExtraTask();
			output.showMessage("Please input two numbers with spaces\n>>");
			params = input.read().split("\\s+");

			NumberData<Integer> numberData = new NumberData<>();

			numberData.addNumberData(Integer.parseInt(params[0]));
			numberData.addNumberData(Integer.parseInt(params[1]));

			SwapExtraTaskService service = new SwapExtraTaskService();

			command = new SwapExtraTaskControllerImpl(service, numberData);
			provider.setCommand(command);
			provider.executeCommand();
		}
			break;

		default:
			output.showMessage("Incorrect menu point");
		}
	}
}