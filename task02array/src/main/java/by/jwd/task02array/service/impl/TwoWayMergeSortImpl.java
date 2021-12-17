package by.jwd.task02array.service.impl;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArraySortingService;
import by.jwd.task02array.service.ServiceException;

public class TwoWayMergeSortImpl implements ArraySortingService<Integer> {

	@Override
	public Array<Integer> sortArray(Array<Integer> array) throws ServiceException {

		mergeSort(array, 0, array.getLength() - 1);
		return array;

	}

	public void mergeSort(Array<Integer> array, int l, int r) throws ServiceException {
		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			mergeSort(array, l, m);
			mergeSort(array, m + 1, r);

			// Merge the sorted halves
			merge(array, l, m, r);
		}
	}

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	public void merge(Array<Integer> array, int l, int m, int r) throws ServiceException {
		try {
			// Find sizes of two subarrays to be merged
			int n1 = m - l + 1;
			int n2 = r - m;

			/* Create temp arrays */
			int L[] = new int[n1];
			int R[] = new int[n2];

			/* Copy data to temp arrays */
			for (int i = 0; i < n1; ++i)
				L[i] = array.getElement(l + i);
			for (int j = 0; j < n2; ++j)
				R[j] = array.getElement(m + 1 + j);

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarray array
			int k = l;
			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					array.setElement(k, L[i]);
					i++;
				} else {
					array.setElement(k, R[j]);
					j++;
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				array.setElement(k, L[i]);
				i++;
				k++;
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				array.setElement(k, R[j]);
				j++;
				k++;
			}
		} catch (ArrayException e) {
			throw new ServiceException(e);
		}
	}
}