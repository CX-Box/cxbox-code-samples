package org.demo.conf.cxbox.extension.notification.entity;

import jakarta.persistence.*;
import lombok.*;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.model.core.entity.BaseEntity;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "NOTIFICATION_LINKS")
public class NotificationLinkEntity extends BaseEntity {

	@Column
	private String drillDownLink;

	@Column
	private String drillDownLabel;

	@Column
	private DrillDownType drillDownType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NOTIFICATION_ID", nullable = false)
	private NotificationEntity notification;

}
