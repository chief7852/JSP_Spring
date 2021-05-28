<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.js"></script> 
</head>
<body>
<h4>웹소켓 클라이언트</h4>
<pre>
	서버 = wss://echo.websocket.org
	<input type="button" id="connBtn" value="connect">
	<input type="button" id="disconnBtn" value="disconnect">
	<input type="text" id="msgArea"/>
	<input type="button" id="sendBtn" value="메시지 전송"/>
	<textarea id="messages" readonly="readonly" rows="10" cols="50"></textarea>
</pre>
<script type="text/javascript">
	var server = "ws://localhost/${cPath}/ehco";
	var ws = null;
	$("#connBtn").on("click",function(){
		ws = new WebSocket(server);
		ws.onopen=function(event){
			//서버 url정보 받기
			let serverURL = event.target.url;
			console.log("연결수립");
		}
		ws.onerror=function(event){
			console.log("에러발생");
		}
		ws.onclose=function(event){
			//서버 url정보 받기
			let serverURL = event.target.url;
			console.log("연결종료");
		}
		ws.onmessage=function(event){
			let serverURL = event.target.url;
			let receiveMsg = event.data;
			console.log("메세지 수신");
			$("#messages").append("메아리:" + receiveMsg + "\n");
		}
	})
	$("#disconnBtn").on("click",function(){
		if(ws==null) return;
		ws.close();
	})
	$("#sendBtn").on('click', function(){
		let message = $("#msgArea").val();
		if(!message) return;
		ws.send(message);
		$("#msgArea").text("");
		$("#messages").append("나:" + message +"\n");
	})

</script>
</body>
</html>