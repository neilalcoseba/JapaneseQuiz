package org.alcoseba.japanesequiz;

import java.io.File;
import java.sql.SQLException;

import org.alcoseba.japanesequiz.csv.parser.quizlet.Quizlet;
import org.alcoseba.japanesequiz.dbo.conn.impl.JDBCConnection;
import org.alcoseba.japanesequiz.util.ImportCSV;

public class App {
	public static void main(String[] args) throws SQLException {
		File csvFile = new File("/home/neil/temp/lesson4.csv");

		ImportCSV importCSV = new ImportCSV(new Quizlet(), new JDBCConnection());
		importCSV.doImport(csvFile);
	}
}
