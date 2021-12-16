package by.jwd.task02array.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import by.jwd.task02array.entity.Array;
import by.jwd.task02array.entity.ArrayException;
import by.jwd.task02array.service.ArrayService;
import by.jwd.task02array.service.ServiceException;

public class ExternalSortService {
	
	public void sortArrayFromFile (File file) throws ServiceException {
	
	ArrayService <Integer> bubblesort = new BubbleSortImpl ();
	
	Array <Integer> array;
	Array <Integer> sortedArray;

	BufferedReader br = null;
	FileWriter newFile = null;
	String str = null;
	String[] param = null;

	try {
		br = new BufferedReader(new FileReader(file));

		while ((str = br.readLine()) != null) {
			param = str.split(",");
		}

		if (param != null) {
			array = new Array<>(param.length);
			for (int i = 0; i < array.getLength(); i++) {
				array.setElement(i, Integer.parseInt(param[i]));
			}
		
			int n =1;
			newFile = new FileWriter (new File ("file" + n +".txt"));
			sortedArray = bubblesort.sortArray(array);
			for (int i = 0; i < sortedArray.getLength(); i++) {
				
				newFile.write (sortedArray.getElement(i));
			}	
		}
			
	} catch (NumberFormatException | ArrayException | IOException |ServiceException e) {
		throw new ServiceException();
	} finally {

		try {
			if (br != null) {
				br.close();
			}
			if (newFile != null) {
				newFile.close();
			}
		} catch (IOException e) {
			throw new ServiceException();
		}
	}
	}
}