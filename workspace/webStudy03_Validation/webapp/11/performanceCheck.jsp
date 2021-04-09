<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.ddit.db.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4> 성능 체크</h4>
<pre>
	   소요(반응)시간 = processiong time + latency time  
	<a href="oneConnOneProcess.jsp">한번연결하고 한번처리함</a> : 7ms	/pooling후 0ms
	<a href="100Conn100Process.jsp">백번연결하고 백번처리함</a> : 865ms /pooling후 7ms
	<a href="oneConn100Process.jsp">한번연결하고 백번처리함</a> : 11ms  /pooling후 2ms
</pre>
</body>
</html>