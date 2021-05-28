package kr.or.ddit.websocket;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketEchoHandler extends TextWebSocketHandler {
	
//	@Inject
	@Named("userList")
	private List<WebSocketSession> userList;

//	커넥트
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		userList.add(session);
	}

//	연결종료
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		userList.remove(session);
	}

//	이야기받기
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String data = message.getPayload();
		for(WebSocketSession user : userList) {			
			user.sendMessage(new TextMessage(data));
		}
	}
}
