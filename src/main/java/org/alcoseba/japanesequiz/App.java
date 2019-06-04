package org.alcoseba.japanesequiz;

import java.io.File;
import java.sql.SQLException;

import org.alcoseba.japanesequiz.dbo.conn.IConnection;
import org.alcoseba.japanesequiz.dbo.conn.impl.JDBCConnection;
import org.alcoseba.japanesequiz.dbo.tables.dictionaries.Dictionary;
import org.alcoseba.japanesequiz.dbo.tables.dictionaries.dao.IDictionaryDAO;
import org.alcoseba.japanesequiz.dbo.tables.dictionaries.dao.impl.JDBCDictionaryDAO;
import org.alcoseba.japanesequiz.util.ImageGenerator;

public class App {
	public static void main(String[] args) throws SQLException {
		/*
		 * File csvFile = new File("D:\\temp\\lesson3.csv");
		 * 
		 * ImportCSV importCSV = new ImportCSV(new Quizlet(), new JDBCConnection());
		 * importCSV.doImport(csvFile);
		 */

		IConnection connection = new JDBCConnection();
		IDictionaryDAO dictionaryDAO = new JDBCDictionaryDAO(connection);
		Dictionary[] dictionaries = dictionaryDAO.getAll();
		int length = dictionaries != null ? dictionaries.length : 0;
		File outputDir = new File("d:/temp/lesson3");

		for (int i = 0; i < length; i++) {
			File image = new File(outputDir, "card_"+(i + 1)+".jpg");
			Dictionary dictionary = dictionaries[i];
			String kana = dictionary.getNameJP();
			String kanji = dictionary.getNameJPKanji();

			if (kanji == null || kanji.trim().isEmpty()) {
				kanji = kana;
				kana = "";
			}
			
			ImageGenerator imageGenerator = new ImageGenerator(image);
			imageGenerator.generate(kana, kanji);
		}
	}
}
