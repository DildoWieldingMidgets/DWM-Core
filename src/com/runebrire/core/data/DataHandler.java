package com.runebrire.core.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataHandler {
	private Connection _c;
	private MySQL _sql;

	public DataHandler(Connection c) {
		_c = c;
	}

	public ResultSet querySQL(String query) {
		Connection c = _c;
		Statement s = null;

		try {
			s = c.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		ResultSet ret = null;

		try {
			ret = s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public void updateSQL(String update) {
		Connection c = _c;
		Statement s = null;

		try {
			s = c.createStatement();
			s.executeUpdate(update);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
