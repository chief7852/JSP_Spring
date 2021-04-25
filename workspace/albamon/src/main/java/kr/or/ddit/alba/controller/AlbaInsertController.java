package kr.or.ddit.alba.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.alba.dao.CodeDAOImpl;
import kr.or.ddit.alba.dao.ICodeDAO;
import kr.or.ddit.alba.service.AlbaServiceImpl;
import kr.or.ddit.alba.service.IAlbaService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.mvc.annotation.Controller;
import kr.or.ddit.mvc.annotation.RequestMapping;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.ModelAttribute;
import kr.or.ddit.mvc.annotation.resolvers.RequestPart;
import kr.or.ddit.mvc.filter.wrapper.MultipartFile;
import kr.or.ddit.validate.CommonValidator;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.AlbaVO3;

@Controller
public class AlbaInsertController {
	
	IAlbaService service = AlbaServiceImpl.getInstance();
	ICodeDAO codeDAO = CodeDAOImpl.getInstance();
	
	@RequestMapping("/alba/albaInsert.do")
	public String addAlbaForm() {
		
		return "alba/albaForm";
	}
	
	@RequestMapping(value = "/alba/albaInsert.do",method =RequestMethod.POST)
	public String createForm() {
		
	}
}
