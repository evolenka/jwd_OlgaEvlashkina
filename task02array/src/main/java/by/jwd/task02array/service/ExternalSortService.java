package by.jwd.task02array.service;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.impl.ShakerSortImpl;

/**
 * External sorting of file
 * 
 * @author evlashkina
 * @version 1
 * @param fileName
 * @return void
 * @exception ServiceException
 * @throws ServiceException if the file not found, invalid data
 */

public class ExternalSortService {

	ArraySortingService<Integer> service = new ShakerSortImpl();

	static Logger logger = LogManager.getLogger(ExternalSortService.class);

	/*
	 * устанавливаем статическую переменную, ограничивающую количество символов,
	 * которое будем записывать в один файл
	 */
	private static final int FILELIMIT = 1000;

	public void sortArrayFromFile(String fileName) throws ServiceException {

		Array<Integer> array;
		FileWriter newFile = null;
		int nextNumber;
		List<File> fileList = new ArrayList<>();
		int quantityOfFiles = 0;

		try {
			URL res = getClass().getClassLoader().getResource(fileName);
			File file = Paths.get(res.toURI()).toFile();

			Scanner sc = new Scanner(file);
			/* внешний цикл для чтения файла до конца */

			while ((sc.hasNextInt())) {

				Integer[] a = new Integer[FILELIMIT];// создаем массив размером, соответствующим партии считываемых
														// символов
				array = new Array<>(a);
				int counter = 0;
				/*
				 * заполняем массив числами из файла, сортируем его методом внутренней
				 * сортировки
				 */
				for (int i = 0; i < FILELIMIT; i++) {
					if (sc.hasNextInt()) {
						nextNumber = sc.nextInt();
						array.setElement(i, nextNumber);
						counter++; // подсчитваем количество записанных символов
					}
				}
				/*
				 * создаем файл для записи отсортированной части под порядковым номером
				 * quantityOfFiles
				 */
				File sortedPartFile = new File("part" + quantityOfFiles + ".txt");
				newFile = new FileWriter(sortedPartFile);

				/*
				 * для последней части, в которой количество записанных символов будет меньше
				 * установленного лимита для файла отдельно создаем массив размером,
				 * соответствующим количеству символов, сортируем его и записываем в файл
				 */
				if (counter < FILELIMIT) {

					Integer[] last = new Integer[counter];
					Array<Integer> finalArray = new Array<>(last);

					for (int i = 0; i < counter; i++) {
						finalArray.setElement(i, array.getElement(i));
					}
					service.sortArray(finalArray);
					for (int i = 0; i < finalArray.getLength(); i++) {
						newFile.write(Integer.toString(finalArray.getElement(i)) + " ");
					}
					/*
					 * для всех остальных частей сортируем получившиеся массивы и записываем их в
					 * соответствующие файлы
					 */
				} else {
					service.sortArray(array);

					for (int i = 0; i < array.getLength(); i++) {
						newFile.write(Integer.toString(array.getElement(i)) + " ");
					}
				}
				/*
				 * добавляем каждый файл в список файлов, увеличиваем счетчик для количества
				 * файлов и закрываем этот файл
				 */
				fileList.add(sortedPartFile);
				quantityOfFiles++;
				newFile.close();
			}
			sc.close();// закрываем исходный внешний файл

			/*
			 * создаем список списков файлов, помещаем в него наш первый список с
			 * файлами-отсортированными частями
			 */

			List<List<File>> listOfFileList = new ArrayList<>();
			listOfFileList.add((fileList));

			int numberOfTempFile = 1;// счетчик для имени файлов, которые будуь получаться при слиянии двух файлов

			int i = 0;// счетчик для количества циклов, в которых сливаются файлы текущего списка

			/*
			 * внешний цикл: продолжаем пока в последнем списке, в который помещаются файлы
			 * после слияния, не окажется только один файл/*
			 */

			while (listOfFileList.get(i).size() > 1) {

				/*
				 * создаем новый список для помещения файлов, которые получились от предыдущего
				 * цикла слияния
				 */

				List<File> newFileList = new ArrayList<>();
				listOfFileList.add((newFileList));

				/* случай, когда количество отсортированных файлов в текущем списке четное */
				if ((listOfFileList.get(i).size()) % 2 == 0) {

					for (int j = 0; j <= listOfFileList.get(i).size() - 2; j += 2) {

						/* сливаем поочередно каждые два файла с помощью метода sortTwoFiles */

						File tempFile1 = listOfFileList.get(i).get(j);
						File tempFile2 = listOfFileList.get(i).get(j + 1);
						File tempSortedFile = sortTwoFiles(tempFile1, tempFile2, numberOfTempFile);

						numberOfTempFile++;// увеличиваем счетчик файлов - результатов-слияний

						/* помещаем результат каждого слияния в новый созданные список */
						listOfFileList.get(i + 1).add(tempSortedFile);
					}

					/*
					 * случай, когда количество отсортированных файлов-частей в текущем списке
					 * нечетное
					 */
				} else {
					for (int j = 0; j <= listOfFileList.get(i).size() - 3; j += 2) {

						File tempFile1 = listOfFileList.get(i).get(j);
						File tempFile2 = listOfFileList.get(i).get(j + 1);
						File tempSortedFile = sortTwoFiles(tempFile1, tempFile2, numberOfTempFile);

						numberOfTempFile++;

						listOfFileList.get(i + 1).add(tempSortedFile);
					}
					/*
					 * помещаем оставшийся файл, для которого не было пары в текущем списке, в
					 * следующий новый список вместе с файлами-результатами слияния этого цикла
					 */

					listOfFileList.get(i + 1).add(listOfFileList.get(i).get(listOfFileList.get(i).size() - 1));
				}
				i++;// переходим к следующему циклу слияний

			}
		} catch (ArrayException | URISyntaxException | IOException e) {
			throw new ServiceException();
		}
	}

	/* метод для слияния двух отсортированных файлов в один отсортированный файл */

	public File sortTwoFiles(File file1, File file2, int n) throws ServiceException {
		try {

			Scanner sc1 = new Scanner(file1);
			Scanner sc2 = new Scanner(file2);

			FileWriter newFile;
			File resultFile = new File("tempFile" + n + ".txt");
			newFile = new FileWriter(resultFile);

			int nextFromFile1 = sc1.nextInt();
			int nextFromFile2 = sc2.nextInt();

			/*
			 * сортируем цифры из файлов, записывая их в новый файл, пока они не закончатся
			 * в одном из файле
			 */
			while ((sc1.hasNextInt()) && (sc2.hasNextInt())) {

				if (nextFromFile1 < nextFromFile2) {
					newFile.write(Integer.toString(nextFromFile1) + " ");
					nextFromFile1 = sc1.nextInt();
				}

				else {
					newFile.write(Integer.toString(nextFromFile2) + " ");
					nextFromFile2 = sc2.nextInt();
				}
			}

			/*
			 * последнее число в одном из файлов осталась в переменной; чтобы записать его в
			 * файл, сравниваем ее с оставшимися числами из другого файла до тех пор пока не
			 * встретим число, которое больше после этого k = 1, далее просто вставляем
			 * оставшиеся числа одного из файлов
			 */

			int k = 0;
			if (sc1.hasNextInt()) {
				while (sc1.hasNextInt()) {
					if (nextFromFile2 <= nextFromFile1 && k == 0) {
						newFile.write(Integer.toString(nextFromFile2) + " ");
						k++;
					} else {
						newFile.write(Integer.toString(nextFromFile1) + " ");
						nextFromFile1 = sc1.nextInt();
					}
				}
				newFile.write(Integer.toString(nextFromFile1) + " ");
			} else if (sc2.hasNextInt()) {
				while (sc2.hasNextInt()) {
					if (nextFromFile1 <= nextFromFile2 && k == 0) {
						newFile.write(Integer.toString(nextFromFile1) + " ");
						k++;
					} else {
						newFile.write(Integer.toString(nextFromFile2) + " ");
						nextFromFile2 = sc2.nextInt();
					}
				}
				newFile.write(Integer.toString(nextFromFile2) + " ");
			}
			sc1.close();
			sc2.close();
			newFile.close();

			return resultFile;
		} catch (IOException e) {
			throw new ServiceException();
		}
	}
}