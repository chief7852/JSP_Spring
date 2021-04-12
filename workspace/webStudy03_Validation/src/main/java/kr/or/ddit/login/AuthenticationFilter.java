package kr.or.ddit.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  	접근 제어를 통한 자원의 보호
 	1. 인증(authentication) : 본인 여부를 확인하는 신원 확인 절차
 	2. 인가(authorization) : 보호 자원에 접근할 수 있는 역할이 부여되어 있는지 여부 확인하는 절차(권한 확인)
 */
public class AuthenticationFilter implements Filter{
	private static final Logger logger = 
			LoggerFactory.getLogger(AuthenticationFilter.class);
	
	private Map<String, String[]> securedResources;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("{} 필터 초기화",getClass().getName());
		// securedResources.properties을 읽고, 로딩.
		 ResourceBundle bundles = ResourceBundle.getBundle("kr.or.ddit.securedResources");
		 securedResources = new LinkedHashMap<>();
		 for(String bundl:bundles.keySet()) {
			 String value = bundles.getString(bundl);
			 String[] val = value.split(",");		
			 securedResources.put(bundl,val );
		 }
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 1. 보호 자원에 대한 요청인지 식별
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String[] value = securedResources.get(uri);
//		if(value.)
		
		// 2. 보호 필요 자원
		
		// 3. 인증 여부 확인
		// 인증시 통과
		// 미인증시 loginform으로 이동
		// 2-1. 보호할 필요없는 자원 : 통과
		
	}

	@Override
	public void destroy() {
		logger.info("{} 필터 소멸",getClass().getName());
		
	}
	
}
