package by.jwd.task02array.service;

import by.jwd.task02array.service.impl.BubbleSortImpl;
import by.jwd.task02array.service.impl.ExternalSortService;
import by.jwd.task02array.service.impl.InsertionSortByAddressCalculationImpl;
import by.jwd.task02array.service.impl.InsertionSortImpl;
import by.jwd.task02array.service.impl.SelectionSortImpl;
import by.jwd.task02array.service.impl.ShakerSortImpl;
import by.jwd.task02array.service.impl.ShellSortImpl;
import by.jwd.task02array.service.impl.TwoWayMergeSortImpl;

public final class ServiceFactory {

	public static final ServiceFactory instance = new ServiceFactory();

	private ServiceFactory() {
	}

	private ArrayService<Integer> bubbleSort = new BubbleSortImpl();
	private ArrayService<Integer> insertionSort = new InsertionSortImpl();
	private ArrayService<Integer> selectionSort = new SelectionSortImpl();
	private ArrayService<Integer> shakerSort = new ShakerSortImpl();
	private ArrayService<Integer> shellSort = new ShellSortImpl();
	private ArrayService<Integer> mergeSort = new TwoWayMergeSortImpl();
	private ArrayService<Integer> insertionByAddressSort = new InsertionSortByAddressCalculationImpl();
	private ExternalSortService externalSort = new ExternalSortService();

	private MatrixService<Integer> matrixService;

	private ArrayCreatorService arrayCreator = new ArrayCreatorService();

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ArrayService<Integer> getBubbleSort() {
		return bubbleSort;
	}

	public ArrayService<Integer> getInsertionSort() {
		return insertionSort;
	}

	public ArrayService<Integer> getSelectionSort() {
		return selectionSort;
	}

	public ArrayService<Integer> getShakerSort() {
		return shakerSort;
	}

	public ArrayService<Integer> getShellSort() {
		return shellSort;
	}

	public ArrayService<Integer> getMergeSort() {
		return mergeSort;
	}
	
	public ArrayService<Integer> getInsertionByAddressSort() {
		return insertionByAddressSort;
	}
	
	public ExternalSortService getExternalSort() {
		return externalSort;
	}

	public MatrixService<Integer> getMatrix() {
		return matrixService;
	}

	public ArrayCreatorService getArrayCreator() {
		return arrayCreator;
	}
	
	public void setBubbleSort(ArrayService<Integer> bubbleSort) {
		this.bubbleSort = bubbleSort;
	}

	public void setInsertionSort(ArrayService<Integer> insertSort) {
		this.insertionSort = insertSort;
	}

	public void setSelectionSort(ArrayService<Integer> selectionSort) {
		this.selectionSort = selectionSort;
	}

	public void setShakerSort(ArrayService<Integer> shakerSort) {
		this.shakerSort = shakerSort;
	}

	public void setShellSort(ArrayService<Integer> shellSort) {
		this.shellSort = shellSort;
	}
	
	public void setMergeSort(ArrayService<Integer> mergeSort) {
		this.mergeSort = mergeSort;
	}

	public void setInsertionByAddressSort(ArrayService<Integer> insertionByAddressSort) {
		this.insertionByAddressSort = insertionByAddressSort;
	}
	
	public void setExternalSort(ExternalSortService externalSort) {
		this.externalSort = externalSort;
	}

	public void setMatrixService(MatrixService<Integer> matrixService) {
		this.matrixService = matrixService;
	}

	public void setArrayCreatorService(ArrayCreatorService arrayCreator) {
		this.arrayCreator = arrayCreator;
	}
}
