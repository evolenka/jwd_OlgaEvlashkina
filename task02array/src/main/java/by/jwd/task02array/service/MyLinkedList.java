package by.jwd.task02array.service;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;

/* класс для создания связанных списков, используемых в сортировке вставками с вычислением адреса*/

public class MyLinkedList {

	private Node head = null;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}
/* метод для вставки элементов в связанный список в отсортированном порядке*/
	
	public void insert(int value) {
		Node newnode = new Node(value);
		Node current;

		/*
		 * вставка на первое место в список, когда он еще пуст, или первый элемент
		 * больше вставляемого
		 */
		if (head == null || head.value >= newnode.value) {
			newnode.next = head;
			head = newnode;
		}

		/* вставляем элемент перед текущей позицией вставки */
		else {
			current = head;
			while ((current.next != null) && (current.next.value < newnode.value)) {

				current = current.next;
			}

			newnode.next = current.next;
			current.next = newnode;
		}
	}
	
	/*вспомогательный метод для передачи элементов из связанного списка в массив*/

	public static void passToArray(Array<Integer> array, MyLinkedList[] list) throws ServiceException {
		try {
			int index = 0;

			for (int i = 0; i < list.length; i++) {
				Node current = list[i].head;

				while (current != null) {
					array.setElement(index, current.value);
					index++;
					current = current.next;
				}
			}
		} catch (ArrayException e) {
			throw new ServiceException();
		}
	}
}