package org.demo.documentation.widgets.info.fieldslayoute;

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
public class MyEntity3008 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customField2;
	@Column
	private String customField3;
	@Column
	private String customField5;
	@Column
	private String customField4;
}