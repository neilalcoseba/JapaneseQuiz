package org.alcoseba.japanesequiz.util;

import java.io.File;

import org.alcoseba.japanesequiz.csv.ICSVParser;
import org.alcoseba.japanesequiz.dbo.conn.IConnection;
import org.alcoseba.japanesequiz.dbo.tables.dictionaries.Dictionary;
import org.alcoseba.japanesequiz.dbo.tables.dictionaries.dao.IDictionaryDAO;
import org.alcoseba.japanesequiz.dbo.tables.dictionaries.dao.impl.JDBCDictionaryDAO;
import org.apache.commons.csv.CSVRecord;

public class ImportCSV {
	private ICSVParser csvParser;
	private IConnection connection;

	public ImportCSV(ICSVParser csvParser, IConnection connection) {
		this.csvParser = csvParser;
		this.connection = connection;
	}

	public void doImport(File csvFile) {
		CSVRecord[] csvRecords = this.csvParser.parse(csvFile);
		IDictionaryDAO dictionaryDAO = new JDBCDictionaryDAO(connection);

		for (CSVRecord csvRecord : csvRecords) {
			String japanese = csvRecord.get(0);
			String nameEN = csvRecord.get(1);
			Dictionary dictionary = dictionaryDAO.getByName(nameEN);

			if (dictionary == null) {
				dictionary = new Dictionary();
				dictionary.setName(nameEN);
				dictionary.setNameJP(japanese);
				int result = dictionaryDAO.save(dictionary);
				System.out.println("Name : " + nameEN + " ; Result : " + result);
			} else {
				System.out.println("Name : " + nameEN + " already saved");
			}
		}
	}
}
