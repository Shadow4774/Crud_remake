package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import servlet.DBSearch;

public class SearchTest {

	@Test
	public void testSqlString() {
		boolean[] options = {false, false, false, false, false};
		boolean[] optsAfter = {true, true, false, true, false};
		
		//Method normally private. Set to public before testing and revert to private afterward
		
		String sql = DBSearch.getSqlString("name", "surname", null, null, 0, 18, null, options);
		String expected = "SELECT id, name, surname, birthdate, creationTimeStamp, age, type FROM crud_users WHERE ";
		expected += "name = ? AND ";
		expected += "surname = ? AND ";
		expected += "age BETWEEN ? AND ? ";
		
		assertEquals(expected, sql);
		
		boolean temp = true;
		for (int i = 0; i < optsAfter.length; i++) {
			temp = temp && (options[i] == optsAfter[i]);
		}
		assertTrue(temp);
	}

}
