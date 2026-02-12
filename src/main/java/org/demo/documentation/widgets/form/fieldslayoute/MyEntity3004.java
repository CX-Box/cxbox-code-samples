package org.demo.documentation.widgets.form.fieldslayoute;

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
public class MyEntity3004 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customField2;
	@Column
	private String customField3;
	@Column
	private String customField4;
	@Column
	private String customField5;
	@Column
	private String customField6;
	@Column
	private String customField7;
	@Column
	private String customField9;
	@Column
	private String customField10;
	@Column
	private String customField8;
}