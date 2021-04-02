package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.enumpkg.MimeType;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.IMemberDAO2;
import kr.or.ddit.member.dao.MemberDAOImpl2;
import kr.or.ddit.member.service.IMemberService2;
import kr.or.ddit.member.service.MemberServiceImpl2;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet{
	private IMemberService2 service = new MemberServiceImpl2();
	
	private void addCommandAttribute(HttpServletRequest req) {
		req.setAttribute("command", "update");
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addCommandAttribute(req);
		System.out.println("post접속");
		req.setCharacterEncoding("UTF-8");
		
		String mem_id = req.getParameter("memid");
		String mem_pass = req.getParameter("password");
		if(mem_pass == null || mem_pass.isEmpty()) {
			resp.sendError(400);
			return;
		}
		HttpSession session = req.getSession();
		MemberVO orignMember = new MemberVO();
		orignMember.setMem_id(mem_id);
		orignMember.setMem_pass(mem_pass);
		if(mem_id == null || mem_id.isEmpty()) {
			resp.sendError(400);
			return;
		}
		
		ServiceResult result = service.removeMember(orignMember);
		String view = null;
			
		switch (result) {
			case INVALIDPASSWORD:
				session.setAttribute("message", "비밀번호오류!");
				view = "redirect:/mypage.do";
				break;
			case OK:
				session.invalidate();
				view = "redirect:/";
				break;
			default:
				session.setAttribute("message", "서버오류!");
				view = "redirect:/mypage.do";
				break;
			}
		boolean redirect = view.startsWith("redirect:");
		if(redirect) {
			resp.sendRedirect(req.getContextPath()+view.substring("redirect:".length()));
		}else {			
			req.getRequestDispatcher(view).forward(req,resp);
		}
		
	}

	

}
