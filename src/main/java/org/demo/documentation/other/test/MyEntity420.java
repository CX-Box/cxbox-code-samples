package org.demo.documentation.other.test;

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
public class MyEntity420 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customField2;

	@Column
	private String customField3;

	@Column
	private String customF9ield3;

	@Column
	private String customFieldForceActive;

	@Column
	private String customFieldForceActive3;

	@Column
	private String customFieldForceActive2;

}