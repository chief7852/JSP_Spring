<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input {
		display:block;
	}
</style>
</head>
<body>
<div>
	<h4>관리자로 로그인</h4>
	<form name="authemp" action="${cPath }/login/logincheck.do" method="post">
	<div>
		<p>Sign in to start your session</p>
		<input type="text" name="employee_id" autofocus placeholder="아이디를 입력하세요." />
		<input type="password" name="employee_pwd" autofocus placeholder="패스워드를 입력하세요" />
		<input type="checkbox" value="ok" name="remember_id" value="Remember Me" style="display: inline;"> Remember Me
		<button type="submit" value="로그인">로그인</button>
	</div>
	</form>
	<input type="button" value="아이디/패스워드 찾기">
</div>
<script type="text/javascript">
	
</script>
</body>
</html>