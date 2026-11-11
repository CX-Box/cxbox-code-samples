package org.demo.documentation.feature.scheduler.task;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MyEntity5262 extends BaseEntity {

	@Column
	private String customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private MyEntity5262Status status = MyEntity5262Status.NEW;

	@Column
	private LocalDateTime scheduledDate;

	@Column
	private LocalDateTime executedDate;

}
