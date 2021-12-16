package by.jwd.task02array.service;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;

public class MyLinkedList {

	private Node head = null;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public void insert(int value) {
		Node newnode = new Node(value);
		Node current;

		/* Special case for the head end */
		if (head == null || head.value >= newnode.value) {
			newnode.next = head;
			head = newnode;
		}

		else {
			current = head;
			/* Locate the node before the point of insertion */
			while ((current.next != null) && (current.next.value < newnode.value)) {

				current = current.next;
			}

			newnode.next = current.next;
			current.next = newnode;
		}
	}

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