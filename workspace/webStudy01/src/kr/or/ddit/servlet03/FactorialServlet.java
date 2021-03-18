package kr.or.ddit.servlet03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.MimeType;
import kr.or.ddit.servlet03.view.JsonView;
import kr.or.ddit.servlet03.view.XmlView;

@WebServlet("/03/factorial")
public class FactorialServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/factorialForm.jsp");
		dispatcher.forward(req, resp);
	}//jsp까지 연결해주면끝
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int num = resultSet(req);
		String accept = req.getHeader("accept");
	      MimeType mime = MimeType.searchMimeType(accept);
	      resp.setContentType(mime.getMime());
	      PrintWriter out = resp.getWriter();
	      out.print(num);
	}//jsp에서 다시받아옴 enum샐만들고
	
	
	
	private int resultSet(HttpServletRequest req) {
		int num = Integer.parseInt(req.getParameter("single"));
		int tmp = 1;
		for(int i=num;i>=1;i--) {
			tmp = tmp*i;
		}
		return tmp;
	}
}
