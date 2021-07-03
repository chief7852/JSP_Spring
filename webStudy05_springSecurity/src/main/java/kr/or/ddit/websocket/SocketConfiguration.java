package kr.or.ddit.websocket;

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

public class SocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer{

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		destinationPrefixes
		registry.enableSimpleBroker("/topic","queue");
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	
//	endpoint설정을 /users라고 설정 해
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/users");
		registry.addEndpoint("/users").withSockJS();
		
	}

}
