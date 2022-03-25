package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;

/**
 * Two way merge sorting of array
 * 
 * @author evlashkina
 * @version 1
 * @param array
 * @return <T extends Comparable<T>> Array<T>
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

public class TwoWayMergeSortImpl implements ArraySortingService {

	@Override
	public <T extends Comparable<T>> Array<T> sortArray(Array<T> array) throws ServiceException {

		mergeSort(array, 0, array.getLength() - 1);
		return array;
	}

	public <T extends Comparable<T>> void mergeSort(Array<T> array, int first, int last) throws ServiceException {
		if (first < last) {
			// Find the middle point
			int middle = first + (last - first) / 2;

			// Sort first and second halves
			mergeSort(array, first, middle);
			mergeSort(array, middle + 1, last);

			// Merge the sorted halves
			merge(array, first, middle, last);
		}
	}

	/*
	 * Merges two subarrays of arr[first..middle..last]. First subarray is
	 * arr[first..middle]. Second subarray is arr[middle+1..last]
	 */

	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void merge(Array<T> array, int first, int middle, int last) throws ServiceException {
		try {

			/* Find sizes of two subarrays to be merged */
			int n1 = middle - first + 1;
			int n2 = last - middle;

			/* Create temp arrays */
			T [] firstTempArray =  (T[]) new Integer [n1];
			T [] secondTempArray=  (T[]) new Integer [n2];

			/* Copy data to temp arrays */
			for (int i = 0; i < n1; ++i)
				firstTempArray[i] = array.getElement(first + i);
			for (int j = 0; j < n2; ++j)
				secondTempArray[j] =  array.getElement(middle + 1 + j);

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0;
			int j = 0;

			// Initial index of merged subarray array
			int k = first;
			while (i < n1 && j < n2) {

				if (firstTempArray[i].compareTo(secondTempArray[j]) > 0) {
					array.setElement(k, secondTempArray[j]);
					j++;
				} else {
					array.setElement(k, firstTempArray[i]);
					i++;
				}
				k++;
			}

			/* Copy remaining elements of firstTempArray[] if any */
			while (i < n1) {
				array.setElement(k, firstTempArray[i]);
				i++;
				k++;
			}

			/* Copy remaining elements of secondTempArray[] if any */
			while (j < n2) {
				array.setElement(k, secondTempArray[j]);
				j++;
				k++;
			}
		} catch (ArrayException e) {
			throw new ServiceException(e);
		}
	}
}