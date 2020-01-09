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
import model.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String birthDate = request.getParameter("birthDate");
		String youremail = request.getParameter("youremail");
		String reenteremail = request.getParameter("reenteremail");
		String username = request.getParameter("youremail");//No username for now
		String regpwd = request.getParameter("regpwd");
		String gender = request.getParameter("gender");
		
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(youremail);
		user.setUsername(username);
		user.setPassword(regpwd);
		user.setGender(gender);
		//TODO: set date
		user.setReenteremail(reenteremail);
		request.setAttribute("birthDate", birthDate);
		request.setAttribute("signupUser", user);
		
		UserDao dao = new UserDaoImpl();
		if(dao.findUserByUsernameOrEmail(username) || dao.findUserByUsernameOrEmail(youremail)) {
			if(dao.findUserByUsernameOrEmail(username)){
				request.setAttribute("signupError", "Username already exist.");
			}else {
				request.setAttribute("signupError", "Email already exist.");
			}
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		}
		
		if(reenteremail != null && youremail != null && !reenteremail.equals(youremail)) {
			request.setAttribute("signupError", "Email Addres are not same.");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		}
		
		
		System.out.println("Signup user: " + user);
		try {
			dao.saveUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("loginError", "Signup Completed , now you can login.");
			response.sendRedirect("login");
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}
}
