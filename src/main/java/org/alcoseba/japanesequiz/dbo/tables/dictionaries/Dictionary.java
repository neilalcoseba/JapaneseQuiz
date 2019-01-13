package org.alcoseba.japanesequiz.dbo.tables.dictionaries;

import lombok.Getter;
import lombok.Setter;

public class Dictionary {
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String nameJP;

	@Getter
	@Setter
	private String nameJPKanji;
}
