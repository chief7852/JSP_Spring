package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.UserNotFoundException;
import kr.or.ddit.member.service.AuthenticateServiceImpl;
import kr.or.ddit.member.service.IAuthenticateService;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.annotation.Controller;
import kr.or.ddit.mvc.annotation.RequestMapping;
import kr.or.ddit.mvc.annotation.RequestMethod;
import kr.or.ddit.mvc.annotation.resolvers.BadRequestException;
import kr.or.ddit.mvc.annotation.resolvers.RequestParam;
import kr.or.ddit.vo.MemberVO;

//@WebServlet("/mypage.do")
@Controller
public class MemberViewController {
	IMemberService service = new MemberServiceImpl();
	IAuthenticateService authService =
					new AuthenticateServiceImpl();
	
	
	
	@RequestMapping("/member/memberView.do")
	public String memberView(
			@RequestParam(value="who") String mem_id,
			HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		
			MemberVO detailMember = service.retrieveMember(mem_id);
			String view = null;
			if(detailMember != null) {
			req.setAttribute("member", detailMember);
			view = "member/mypage";
			}else {
				throw new BadRequestException("존재하지 않는 회원정보");
				
			}
		
		return view;
	}
}











