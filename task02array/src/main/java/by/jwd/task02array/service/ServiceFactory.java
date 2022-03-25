package by.jwd.task02array.service;

import by.jwd.task02array.service.impl.BubbleSortImpl;
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

	private ArraySortingService bubbleSort = new BubbleSortImpl();
	private ArraySortingService insertionSort = new InsertionSortImpl();
	private ArraySortingService selectionSort = new SelectionSortImpl();
	private ArraySortingService shakerSort = new ShakerSortImpl();
	private ArraySortingService shellSort = new ShellSortImpl();
	private ArraySortingService mergeSort = new TwoWayMergeSortImpl();
	private ArraySortingService insertionByAddressSort = new InsertionSortByAddressCalculationImpl();
	private ExternalSortService externalSort = new ExternalSortService();
	private MatrixOperationService matrixMultiplication = new MatrixMultiplicationImpl();
	private MatrixOperationService matrixAddition = new MatrixAdditionImpl();

	private ArrayCreator arrayCreator = new ArrayCreator();
	private MatrixCreator matrixCreator = new MatrixCreator();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ArraySortingService getBubbleSort() {
		return bubbleSort;
	}

	public ArraySortingService getInsertionSort() {
		return insertionSort;
	}

	public ArraySortingService getSelectionSort() {
		return selectionSort;
	}

	public ArraySortingService getShakerSort() {
		return shakerSort;
	}

	public ArraySortingService getShellSort() {
		return shellSort;
	}

	public ArraySortingService getMergeSort() {
		return mergeSort;
	}

	public ArraySortingService getInsertionByAddressSort() {
		return insertionByAddressSort;
	}

	public ExternalSortService getExternalSort() {
		return externalSort;
	}

	public MatrixOperationService getMatrixMultiplication() {
		return matrixMultiplication;
	}

	public MatrixOperationService getMatrixAddition() {
		return matrixAddition;
	}

	public ArrayCreator getArrayCreator() {
		return arrayCreator;
	}

	public MatrixCreator getMatrixCreator() {
		return matrixCreator;
	}

	public void setBubbleSort(ArraySortingService bubbleSort) {
		this.bubbleSort = bubbleSort;
	}

	public void setInsertionSort(ArraySortingService insertSort) {
		this.insertionSort = insertSort;
	}

	public void setSelectionSort(ArraySortingService selectionSort) {
		this.selectionSort = selectionSort;
	}

	public void setShakerSort(ArraySortingService shakerSort) {
		this.shakerSort = shakerSort;
	}

	public void setShellSort(ArraySortingService shellSort) {
		this.shellSort = shellSort;
	}

	public void setMergeSort(ArraySortingService mergeSort) {
		this.mergeSort = mergeSort;
	}

	public void setInsertionByAddressSort(ArraySortingService insertionByAddressSort) {
		this.insertionByAddressSort = insertionByAddressSort;
	}

	public void setExternalSort(ExternalSortService externalSort) {
		this.externalSort = externalSort;
	}

	public void setMatrixMultiplication(MatrixOperationService matrixMultiplication) {
		this.matrixMultiplication = matrixMultiplication;
	}

	public void setMatrixmatrixAddition(MatrixOperationService matrixAddition) {
		this.matrixAddition = matrixAddition;
	}

	public void setArrayCreatorService(ArrayCreator arrayCreator) {
		this.arrayCreator = arrayCreator;
	}

	public void setArrayCreatorService(MatrixCreator matrixCreator) {
		this.matrixCreator = matrixCreator;
	}
}
