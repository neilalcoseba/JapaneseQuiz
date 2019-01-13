package org.alcoseba.japanesequiz.csv;

import java.io.File;

import org.apache.commons.csv.CSVRecord;

public interface ICSVParser {
	CSVRecord[] parse(File csvFile);
}
