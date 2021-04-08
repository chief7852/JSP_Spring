package kr.or.ddit.prod.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.annotation.Controller;
import kr.or.ddit.mvc.annotation.RequestMapping;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

///prod/prodUpdate.do
@Controller
public class ProdUpdateController {
	   IProdService service = ProdServiceImpl.getInstance();
	@RequestMapping("/prod/prodUpdate.do")
	public String upForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prod_id = req.getParameter("prod_id");
		System.out.println(prod_id);
		
		return "prod/prodForm";
	}
}
