<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>12/eventDesc.jsp</title>
</head>
<body>
	<h4>서버사이드 이벤트 처리방법</h4>
	<pre>
	** 서버사이드 이벤트 종류
	1. lifecycle event : request, session, application
	2. attrivute event(add/remove/change) : request,session,application
1. 이벤트 대상(target )식별 : button, application
2. 처리할 이벤트(event) 식별 : click
3. 처리할 내용을 가진 핸들러 구현 : function, listener
4. 이벤트 대상에게 핸들러를 부착. : onclick, web.xml(내부에있는listener)
<button type="button" id="clickBtn">클릭</button>
<script type="text/javascript">
	let button = document.getElementById("clickBtn");
	function clikcHandler() {
		alert("클릭!")
	}
	button.onclick = clikcHandler;
</script>
</pre>
</body>
</html>