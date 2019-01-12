package org.alcoseba.japanesequiz;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.SQLException;

public class App {
	public static void main(String[] args) throws SQLException {
		try {
			Reader in = new FileReader("path/to/file.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
