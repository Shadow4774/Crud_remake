package junit;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;

import org.json.simple.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import models.User;
import models.User.eType;
import servlet.DBActions;

public class JunitTests {

	@Ignore
	public void testNewUser() {
		User test = new User(0, "TEST NAME", "TEST SURNAME", Date.valueOf("2000-01-01"), null, 0, eType.OWNER);
		boolean result = false;
		try {
			result = DBActions.insertUser(test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(result);
	}
	
	@Ignore
	public void testDeleteUser() {
		boolean result = false;
		try {
			int id = DBActions.getIdForNameSurname("TEST NAME", "TEST SURNAME");
			if(id > 0) {
				User test = new User(id, null, null, null, null, 0, null);
				result = DBActions.deleteUser(test);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(result);
	}

	@Test
	public void testJson() {
		User user = new User(1, "Name", "Surname", null, null, 18, null);
		JSONObject json = user.getJsonObj();
		String testString = "";
		
		testString = json.get("name").toString();
		assertTrue("Name".equals(testString));
		
		testString = json.get("surname").toString();
		assertTrue("Surname".equals(testString));
		
		testString = json.get("age").toString();
		int testInt = Integer.parseInt(testString);
		assertTrue(testInt == 18);
	}
}
