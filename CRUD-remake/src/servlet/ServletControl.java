
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import models.User;
import utilities.PasswordOps;

@WebServlet("/ServletControl")
public class ServletControl extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServletControl() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main switch hub, that identifies the operation required and forwards to the
	 * correct page
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws SQLException
	 */
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, SQLException {
		String op = request.getParameter("op");

		switch (op) {
		case "login":
			showLogin(request, response);
			break;
			
		case "list":
			request.setAttribute("users", DBActions.getAll());
			forward(request, response, "/listAll.jsp");
			break;

		case "new":
			forward(request, response, "/newUser.jsp");
			break;
	
		case "newLogin":
			forward(request, response, "/newLogin.jsp");
			//showNewLogin (request, response);
			break;
			

		case "insert":
			insertUser(request, response);
			break;

			
		case "insertLogin":
			insertLoginUser(request, response);
			break;
			

		case "delete":
			deleteUser(request, response);
			break;

		case "edit":
			editUser(request, response);
			break;

		case "update":
			updateUser(request, response);
			break;	
			
		case "json":
			getJson(request, response);
			break;

		case "search":
			search(request, response);
			break;
			
		default:
			forward(request, response, "/menu.jsp");
			break;
		}
	}
	
	/**
	 * Inner forwarder for create new user to NewLogin page
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showNewLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		boolean test = false;
		/*/
		test = uname.equals("crud")&& pwd.equals("0000");
		/*/
		String crypted = DBActions.getPassword(uname);
		test = PasswordOps.verifyPass(pwd, crypted);
		//*/
		if(test)
		{
			forward(request, response, "/Login.jsp");
		}
		else
		{
			forward(request, response, "/ErrorNewLogin.jsp");
		}
		
	}
	
	/**
	 * Inner forwarder for access with user to login page
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		boolean test = false;
		/*/
		test = uname.equals("crud")&& pwd.equals("0000");
		/*/
		String crypted = DBActions.getPassword(uname);
		test = PasswordOps.verifyPass(pwd, crypted);
		//*/
		if(test)
		{
			forward(request, response, "/menu.jsp");

		}

		else
		{
			forward(request, response, "/ErrorLogin.jsp");
		}
		
	}

	/**
	 * Inner forwarder for deleting users
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		DBActions.deleteUser(request, response);
		request.setAttribute("users", DBActions.getAll());
		forward(request, response, "/listAll.jsp");
	}

	/**
	 * Inner forwarder for inserting users into DB
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insertUser(HttpServletRequest request, HttpServletResponse response) // Attention visibility Public/private if you test servlet
			throws SQLException, ServletException, IOException {
		DBActions.insertUser(request, response);
		request.setAttribute("users", DBActions.getAll());
		forward(request, response, "/listAll.jsp");
	//response.sendRedirect("listAll.jsp");
	}
	
	

	private void insertLoginUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		boolean test=DBActions.insertLoginUser(request, response);
		//forward(request, response, "/menu.jsp");
		if(test)
		{
			forward(request, response, "/Login.jsp");
		}
		else
		{
			forward(request, response, "/ErrorNewLogin.jsp");
		}
	}
	

	/**
	 * Inner forwarder for receiving data to edit users
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		Optional<User> existingUser = DBActions.find(id);
		existingUser.ifPresent(s -> request.setAttribute("user", s));
		existingUser.ifPresent(s -> request.setAttribute("userType", s.getTypeString()));
		forward(request, response, "/editUser.jsp");
	}

	/**
	 * Inner forwarder for updating users
	 * 
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		DBActions.editUser(request, response);
		request.setAttribute("users", DBActions.getAll());
		forward(request, response, "/listAll.jsp");
	}

	
	private void getJson(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		JSONObject json = getJson(id);
		request.setAttribute("json", json);
		forward(request, response, "/menu.jsp");	//TODO: redirect where???
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 doGet(request, response);
	}


	
	private JSONObject getJson(String id) throws SQLException {
		JSONObject json = null;
		
		Optional<User> user = DBActions.find(id);
		if(user.isPresent())
			json = user.get().getJsonObj();
		
		return json;
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<User> result = DBSearch.search(request, response);
		request.setAttribute("user", result);
		forward(request, response, "/userFound.jsp");
	}
}
