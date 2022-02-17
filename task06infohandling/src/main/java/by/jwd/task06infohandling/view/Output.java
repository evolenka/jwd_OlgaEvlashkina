package by.jwd.task06infohandling.view;

import java.util.List;

import by.jwd.task06infohandling.entity.Component;

public class Output {

	public void print(String message) {
		System.out.println(message);
	}

	public void print(List<Component> result) {
		for (Component component : result) {
			System.out.println(component);
		}
	}
}