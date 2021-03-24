<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>내포(include)의 종류</h4>
<pre>
	언제 include 되느냐, 무엇을 include 하느냐.
	1. 동적 include : runtime에 실행결과를 내포한다.
		: RequestDispatcher.include
		: pageContext.include
		: include 액션 태그를 사용.
		<jsp:include page="/04/localeDesc.jsp"></jsp:include>
		커스텀 태그 : 개발자가 필요에 의해 새로 정의한 태그
		%lt;prefix:tagname attributes /&gt;
		prefix : jsp
		tagname : include , forward , ....
		attributes : page=""
		<%-- <%
			pageContext.include("/04/localeDesc.jsp");
		%> --%>
	2. 정적 include : 소스가 파싱될때, 런타임이전에 실행되고 소스자체를 내포한다
<%-- 		<%@ include file="/04/localeDesc.jsp" %> --%>
		<%-- <%=locale %> --%>
</pre>
</body>
</html>