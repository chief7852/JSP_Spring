package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.mvc.annotation.HandlerAdapter;
import kr.or.ddit.mvc.annotation.HandlerMapping;
import kr.or.ddit.mvc.annotation.IHandlerAdapter;
import kr.or.ddit.mvc.annotation.IHandlerMapping;
import kr.or.ddit.mvc.annotation.RequestMappingInfo;


public class FrontController extends HttpServlet{
	
	//누구를 불러올지찾는일
	private IHandlerMapping handlerMapping;
	
	
	private IHandlerAdapter handlerAdapter;
	
	//forward
	private IViewResolver viewResolver;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		String packageParam =config.getInitParameter("basePackages");
		String[] basePackages = packageParam.split("\\s+");
		handlerMapping = new HandlerMapping(basePackages);
		handlerAdapter = new HandlerAdapter();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix(config.getInitParameter("prefix"));
		viewResolver.setSuffix(config.getInitParameter("suffix"));
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestMappingInfo mappinginfo =  handlerMapping.findCommandHandler(req);
		
		if(mappinginfo==null) {
			resp.sendError(404,"현재 요청을 처리할 핸들러가 없음");
			return;
		}
		String viewName = handlerAdapter.invokeHandler(mappinginfo, req, resp);
		
		if(viewName==null) {
			if(!resp.isCommitted()) {				
				resp.sendError(500,"논리적인 뷰네임은 null일수 없음");
			}
		}else{
			viewResolver.viewResolve(viewName, req, resp);
		}
		
	}
}
