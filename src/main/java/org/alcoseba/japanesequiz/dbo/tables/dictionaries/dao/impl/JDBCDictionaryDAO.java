package org.alcoseba.japanesequiz.dbo.tables.dictionaries.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.alcoseba.japanesequiz.dbo.conn.IConnection;
import org.alcoseba.japanesequiz.dbo.tables.dictionaries.Dictionary;
import org.alcoseba.japanesequiz.dbo.tables.dictionaries.dao.IDictionaryDAO;

public class JDBCDictionaryDAO implements IDictionaryDAO {

	private IConnection connection;

	public JDBCDictionaryDAO(IConnection connection) {
		this.connection = connection;
	}

	@Override
	public Dictionary getByName(String name) {
		Dictionary dictionary = null;

		try (Connection conn = this.connection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select ID, NAME, NAME_JP, NAME_JP_KANJI from DICTIONARIES where NAME = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt("ID");
			String nameJP = rs.getString("NAME_JP");
			String nameJPKanji = rs.getString("NAME_JP_KANJI");

			dictionary = new Dictionary();
			dictionary.setId(id);
			dictionary.setName(name);
			dictionary.setNameJP(nameJP);
			dictionary.setNameJPKanji(nameJPKanji);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dictionary;
	}

	@Override
	public int save(Dictionary dictionary) {
		int result = 0;

		try (Connection conn = this.connection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into DICTIONARIES(NAME,NAME_JP,NAME_JP_KANJI) VALUES(?,?,?)");
			ps.setString(1, dictionary.getName());
			ps.setString(2, dictionary.getNameJP());
			ps.setString(3, dictionary.getNameJPKanji());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
