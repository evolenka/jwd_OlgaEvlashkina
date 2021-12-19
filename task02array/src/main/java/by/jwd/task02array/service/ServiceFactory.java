package by.jwd.task02array.service;

import by.jwd.task02array.service.impl.BubbleSortImpl;

import by.jwd.task02array.service.impl.ExternalSortService;
import by.jwd.task02array.service.impl.InsertionSortByAddressCalculationImpl;
import by.jwd.task02array.service.impl.InsertionSortImpl;
import by.jwd.task02array.service.impl.MatrixAdditionImpl;
import by.jwd.task02array.service.impl.MatrixMultiplicationImpl;
import by.jwd.task02array.service.impl.SelectionSortImpl;
import by.jwd.task02array.service.impl.ShakerSortImpl;
import by.jwd.task02array.service.impl.ShellSortImpl;
import by.jwd.task02array.service.impl.TwoWayMergeSortImpl;

public final class ServiceFactory {

	public static final ServiceFactory instance = new ServiceFactory();

	private ServiceFactory() {
	}

	private ArraySortingService<Integer> bubbleSort = new BubbleSortImpl();
	private ArraySortingService<Integer> insertionSort = new InsertionSortImpl();
	private ArraySortingService<Integer> selectionSort = new SelectionSortImpl();
	private ArraySortingService<Integer> shakerSort = new ShakerSortImpl();
	private ArraySortingService<Integer> shellSort = new ShellSortImpl();
	private ArraySortingService<Integer> mergeSort = new TwoWayMergeSortImpl();
	private ArraySortingService<Integer> insertionByAddressSort = new InsertionSortByAddressCalculationImpl();
	private ExternalSortService externalSort = new ExternalSortService();
	private MatrixOperationService<Integer> matrixMultiplication = new MatrixMultiplicationImpl();
	private MatrixOperationService<Integer> matrixAddition = new MatrixAdditionImpl();

	private ArrayCreator arrayCreator = new ArrayCreator();
	private MatrixCreator matrixCreator = new MatrixCreator();

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ArraySortingService<Integer> getBubbleSort() {
		return bubbleSort;
	}

	public ArraySortingService<Integer> getInsertionSort() {
		return insertionSort;
	}

	public ArraySortingService<Integer> getSelectionSort() {
		return selectionSort;
	}

	public ArraySortingService<Integer> getShakerSort() {
		return shakerSort;
	}

	public ArraySortingService<Integer> getShellSort() {
		return shellSort;
	}

	public ArraySortingService<Integer> getMergeSort() {
		return mergeSort;
	}

	public ArraySortingService<Integer> getInsertionByAddressSort() {
		return insertionByAddressSort;
	}

	public ExternalSortService getExternalSort() {
		return externalSort;
	}

	public MatrixOperationService<Integer> getMatrixMultiplication() {
		return matrixMultiplication;
	}

	public MatrixOperationService<Integer> getMatrixAddition() {
		return matrixAddition;
	}

	public ArrayCreator getArrayCreator() {
		return arrayCreator;
	}

	public MatrixCreator getMatrixCreator() {
		return matrixCreator;
	}

	public void setBubbleSort(ArraySortingService<Integer> bubbleSort) {
		this.bubbleSort = bubbleSort;
	}

	public void setInsertionSort(ArraySortingService<Integer> insertSort) {
		this.insertionSort = insertSort;
	}

	public void setSelectionSort(ArraySortingService<Integer> selectionSort) {
		this.selectionSort = selectionSort;
	}

	public void setShakerSort(ArraySortingService<Integer> shakerSort) {
		this.shakerSort = shakerSort;
	}

	public void setShellSort(ArraySortingService<Integer> shellSort) {
		this.shellSort = shellSort;
	}

	public void setMergeSort(ArraySortingService<Integer> mergeSort) {
		this.mergeSort = mergeSort;
	}

	public void setInsertionByAddressSort(ArraySortingService<Integer> insertionByAddressSort) {
		this.insertionByAddressSort = insertionByAddressSort;
	}

	public void setExternalSort(ExternalSortService externalSort) {
		this.externalSort = externalSort;
	}

	public void setMatrixMultiplication(MatrixOperationService<Integer> matrixMultiplication) {
		this.matrixMultiplication = matrixMultiplication;
	}

	public void setMatrixmatrixAddition(MatrixOperationService<Integer> matrixAddition) {
		this.matrixAddition = matrixAddition;
	}

	public void setArrayCreatorService(ArrayCreator arrayCreator) {
		this.arrayCreator = arrayCreator;
	}

	public void setArrayCreatorService(MatrixCreator matrixCreator) {
		this.matrixCreator = matrixCreator;
	}
}
