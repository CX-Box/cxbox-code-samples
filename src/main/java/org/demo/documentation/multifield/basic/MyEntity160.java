package org.demo.documentation.multifield.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity160 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customFieldAdditional;

	@Column
	private String informationField;

	@Column
	private String customFieldMulti;

	@Column
	private String customFieldAdditionalMulti;

}