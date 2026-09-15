package org.demo.documentation.widgets.calendarlist.actions.edit.newview;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5065 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private LocalDateTime startDateTime;

	@Column
	private LocalDateTime endDateTime;

}
