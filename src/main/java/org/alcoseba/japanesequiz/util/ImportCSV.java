package org.alcoseba.japanesequiz.util;

import java.io.File;

import org.alcoseba.japanesequiz.util.csv.ICSVParser;
import org.apache.commons.csv.CSVRecord;

public class ImportCSV {
	private ICSVParser csvParser;

	public ImportCSV(ICSVParser csvParser) {
		this.csvParser = csvParser;
	}

	public void doImport(File csvFile) {
		CSVRecord[] csvRecords = this.csvParser.parse(csvFile);
		
		for (CSVRecord csvRecord : csvRecords) {
			String japanese = csvRecord.get(0);
			String english = csvRecord.get(1);
		}
	}
}
