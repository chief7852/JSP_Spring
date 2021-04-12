<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파일업로드에서는 request가 post여야한다 -->
<form method="post" enctype="multipart/form-data">	<!-- enctype="multipart/form-data"란 --><!-- body영역을 여러가지로 쪼개고 form으로 입력된데이터를 입력할수있다  -->
	<input type="text" name="uploader" placeholder="업로더"/>
	<input type="file" name="uploadFile1" accept="image/*"/>
	<input type="file" name="uploadFile2" accept="image/*"/>
	<button type="submit">업로드</button>
</form>

<img src="<%=request.getContextPath() %><%=session.getAttribute("uploadFile1")%>">
<img src="<%=request.getContextPath() %><%=session.getAttribute("uploadFile2")%>">
<%
	session.removeAttribute("uploadFile1");
	session.removeAttribute("uploadFile2");
%>
</body>
</html>