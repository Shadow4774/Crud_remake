package junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import models.User;
import models.User.eType;
import servlet.ConnHelper;
import servlet.DBActions;
import servlet.ServletControl;

import org.junit.Before;
import org.junit.Ignore;

public class ServletTests {

	@InjectMocks
	private ConnHelper conHpr;

// @Mock private Datasource ds;

	@Mock
	private Connection conn;

	@Mock
	private Statement statement;

	@Mock
	private ResultSet resultset;

	@Mock
	private DBActions mockDB;

	private Integer user1 = null;

	private User user;

	private ServletControl servCtrl = new ServletControl();

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);

		int year = 1992;
		int dd = 23;
		int m = 03;
		Date date = new Date(year, dd, m);

		user = new User();
		user.setAge(28);
		user.setName("Gino");
		user.setSurname("Bianchi");
		user.setBirthDate(date);
		user.setType(eType.OWNER);
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void masterTest() throws IOException, SQLException, ServletException, ParseException {
		testParam();
		testExistUser();
		testDeleteUser();
		testVerifyDeleteUser();
	}

	public void testParam() throws IOException, SQLException, ServletException, ParseException {

		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		HttpServletResponse mockResponse = mock(HttpServletResponse.class);
		ConnHelper.getConnection();

		when(mockRequest.getParameter("op")).thenReturn("insert");

		when(mockRequest.getParameter("name")).thenReturn("admin");
		when(mockRequest.getParameter("surname")).thenReturn("test");
		when(mockRequest.getParameter("age")).thenReturn("28");
		when(mockRequest.getParameter("type")).thenReturn("OWNER");
		when(mockRequest.getParameter("birth")).thenReturn("2000-01-01");

		boolean test = DBActions.insertUser(mockRequest, mockResponse);

		assertTrue("Check", test);

	}

	public void testExistUser() throws IOException, SQLException, ServletException, ParseException {

		String name = "admin";
		String surname = "test";

		// Mockito.when(mockDB.getIdForNameSurname(name, surname)).thenReturn(user1);
		int test = DBActions.getIdForNameSurname(name, surname);

		assertTrue("Check", test > 0);

	}

	public void testDeleteUser() throws IOException, SQLException, ServletException, ParseException {

		String name = "admin";
		String surname = "test";

		// Mockito.when(mockDB.getIdForNameSurname(name, surname)).thenReturn(user1);
		int id = DBActions.getIdForNameSurname(name, surname);
		User temp = new User();
		temp.setId(id);
		boolean test = DBActions.deleteUser(temp);
		assertTrue("Check", test);

	}

	public void testVerifyDeleteUser() throws IOException, SQLException, ServletException, ParseException {

		String name = "admin";
		String surname = "test";

		// Mockito.when(mockDB.getIdForNameSurname(name, surname)).thenReturn(user1);
		int test = DBActions.getIdForNameSurname(name, surname);
		assertTrue("Check", test == 0);

	}

}
