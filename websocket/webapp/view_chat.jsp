<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>웹소켓 채팅</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.js"></script>
	<script type="text/javascript">
		var webSocket = {
			init: function(param) {
				this._url = param.url;
				this._initSocket();
			},
			sendChat: function() {
				this._sendMessage($('#message').val());
				$('#message').val('');
			},
			// 메세지 데이터가 들어오면 그 메세지를 보여줌
			receiveMessage: function(str) {
				$('#divChatData').append('<div>' + str + '</div>');				
			},
			// 소켓에연결되지않음
			closeMessage: function(str) {
				$('#divChatData').append('<div>' + '연결 끊김 : ' + str + '</div>');
			},
			//소켓연결종료
			disconnect: function() {
				this._socket.close();
			},
			// 소켓연결
			_initSocket: function() {
				this._socket = new SockJS(this._url);
				this._socket.onmessage = function(evt) {
					webSocket.receiveMessage(evt.data);
				};
				// 종료이벤트
				this._socket.onclose = function(evt) {
					//(나갔다는 메세지를 출력)
					webSocket.closeMessage(evt.data);
				}
			},
			// 메세지가입력되면 HandlerChat.java로 문자를 모냄
			_sendMessage: function(str) {
				this._socket.send(str);
			}
		};
	</script>	
	<script type="text/javascript">
		$(document).ready(function() {
			/* 서버의 url주로를 가져와서 init메소드에 넣어주면서 접속한다 */
			webSocket.init({ url: '<c:url value="/chat" />' });			
		});
	</script>
</head>
<body>
	<div style="width: 800px; height: 700px; padding: 10px; border: solid 1px #e1e3e9;">
		<div id="divChatData"></div>
	</div>
	<div style="width: 100%; height: 10%; padding: 10px;">
		<input type="text" id="message" size="110" onkeypress="if(event.keyCode==13){webSocket.sendChat();}" />
		<input type="button" id="btnSend" value="채팅 전송" onclick="webSocket.sendChat()" />
	</div>
</body>
</html>