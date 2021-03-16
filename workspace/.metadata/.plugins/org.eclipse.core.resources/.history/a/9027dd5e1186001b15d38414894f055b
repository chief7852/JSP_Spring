package kr.or.ddit.servlet01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractUseTmplServlet extends HttpServlet{	//AbstractUseTmplServlet이라는 서블릿을 만듬/ 인스턴스를 바로 생성할 수 없다. 때문에 파생클래스가 있어야한다 파생클래스로 만든것은 ? imageFormServlet매서드
	//ServletContext클래스는 톰캣 컨테이너 실행시 각 컨텍스트마다 한개의 servletContext객체를 생성한다.
	//그리고 톰캣 컨테이너가 종료하면 servletcontext객체 역시 소명한다.
   protected ServletContext application;	//protected는 패키지 안에서만 이동가능함  application은 변수명
   
   
   //init
   @Override
   public void init(ServletConfig config) throws ServletException {//ServletConfig 서블릿의 환경설정 / 기능 : servlet context의 객채를 얻는기능 / 서블릿에 대한 초기화 작업 가능
	   //service이전에 호출되어야 하며 클라이언트 요청을 처리하기 전에 서블릿을 초기화 할 기회를 줌
	   //초기화 할 코드가 있다면 init()매서드를 재정의 하면 됨
	   
      super.init(config);	
      application = config.getServletContext();	//초기정보인 application에 서블릿의 환경설정을 담아준다.
   }
   
   //service -> 순서만 정해 메소드를 호출한다. template method pattern
   
   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	//★template 매서드 순서만을 정의하는 매서드 (안의 후크매서드가 기능을 정의하고 있다.)
//      0. 응답데이터의 mime 결정
      setContentType(resp);	//mime타입을 지정하고 캐릭터의 incoding을 지정할 수 있음 setContentType으로 인코딩을 지정해 줌으로서 출력문을 작성해줌
//      1. ui tmpl 읽기
      StringBuffer tmplSrc = readTmpl(req);	//스트링은 값을 주면 메모리할당이 서버가 끝날때 없어진다. //메모리차원에서 애끼려고		//rea
//      2. 데이터 만들기 (치환할 대상이 될 )
      makeData(req);
//      3. tmpl을 데이터로 치환
      StringBuffer html = replaceData(tmplSrc, req);
//      4. 응답을 전송 (try ~ with resource)
      try(
      PrintWriter out = resp.getWriter();
      ){      
      out.print(html);
      }
      
   }

   //--------------------------------------메서드
   protected abstract void setContentType(HttpServletResponse resp);	//imageFormServlet.java	데이터를 만들어 내기 위한 매서드

   private StringBuffer replaceData(StringBuffer tmplSrc, HttpServletRequest req) {	//%%안의 글자를 판별 하기위한 매서드
      Pattern regex = Pattern.compile("%([a-zA-Z0-9_]+)%");
      Matcher matcher = regex.matcher(tmplSrc);
      StringBuffer html = new StringBuffer();
      while(matcher.find()) {
         String name = matcher.group(1);	//첫번째() 그룹에 매칭되는 친구를 name에 저장 
         Object value = req.getAttribute(name);
         if(value!=null) {
            matcher.appendReplacement(html, value.toString());
         }
      }
      matcher.appendTail(html); //남은애들 처리하라
      return html;
   }
   
   protected abstract void makeData(HttpServletRequest req);

   private StringBuffer readTmpl(HttpServletRequest req) throws IOException {
      //tmpl 파일읽기
      String tmplPath = req.getServletPath();
        System.out.println("tmplPath  :" +tmplPath);
        InputStream is = application.getResourceAsStream(tmplPath);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String temp =  null;
        StringBuffer tmplSrc = new StringBuffer();
        while((temp = reader.readLine()) != null) {
           tmplSrc.append(String.format("%s\n",temp));
        }
      return tmplSrc;
   }
}