package org.demo.conf.cxbox.extension.notification.entity;

import jakarta.persistence.*;
import lombok.*;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.entity.core.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(name = "NOTIFICATION")
public class NotificationEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	private Boolean isRead;

	private String text;

	private LocalDateTime createdDateUtc;

	@Builder.Default
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY, mappedBy = "notification")
	private List<NotificationLinkEntity> links = new ArrayList<>();

	/**
	 * see <a href="https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/">best way to map a OneToMany association</a>
	 */
	public void addNotificationLinks(List<NotificationLinkEntity> links) {
		this.links.addAll(links);
		links.forEach(link -> link.setNotification(this));
	}

	public void removeNotificationLinks(NotificationLinkEntity link) {
		this.links.remove(link);
		link.setNotification(null);
	}

}
