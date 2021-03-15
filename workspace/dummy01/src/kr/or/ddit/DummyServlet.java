package kr.or.ddit;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DummyServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain;charset=UTF-8");
//		DummyServlet.class
		URL url =this.getClass().getResource("/kr/or/ddit/dummy.xml");
		resp.getWriter().println("대충" + url);
	}
}
