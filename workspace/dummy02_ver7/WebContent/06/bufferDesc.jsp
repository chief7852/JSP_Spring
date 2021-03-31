<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1kb" autoFlush="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/bufferDesc.jsp</title>
</head>
<body>
<h4>JspWriter(out) : 응답 기록, 버퍼제어</h4>
<pre>
	: 응답 데이터 전송시 임시 버퍼(buffer 속성으로 크기 결정)가 활용됨.
	<%
		for(int count=1; count<=100;count++){
			int remain = out.getRemaining();
			if(remain<50){
				out.flush();
			}
			out.println(count+"번째반복, 버퍼의 잔여용량 :" + out.getRemaining());
			if(count==95){
				/* throw new IllegalArgumentException("강제발생"); */
				request.getRequestDispatcher("/06/implicitObject.jsp").forward(request, response);
			}
		}
	%>
</pre>
버퍼의장점 : 전송 효율이 올라감,forward와 include사용가능
</body>
</html>