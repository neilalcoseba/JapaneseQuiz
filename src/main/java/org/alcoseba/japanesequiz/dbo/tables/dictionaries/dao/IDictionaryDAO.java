package org.alcoseba.japanesequiz.dbo.tables.dictionaries.dao;

import org.alcoseba.japanesequiz.dbo.tables.dictionaries.Dictionary;

public interface IDictionaryDAO {
	Dictionary getByName(String name);

	int save(Dictionary dictionary);
}
