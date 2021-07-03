<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.js"></script> 
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
var socket = new SockJS('/chat');
stompClient = Stomp.over(socket);
stompClient.connect({}, funcetion(frame){
	console.log('Connected: ' + frame);
	stompClient.subscribe("/topic/a", function(response){
		console.log(response);
		console.log(JSON.parse(response.body));
	})
})
</script>
</body>
</html>