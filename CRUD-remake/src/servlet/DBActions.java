package servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.User.eType;

public class DBActions {

	protected static List<User> getAll() throws SQLException {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT id, name, surname, birthdate, creationTimeStamp, age, type FROM crud_users";
		
		Connection conn = ConnHelper.getConnection();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String surname = resultSet.getString("surname");
			java.sql.Date bDate = resultSet.getDate("birthdate");
			Timestamp cts = resultSet.getTimestamp("creationTimeStamp");
			int age = resultSet.getInt("age");
			User.eType type = User.charStrToEnum(resultSet.getString("type"));
			
			User user = new User(id, name, surname, bDate, cts, age, type);
			list.add(user);
		}
		
		return list;
	}
	
	protected static boolean insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		Date birth = Date.valueOf(request.getParameter("birth"));
		String type = request.getParameter("type");
		Timestamp now = new Timestamp((new java.util.Date()).getTime());
		int age = getAge(birth);
		
		boolean inserted=false;
		String sql = "INSERT into crud_users (name, surname, birthdate, creationtimestamp, age, type) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = ConnHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, surname);
		statement.setDate(3, birth);
		statement.setTimestamp(4, now);
		statement.setInt(5, age);
		statement.setString(6, type);
		
		inserted = statement.executeUpdate() > 0;
		return inserted;
	}
	
	public static boolean deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		String sql = "DELETE FROM crud_users WHERE id = ?";
		Connection conn = ConnHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);
		
		boolean deleted = statement.executeUpdate() > 0;
		return deleted;
	}
	
	public static boolean editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int id = Integer.parseInt( request.getParameter("id"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		Date birth = Date.valueOf(request.getParameter("birth"));
		String type = request.getParameter("type");
		int age = getAge(birth);
		
		boolean inserted=false;
		String sql = "UPDATE crud_users SET name = ?, surname = ?, birthdate = ?, age = ?, type = ? WHERE id = ?";
		Connection conn = ConnHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, surname);
		statement.setDate(3, birth);
		statement.setInt(4, age);
		statement.setString(5, type);
		statement.setInt(6, id);
		
		inserted = statement.executeUpdate() > 0;
		return inserted;
	}
	
	public static Optional<User> find(String id) throws SQLException {
		String sql = "SELECT id, name, surname, birthdate, type FROM crud_users WHERE id = ?";
		String name = "", surname = "";
		eType type = null;
		Date bDate = null;
		int id_i = 0, age = 0;
		
		Connection conn = ConnHelper.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, id);
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			id_i = rs.getInt("id");
			name = rs.getString("name");
			surname = rs.getString("surname");
			bDate = rs.getDate("birthdate");
			type = User.charStrToEnum(rs.getString("type"));
			age = getAge(bDate);
		}
		return Optional.of(new User(id_i, name, surname, bDate, null, age, type));
	}
	
	private static int getAge(Date date) {
		LocalDate now = LocalDate.now();
		LocalDate bDate = date.toLocalDate();
		int age = now.getYear() - bDate.getYear();
		if (now.getDayOfYear() < bDate.getDayOfYear())
			age--;
		return age;
	}
}
