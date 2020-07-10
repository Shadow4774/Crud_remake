package servlet;

import java.io.IOException;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

		case "insert":
			insertUser(request, response);
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

		default:
			forward(request, response, "/menu.jsp");
			break;
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
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		if (uname.equals("crud") && pwd.equals("0000")) {
			// response.sendRedirect("index.html");
			forward(request, response, "/menu.jsp");
		} else {
			// response.sendRedirect("ErrorLogin.jsp");
			forward(request, response, "/errorLogin.jsp");
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
	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		DBActions.insertUser(request, response);
		request.setAttribute("users", DBActions.getAll());
		forward(request, response, "/listAll.jsp");
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
		forward(request, response, "/listAll.jsp");	//TODO: redirect where???
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 doGet(request, response);
	}


	
	private JSONObject getJson(String id) throws SQLException {
		JSONObject json = null;
		
		Optional<User> user = DBActions.find(id);
		if(user.isPresent())
			json = user.get().getJsonObj();
		
		return json;
	}

}
