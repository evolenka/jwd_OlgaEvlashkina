package by.jwd.task05thread.service;

import by.jwd.task05thread.entity.Array;
import by.jwd.task05thread.entity.ArrayException;

/* класс для создания связанных списков, используемых в сортировке вставками с вычислением адреса*/

public class MyLinkedList<T extends Comparable<T>> {

	private Node<T> head = null;

	class Node<E extends T> {
		E value;
		Node<E> next;

		Node(E value) {
			this.value = value;
		}
	}
	/* метод для вставки элементов в связанный список в отсортированном порядке */

	public void insert(T value) {
		Node<T> newnode = new Node<>(value);
		Node<T> current;

		/*
		 * вставка на первое место в список, когда он еще пуст, или первый элемент
		 * больше вставляемого
		 */
		if (head == null || head.value.compareTo(newnode.value) >= 0) {
			newnode.next = head;
			head = newnode;
		}

		/* вставляем элемент перед текущей позицией вставки */
		else {
			current = head;
			while ((current.next != null) && (current.next.value.compareTo(newnode.value) < 0)) {

				current = current.next;
			}

			newnode.next = current.next;
			current.next = newnode;
		}
	}

	/* вспомогательный метод для передачи элементов из связанного списка в массив */

	public void passToArray(Array<T> array, MyLinkedList<? extends T>[] list) throws ServiceException {
		try {
			int index = 0;

			for (int i = 0; i < list.length; i++) {
				MyLinkedList<? extends T>.Node<? extends T> current = list[i].head;

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