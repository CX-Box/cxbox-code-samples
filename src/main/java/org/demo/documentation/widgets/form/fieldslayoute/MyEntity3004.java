package org.demo.documentation.widgets.form.fieldslayoute;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

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
}