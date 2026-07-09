package org.demo.documentation.widgets.ringprogress;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntityRingData extends BaseEntity {
	@Column
	private String customField;
	@Column
	private Long customFieldNum = 0L;
}