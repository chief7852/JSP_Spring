package kr.or.ddit.servlet04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/login/logout.do1")
public class LogoutServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.isNew()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		session.invalidate();
		
		String view = "/";
		response.sendRedirect(request.getContextPath()+view);
	}


}
