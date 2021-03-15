package kr.or.ddit.servlet01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet : 자바를 기반으로 웹어플리케이션을 구현하기 위한 명세 혹은 또 그명세에 때란 API 모음
 * 개발단게
 * 1. HttpServlet 의 구현체로 서블릿 소스 작성
 * 2. WEP-INF/classess(context classpath)에 컴파일 후 클래스 파일 배포
 * 3. 컨테이터에 서블릿을 등록.
 * 		1) 2.X : wep.xml 을이용
 * 				 servlet -> servlet-name, servlet-class
 * 		2) since 3.xc: @WebServlet CoC(Convention over Configuration)
 * 4. 서블릿 매핑으로 웹 상의 명령(URI)을 받을 수 있도록 연결.
 * 		1) 2.x : web.xml
 * 			servlet-mapping -> servlet-name, url-pattern
 * 		2) 3.x : @WebServlet(value, urlParrterns)
 * 5. 컨테이너 재구동
 * 
 * 	** Servlet Container의 역활 : servlet 의 lifecycle 관리자
 * 	   container : 컨테이너 내부에서 관리되는 컴포넌트의 생명주기 관리자
 * 	   
 *     생성 : init
 *     요청 : service, doXXX
 *     소멸 : destroy
 *     
 *     서블릿 관리 정책
 *     1. 특별한 설정이(loadOnStartup) 없는 한 해당 서블릿에 매핑된 최초의 요청이 발생하면 인스턴스 생성
 *     2. 서블릿의 초기화 단계에서 초기화 파라미터 (init-param)
 *      ** ServletConfig : 서블릿의 메타 정보를 캡슐화한 객체
 *     
 */

//@WebServlet(value="/desc.do", loadOnStartup=1, initParams= {
//						@WebInitParam(name="paramName", vlaue="paramValue")
//				})	
public class DescriptionServlet extends HttpServlet{
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String param = config.getInitParameter("paramName");
		//서블릿의 객체는 싱글톤으로 운영된다는것을 알 수 있음
		System.out.printf("%s 서블릿초기화, 전달파라미터 : %s \n",
						this.getClass().getName(), param);
	}
	
	@Override	// template method
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("요청접수, 매소드 판단");
		/* super.service(req, resp); */
	}
	
	@Override	// hook method
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.printf("특정 매서드(get) 를 처리할 수 있는 callback, thread name : %s\n", Thread.currentThread().getName());
	}
	
	@Override
	public	 void destroy() {
		super.destroy();
		System.out.printf("%s 객체 소멸\n", DescriptionServlet.class.getName());
	}
}

















