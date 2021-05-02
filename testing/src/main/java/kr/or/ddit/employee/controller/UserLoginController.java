package kr.or.ddit.employee.controller;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.employee.service.IEmployeeService;
import kr.or.ddit.enums.Results;
import kr.or.ddit.utils.BadRequestException;
import kr.or.ddit.vo.EmployeeVO;

@RequestMapping("/login")
@Controller
public class UserLoginController {
	private static final Logger logger =
			LoggerFactory.getLogger(UserLoginController.class);
	@Inject
	private IEmployeeService service;
	
	@Inject
	private WebApplicationContext container;
	private ServletContext application;
	
	@PostConstruct
	public void init() {
		application = container.getServletContext();
	}
	
	@RequestMapping(value = "/logincheck.do" , method = RequestMethod.POST)
	public String loginForm(
		@ModelAttribute("employee")EmployeeVO employee
		,@RequestParam("remember_id")String check
		,Model model
		,HttpSession session
		, HttpServletResponse resp
		) {
		if(session.isNew()) {
			throw new BadRequestException();
		}
		String view = "redirect:/login/loginForm.jsp";
		
		String message = null;
		//조회
		Results result = service.retrieveEmployeechek(employee);
		
		if(result.equals(Results.OK)) {
			if(!check.isEmpty()) {
				Cookie idCookie = new Cookie("idCookie", employee.getEmployee_id());
				idCookie.setPath(application.getContextPath());
				int maxAge = 0;
				if("saveId".equals(employee.getEmployee_id())) {
					maxAge = 60*60*24*7;
				}
				idCookie.setMaxAge(maxAge);
				resp.addCookie(idCookie);
				view = "employeeList";
			}
		}
		
		
		//결과에 따라 쿠키에 저장
		
		return view;
	}
}
