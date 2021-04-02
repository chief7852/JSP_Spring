package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService2;
import kr.or.ddit.member.service.MemberServiceImpl2;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberList.do")
public class MemberListServlet extends HttpServlet{
private IMemberService2 service = new MemberServiceImpl2();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<MemberVO> list =service.retrieveMemberList();
		req.setAttribute("memList", list);
		
		String view = "/WEB-INF/views/member/memberList.jsp";
		req.getRequestDispatcher(view).forward(req, resp);;
	}
}
