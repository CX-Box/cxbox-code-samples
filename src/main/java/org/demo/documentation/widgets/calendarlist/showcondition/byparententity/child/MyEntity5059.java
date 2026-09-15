package org.demo.documentation.widgets.calendarlist.showcondition.byparententity.child;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.calendarlist.showcondition.byparententity.parent.MyEntity5058;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5059 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private LocalDateTime startDateTime;

	@Column
	private LocalDateTime endDateTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private MyEntity5058 customFieldEntity;

}
