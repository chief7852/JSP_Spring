<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09/cookieDesc.jsp</title>
</head>
<body>
<h4>Cookie</h4>
<pre>
   : Http 의 stateless 특성을 보완하기 위해 최소한의 상태 정보를 저장하는 개념.
      1. session : 상태 정보를 서버사이드에서 유지
      2. cookie : 상태 정보를 클라이언트 사이드에서 유지.
      
      ** 쿠키  사용 방법
      <%
         Cookie sampleCookie = new Cookie("sampleCookie","CookieValue");
         response.addCookie(sampleCookie);
         
         Cookie koreanCookie = new Cookie("koreanCookie","한글쿠키");
         response.addCookie(koreanCookie);
      %>
      1. 쿠키 생성
      2. 응답에 쿠키를 포함하여 전송(header)
      
      3. 쿠키가 브라우저가 가진 저장소에 저장.
      4. 저장되어 있던 쿠키가 다음번 요청에 실려 재전송(header)
      
      5. 요청에 포함된 쿠키를 꺼내서 상태 복원 : <a href="cookieView.jsp">쿠키확인하기 (동일경로)</a>
      
      
      ** 쿠키 속성의 종류
		1. name(required)
		2. value(required)
		3. domain(host)
		4.path
		5.maxAge(expires)
		6.httpOnly
		7.secure
</pre>
</body>
</html>