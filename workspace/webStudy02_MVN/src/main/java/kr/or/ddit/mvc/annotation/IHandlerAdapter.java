package kr.or.ddit.mvc.annotation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IHandlerAdapter {
	// 책임을 한번더 분리 (String view)
 public String invokeHandler
 				(RequestMappingInfo mappingInfo,HttpServletRequest req,
 						HttpServletResponse resp) throws ServletException,IOException;
}
