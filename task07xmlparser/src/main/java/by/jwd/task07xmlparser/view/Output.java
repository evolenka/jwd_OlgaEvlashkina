package by.jwd.task07xmlparser.view;

import java.util.Set;

import by.jwd.task07xmlparser.entity.Visit;


public class Output {

	public void print(String message) {
		System.out.println(message);
	}
	public void print(Set <Visit> visits) {
		System.out.println(visits.toString());
	}
}