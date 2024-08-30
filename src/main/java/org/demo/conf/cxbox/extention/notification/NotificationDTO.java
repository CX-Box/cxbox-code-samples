package org.demo.conf.cxbox.extention.notification;

import lombok.Getter;
import lombok.Setter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Setter
@Getter
public class NotificationDTO {

	private Long id;

	private Boolean isRead;

	private String text;

	private ZonedDateTime createTime;

	public NotificationDTO(Notification notification) {
		this.id = notification.getId();
		this.isRead = notification.getIsRead();
		this.text = notification.getText();
		this.createTime = ZonedDateTime.of(notification.getCreatedDateUtc(), ZoneId.of("Z"));
	}

}
