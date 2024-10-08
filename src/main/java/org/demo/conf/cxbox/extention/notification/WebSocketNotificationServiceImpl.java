package org.demo.conf.cxbox.extention.notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import org.demo.conf.cxbox.meta.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebSocketNotificationServiceImpl implements WebSocketNotificationService {

	private final SimpMessagingTemplate simpMessagingTemplate;

	private final ObjectMapper objectMapper;

	@Value("${spring.websocket.prefix}")
	private String prefix;

	@Value("${spring.websocket.urlPath}")
	private String urlPath;

	@Override
	@SneakyThrows
	public void send(SocketNotificationDTO socketNotificationDTO, User currentUser) {

		simpMessagingTemplate.convertAndSend(
				prefix + "/" + currentUser.getId() + urlPath,
				objectMapper.writeValueAsString(socketNotificationDTO)
		);
	}

}
