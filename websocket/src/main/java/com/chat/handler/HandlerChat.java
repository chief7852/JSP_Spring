package com.chat.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class HandlerChat extends TextWebSocketHandler {

	// 세션리스트를 담을 List(나중에는 세션접속자의 정보까지 들고와야해서 Map으로 바꿔야함)
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	// 클라이언트가 처음 접속했을때(init역할)
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		// 채팅방에 접속한 사용자 세션을 리스트에 저장
		sessionList.add(session);

		// 모든 세션에 채팅 전달
		for (int i = 0; i < sessionList.size(); i++) {
			WebSocketSession s = sessionList.get(i);
			s.sendMessage(new TextMessage(session.getId() + "님이 입장 했습니다."));
		}
	}
	
	// 클라이언트에서 메세지가 전달되면
	// 서버에서 모든 클라이언트에 전송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		// 모든 세션에 채팅 전달
		for (int i = 0; i < sessionList.size(); i++) {
			WebSocketSession s = sessionList.get(i);
			s.sendMessage(new TextMessage(session.getId() + " : " + message.getPayload()));
		}
	}

	// 클라이언트가 연결을 끊음 처리
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

		// 채팅방에서 퇴장한 사용자 세션을 리스트에서 제거
		sessionList.remove(session);

		// 모든 세션에 연결종료채팅 전달
		for (int i = 0; i < sessionList.size(); i++) {
			WebSocketSession s = sessionList.get(i);
			s.sendMessage(new TextMessage(session.getId() + "님이 퇴장 했습니다."));
		}

	}
}