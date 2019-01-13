package org.alcoseba.japanesequiz;

import java.io.File;
import java.sql.SQLException;

import org.alcoseba.japanesequiz.util.ImportCSV;
import org.alcoseba.japanesequiz.util.csv.data.quizlet.Quizlet;

public class App {
	public static void main(String[] args) throws SQLException {
		File csvFile = new File("/home/neil/temp/lesson3.csv");

		ImportCSV importCSV = new ImportCSV(new Quizlet());
		importCSV.doImport(csvFile);
	}
}
