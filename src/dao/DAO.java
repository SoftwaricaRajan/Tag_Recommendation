package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO extends DB{

	/**
	 * Databasename: entagrec
	 * user: root (change it in constructor below
	 * psw: root(change is in constructor below)
	 */
	Connection con = null;
	Statement stm = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	String user = null;
	String psw = null;

	public void con() throws ClassNotFoundException, SQLException {
		con = getDBConnection();
		stm = con.createStatement();
	}

	public boolean search(ArrayList<String> wordList) throws SQLException {
		String querystmt = "";

		// gernerating dynamic query
		for (int i = 0; i < wordList.size() - 1; i++) {
			querystmt = querystmt.concat("token LIKE '" + wordList.get(i) + "' OR ");
		}
		querystmt = querystmt.concat("token  LIKE '" + wordList.get(wordList.size() - 1) + "'");

		String query = "select token_id from tokens where " + querystmt + "ORDER BY token";
		rs = stm.executeQuery(query);
		return rs.next();
	}

	public int[] getIndexArray() throws SQLException {
		// to get the no. of items in resultset
		rs.last();
		int index[] = new int[rs.getRow()];
		rs.beforeFirst();

		int i = 0;
		while (rs.next()) {
			index[i++] = Integer.parseInt(rs.getString("token_id"));
		}
		return index;
	}

	public void closeCon() throws SQLException {
		rs.close();
		stm.close();
		con.close();
	}
}
