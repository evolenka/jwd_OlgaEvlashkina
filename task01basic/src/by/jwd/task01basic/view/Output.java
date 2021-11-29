package by.jwd.task01basic.view;

public class Output {

	/* show available menu to user */
	public void showMenu() {
		System.out.println("+++Task menu+++:\n" + "1 - Java linear tasks\n" + "2 - Java conditional tasks\n"
				+ "3 - Java loops tasks");
	}

	/* show list of tasks for each point of menu */

	public void showLinearTasks() {
		System.out.println("+++Linear tasks+++:\n" + "1 - Find average of two numbers\n"
				+ "2 - The width of rectangle is half the length. Find the area of a rectangle\n"
				+ "3 - Find the area of the equilateral triangle, its height, the radius of the inscribed and circumscribed circles\n"
				+ "4 - Calculate the distance traveled by the boat, if its speed in still water is V (km / h), the speed of the river is V1 (km / h), the time of movement on the river is T1 (h), and time against the stream of the river - T2 (h)++\");\n"
				+ "5 - Input any character and find its number designation, the previous and the next characters.");
	}

	public void showConditionalTasks() {
		System.out.println("+++Conditional tasks+++:\n" + "1 - Find min of two numbers a and b\n"
				+ "2 - Calculate absolute value of expression a*x*x + b*x + c\n"
				+ "3 - Count quantity of positive numbers among a,b,c\n"
				+ "4 - There are the measures of the rectangle and the measures of the brick (x,y,z).Does the brick fit the rectangle hole?\n"
				+ "5 - Only six users have access to the base by the password. They have the passwords as follows: 9583 and 1748 for acess to the basec A,B,C; 3331 and 7922 - for bases B,C; 9455 and 8997 - for base C. Input the password and find out your access to the secret base.");
	}

	public void showLoopTasks() {
		System.out.println("+++Loops tasks+++:\n"
				+ "1 - Calculate the sum of all odd numbers from 1 to 99 (including)\n"
				+ "2 - Find the value of function  y on the segment [a, b] with the step h: y = x, if x > 2 and y = -x, if x <= 2\n"
				+ "3 - There are given the number row and the number e. Find the sum of numbers, which absolute values equal to or more than the number e, where a = 1/2^n + 1/3^n\n"
				+ "4 - There are 5 random numbers in the range 1 - 15 including. Try to guess these numbers\n"
				+ "5 - Find max digit of the given natural number");
	}

	/* output message to user */
	public String print(String message) {
		System.out.println(message);
		return " ";
	}

	/* output responce to user */
	public String printResponce(String message, String result) {
		System.out.println(message + result);
		return " ";
	}
}