package org.alcoseba.japanesequiz.csv.parser.quizlet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.stream.StreamSupport;

import org.alcoseba.japanesequiz.csv.ICSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Quizlet implements ICSVParser {

	@Override
	public CSVRecord[] parse(File csvFile) {
		CSVRecord[] records = null;

		try {
			try (Reader in = new FileReader(csvFile)) {
				records = StreamSupport.stream(CSVFormat.EXCEL.parse(in).spliterator(), false).toArray(CSVRecord[]::new);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return records;
	}
}
