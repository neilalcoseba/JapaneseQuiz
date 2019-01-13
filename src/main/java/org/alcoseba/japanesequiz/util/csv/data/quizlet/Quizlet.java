package org.alcoseba.japanesequiz.util.csv.data.quizlet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.stream.StreamSupport;

import org.alcoseba.japanesequiz.util.csv.ICSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Quizlet implements ICSVParser {

	@Override
	public CSVRecord[] parse(File csvFile) {
		Iterable<CSVRecord> records = null;

		try {
			try (Reader in = new FileReader(csvFile)) {
				records = CSVFormat.EXCEL.parse(in);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return StreamSupport.stream(records.spliterator(), false).toArray(CSVRecord[]::new);
	}
}
