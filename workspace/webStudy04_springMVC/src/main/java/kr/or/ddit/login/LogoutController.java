package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController{
	@RequestMapping(value="/login/logout.do", method=RequestMethod.POST)
	public String logout(HttpSession session, HttpServletResponse resp) throws ServletException, IOException {
		if(session.isNew()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		session.invalidate();
		
		return "redirect:/";
	}
}












