//package kr.or.ddit.member.controller;
//
//import java.io.IOException;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kr.or.ddit.enumpkg.ServiceResult;
//import kr.or.ddit.member.service.IMemberService;
//import kr.or.ddit.member.service.MemberServiceImpl;
//import kr.or.ddit.vo.MemberVO;
//
//@WebServlet("/member/memberInsert.do")
//public class MemberInsertServlet extends HttpServlet{
//	private IMemberService service = new MemberServiceImpl();
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String view = "/WEB-INF/views/member/memberForm.jsp";
//		boolean redirect = false;
//		// logic
//		if(redirect) {
//			resp.sendRedirect(req.getContextPath()+view);
//		}else {
//			req.getRequestDispatcher(view).forward(req, resp);
//		}
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
////		  	1. 요청접수
//		MemberVO member = new MemberVO();
//		req.setAttribute("member",member);
////		  	2. 검증
//		Map<String,String>errors = new LinkedHashMap<>();
//		req.setAttribute("errors", errors);
//		boolean valid = validate(member,errors);
//		boolean redirect = false;
//		String message = null;
//		String view = null;
//		if(valid) {
//			ServiceResult result = service.createMember(member);
//			switch (result) {
//			case PKDUPLICATED:
//				view = "/WEB-INF/views/member/memberForm.jsp";
//				message = "아이디 중복";
//				break;
//			case OK:
//				redirect = true;
//				view = "/login/loginForm.jsp";
//				break;
//			default:
//				message = "서버오류, 잠시 뒤 다시 시";
//				view = "/WEB-INF/views/member/memberForm.jsp";
//				break;
//			}
//		}else {
//			view = "/WEB-INF/views/member/memberForm.jsp";
//			
//		}
//		req.setAttribute("message", message);
//		if(redirect) {
//			resp.sendRedirect(req.getContextPath()+view);
//		}else {
//			req.getRequestDispatcher(view).forward(req, resp);
//		}
//	}
//	
//	//post 검증
//	private boolean validate(MemberVO member, Map<String, String>errors) {
//		boolean valid = true;
//		if(member.getMem_id()==null || member.getMem_id().isEmpty()) {
//			valid = false;
//			errors.put("mem_id","아이디 누락");
//		}else {
//			////////////////////////////////////////////////////////////////////////얘랑 createMember,dao service controller제작하고 view를 만들어낸다
//		}
//		return valid;
//	}
//}
