package kr.or.ddit.Reply.controller;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import kr.or.ddit.Reply.service.IReplyService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validator.InsertGroup;
import kr.or.ddit.vo.ReplyVO;

@RequestMapping("/reply")
@RestController
public class ReplyController {
	private static Logger logger = LoggerFactory.getLogger(ReplyController.class);
	@Inject
	private IReplyService service;
	@Inject
	private WebApplicationContext container;
	private ServletContext application;
	
	@PostConstruct
	public void init() {
		application = container.getServletContext();
	}
	
//	@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public ReplyVO createAjax(
		
		@Validated(InsertGroup.class)@ModelAttribute("reJson") ReplyVO reply
		, Errors errors
			) {
		logger.info("{}post값 들어오는지\n\n",reply);
		ServiceResult result = service.createReply(reply);
		String message = "실패";
		if(result.equals(ServiceResult.OK)) {
			message = "성공";
		}
		return reply;
	}
	
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String selectAjax() {
		logger.info("get으로 들어와버림\n\n");
		return null;
	}
	
//	@PutMapping("{rep_no}")
	
//	@DeleteMapping("{rep_no}")
}
