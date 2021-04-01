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
import kr.or.ddit.member.service.IMemberService2;
import kr.or.ddit.member.service.MemberServiceImpl2;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet{
	private IMemberService2 service = new MemberServiceImpl2();
	
	private void addCommandAttribute(HttpServletRequest req) {
		req.setAttribute("command", "update");
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		addCommandAttribute(req);
//		HttpSession session = req.getSession();
//		MemberVO authmember = (MemberVO)session.getAttribute("authMember");
//		String authId = authmember.getMem_id();
//		MemberVO member = service.retrieveMember(authId);
//		req.setAttribute("member", member);
//		String view = "/WEB-INF/views/member/memberForm2.jsp";
//		req.getRequestDispatcher(view).forward(req, resp);
//		// 로그인되어있는 사람의 정보를 가지고와서 memberForm 재활용 이동
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addCommandAttribute(req);
		req.setCharacterEncoding("UTF-8");
		String mem_id = req.getParameter("id");
		if(mem_id == null || mem_id.isEmpty()) {
			resp.sendError(400);
			return;
		}
		
		Map<String, Object> resultMap = new HashMap<>();
		 MemberVO member = service.
		try {
			MemberVO member = service.removeMember(member);
			resultMap.put("result",ServiceResult.FAIL);
		}catch (Exception e) {
			resultMap.put("result",ServiceResult.OK);
		}
		resp.setContentType(MimeType.JSON.getMime());
		try(
			PrintWriter out = resp.getWriter();
		){
			ObjectMapper mapper =new ObjectMapper();
			mapper.writeValue(out, resultMap);
		}
		
	}

	

}
