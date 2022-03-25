package by.jwd.task03polymorphism.controller;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task03polymorphism.view.Input;
import by.jwd.task03polymorphism.view.MessageManager;
import by.jwd.task03polymorphism.view.Output;

/*13. Фургон кофе. Загрузить фургон определенного объема грузом на определенную сумму из различных сортов кофе, находящихся к тому же в разных
физических состояниях (зерно, молотый, растворимый в банках и пакетиках). Учитывать объем кофе вместе с упаковкой. Провести сортировку товаров на основе соотношения цены и веса. Найти в фургоне товар, соответствующий заданному диапазону параметров качества.*/

public class Runner {

	static Logger logger = LogManager.getLogger(Runner.class);

	public static void main(String[] args) {

		Output output = new Output();
		Input input = new Input();
		MessageManager current = MessageManager.EN;

		output.print("1 — eng\n2 — rus\nany — default");

		try {
			String language = input.read();

			switch (language) {
			case "1":
				current = MessageManager.EN;
				break;
			case "2":
				current = MessageManager.RU;
				break;
			default:
				current = MessageManager.EN;
			}

			CommandProvider provider = new CommandProvider();
			Command command;

			output.print(current.getString("request1"));

			String[] vanParam = input.read().split("\\s+");
			if (vanParam.length != 3) {
				throw new ArrayIndexOutOfBoundsException();
			}
			output.print(current.getString("menu"));
			output.print(current.getString("request2"));

			String commandName = input.read();

			String[] searchParam = new String[10];
			if (commandName.equals("4")) {

				for (int i = 0; i < searchParam.length; i++) {
					output.print(current.getString("paramrequest" + i));
					searchParam[i] = input.read();
				}
			}

			String[][] param = new String[2][];
			param[0] = vanParam;
			param[1] = searchParam;

			command = provider.getCommand(commandName);
			command.execute(current, param);
		} catch (IOException e) {
			output.print(current.getString("err2"));
			logger.error("Incorrect input");
		} catch (ArrayIndexOutOfBoundsException e) {
			logger.error("wrong quantity of args");
			output.print(current.getString("err3"));
		}
	}
}
