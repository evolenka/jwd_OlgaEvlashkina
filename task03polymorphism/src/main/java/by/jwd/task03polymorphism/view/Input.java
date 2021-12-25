package by.jwd.task03polymorphism.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

	/* read data inputed by user */

	public String read() throws IOException {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str;
			str = br.readLine();
			return str;
		} catch (IOException e) {
			throw new IOException(e);
		}
	}
}