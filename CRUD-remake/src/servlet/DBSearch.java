package servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import utilities.StringUtils;

public class DBSearch {
	private static final int OPT_NAME 		= 0;
	private static final int OPT_SURNAME 	= 1;
	private static final int OPT_BIRTH 		= 2;
	private static final int OPT_AGE 		= 3;
	private static final int OPT_TYPE 		= 4;

	public static List<User> search(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int lowerAgeBound = 0, upperAgeBound = 150;
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		Date lowerBdBound = Date.valueOf(request.getParameter("lowerBdBound"));
		Date upperBdBound = Date.valueOf(request.getParameter("upperBdBound"));
		
		try {
			lowerAgeBound = Integer.parseInt(request.getParameter("lowerAgeBound"));
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		try {
			upperAgeBound = Integer.parseInt(request.getParameter("upperAgeBound"));
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		String type = request.getParameter("type");
		
		return search(name, surname, lowerBdBound, upperBdBound, lowerAgeBound, upperAgeBound, type);
	}
	
	public static List<User> search(String name, String surname, Date lowerBdBound, Date upperBdBound, int lowerAgeBound,
			int upperAgeBound, String type) throws SQLException {
//		List<JSONObject> jsons = null;
		
		//
		List<User> users = innerSearch(name, surname, lowerBdBound, upperBdBound, lowerAgeBound, upperAgeBound, type);
		/*/
		ResultSet rs = innerSearch(name, surname, lowerBdBound, upperBdBound, lowerAgeBound, upperAgeBound, type);
		List<User> users = resultsetToUsers(rs);
		//*/
		return users;
//		jsons = JsonConverter.usersToJson(users);
		
//		return jsons;
	}
	
	public static String getSqlString(String name, String surname, Date lowerBdBound, Date upperBdBound, int lowerAgeBound,
			int upperAgeBound, String type, boolean[] options) {
		
		boolean first = true;
		
		
		String sql = "SELECT id, name, surname, birthdate, creationTimeStamp, age, type FROM crud_users WHERE ";
		
		if (!StringUtils.isNullOrWhiteSpace(name)) {
			if(!first)
				sql += "AND ";
			sql += "name = ? ";
			options[OPT_NAME] = true;
			first = false;
		}
		
		if (!StringUtils.isNullOrWhiteSpace(surname)) {
			if(!first)
				sql += "AND ";
			sql += "surname = ? ";
			options[OPT_SURNAME] = true;
			first = false;
		}
		
		if (lowerBdBound != null || upperBdBound != null) {
			if(!first)
				sql += "AND ";
			sql += "birthdate BETWEEN ? AND ? ";
			options[OPT_BIRTH] = true;
			first = false;
			
			if(lowerBdBound == null)
				lowerBdBound = Date.valueOf("1970-01-01");
			if(upperBdBound == null)
				upperBdBound = Date.valueOf("2500-12-31");
		}
		
		if (lowerAgeBound > -1 && upperAgeBound > -1) {
			if(!first)
				sql += "AND ";
			sql += "age BETWEEN ? AND ? ";
			options[OPT_AGE] = true;
			first = false;
		}
		
		if (!StringUtils.isNullOrWhiteSpace(type)) {
			if(!first)
				sql += "AND ";
			sql += "type = ? ";
			options[OPT_TYPE] = true;
			first = false;
		}
		
		return sql;
	}
	
	private static List<User> innerSearch(String name, String surname, Date lowerBdBound, Date upperBdBound, int lowerAgeBound,
			int upperAgeBound, String type) throws SQLException {
		
		boolean[] options = {false, false, false, false, false};
		int i = 1;
		
		String sql = getSqlString(name, surname, lowerBdBound, upperBdBound, lowerAgeBound, upperAgeBound, type, options);
		
		Connection conn = ConnHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		
		if (options[OPT_NAME]) {
			statement.setString(i, name);
			i++;
		}
		
		if (options[OPT_SURNAME]) {
			statement.setString(i, surname);
			i++;
		}
		
		if (options[OPT_BIRTH]) {
			statement.setDate(i, lowerBdBound);
			i++;
			statement.setDate(i, upperBdBound);
			i++;
		}
		
		if (options[OPT_AGE]) {
			statement.setInt(i, lowerAgeBound);
			i++;
			statement.setInt(i, upperAgeBound);
			i++;
		}
		
		if (options[OPT_TYPE]) {
			statement.setString(i, type);
			i++;
		}
		
		ResultSet ret = statement.executeQuery();
		List<User> users = resultsetToUsers(ret);
		conn.close();
		return users;
	}
	
	private static List<User> resultsetToUsers(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<User>();
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String surname = rs.getString("surname");
			Date bDate = rs.getDate("birthdate");
			Timestamp cts = rs.getTimestamp("creationTimeStamp");
			int age = rs.getInt("age");
			User.eType type = User.charStrToEnum(rs.getString("type"));
			
			User user = new User(id, name, surname, bDate, cts, age, type);
			users.add(user);
		}
		
		return users;
	}
}
