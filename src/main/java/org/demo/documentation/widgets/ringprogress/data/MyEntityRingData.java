package org.demo.documentation.widgets.ringprogress.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntityRingData extends BaseEntity {
	@Column
	private String customField;
	@Column
	private Long customFieldNum = 0L;
	@Column
	private CustomFieldStatusEnum customFieldDictionary;
	@Column
	LocalDateTime customFieldDate;
}
