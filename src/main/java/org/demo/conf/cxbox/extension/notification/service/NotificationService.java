package org.demo.conf.cxbox.extension.notification.service;

import org.demo.conf.cxbox.extension.notification.NotificationTemplate;
import org.demo.conf.cxbox.extension.notification.dto.NotificationDTO;

import java.util.List;


public interface NotificationService extends NotificationTemplate {

	Long getNotificationCount();

	Long checkNewNotifications(Boolean mark);

	List<NotificationDTO> getNotifications(Integer page, Integer limit);

	void markAsRead(List<Long> ids);

	void delete(List<Long> ids);

}
