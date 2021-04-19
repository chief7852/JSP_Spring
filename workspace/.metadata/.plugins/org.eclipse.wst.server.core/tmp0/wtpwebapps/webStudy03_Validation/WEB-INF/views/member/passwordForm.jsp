<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:if test="${not empty message }">
	<script type="text/javascript">
			alert("${message}")
		</script>
	<c:remove scope="session" var="message"/>
</c:if>

</head>
<body>
<form method="POST">
	<input type="text" name="mem_pass" required />
	<input type="submit" value="인증" />
</form>
</body>
</html>