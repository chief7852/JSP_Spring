package kr.or.ddit.alba.controller;

import javax.servlet.http.HttpSession;

import kr.or.ddit.mvc.annotation.Controller;
import kr.or.ddit.mvc.annotation.RequestMapping;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.RequestParam;

@Controller
public class PasswordCheck {
	
	@RequestMapping(value="/alba/albaPass.do" ,method=RequestMethod.POST)
	public String passCheck(
				@RequestParam("pass")String pass,
				HttpSession session
			) {
		String view = "redirect:/index.jsp";
		if(!pass.isEmpty()&&pass.equals("admin")) {
			session.setAttribute("allow", "yes");
			view = "index";
		}else {
			session.setAttribute("message", "비밀번호 오류");
		}
		return view;
	}
}
