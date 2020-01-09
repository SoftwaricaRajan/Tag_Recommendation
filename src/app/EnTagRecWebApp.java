package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bic.BIC;

/**
 * Servlet implementation class EnTagRecServlet
 */
@WebServlet("/entagsearch")
public class EnTagRecWebApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String activeUser = (String) session.getAttribute("activeUser");
		if(activeUser == null) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
		String searchTerm = request.getParameter("question");
		if (null == searchTerm) {
			searchTerm = "";
		}
		List<String> recommandedErrorAndTag = BIC.enTagRec(searchTerm);

		request.setAttribute("recommandedTag", recommandedErrorAndTag.get(recommandedErrorAndTag.size()-1));
		request.setAttribute("recommandedErrors", recommandedErrorAndTag.subList(0, recommandedErrorAndTag.size()-1));
		RequestDispatcher rd = request.getRequestDispatcher("views/entag.jsp");
		rd.forward(request, response);
	}

}
