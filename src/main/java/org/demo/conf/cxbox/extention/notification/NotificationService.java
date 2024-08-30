package org.demo.conf.cxbox.extention.notification;


import org.demo.conf.cxbox.meta.User;

import java.util.List;


public interface NotificationService {

	Notification sendAndSave(SocketNotificationDTO notification, User notificationOwner);

	List<NotificationDTO> getNotifications(Integer page, Integer limit);

	Long getNotificationCount();

	void markAsRead(List<Long> notificationId);

	void delete(List<Long> ids);

	Long getCountWithMark(Boolean mark);
}
