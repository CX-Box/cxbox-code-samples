package org.demo.documentation.widgets.additionalinfo.showcondition;

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
public class MyEntity4231 extends BaseEntity {
	@Column
	private String customField;

	@Column
	private Long customFieldNum = 0L;
}