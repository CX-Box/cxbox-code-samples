package org.demo.conf.cxbox.extention.notification;


import org.demo.conf.cxbox.meta.User;

public interface WebSocketNotificationService {

	void send(SocketNotificationDTO socketNotificationDTO, User currentUser);

}
