package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao = new UserDaoImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginError = (String) session.getAttribute("loginError");
		request.setAttribute("loginError", loginError);
		session.removeAttribute("loginError");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");//admin
		String password = request.getParameter("password");//admin
		
		System.out.println(username + "  " + password);
		
		if(userDao.validateUser(username, password)) {
			//Success
			
			//Save User in session.
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30*60);
			session.setAttribute("activeUser", username);
			session.setAttribute("projectName", "Java Stud Web");
			
			RequestDispatcher rd = request.getRequestDispatcher("views/entag.jsp");
			rd.forward(request, response);
			
			
		}else {
			//Error
			request.setAttribute("loginError", "Sorry! Login Error.");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
			
		
		
	}

}
