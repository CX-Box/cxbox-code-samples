package org.demo.documentation.fields.checkbox.validationdynamic;

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
public class MyEntity289 extends BaseEntity {

	@Column
	private Boolean customField;

	@Column
	private Boolean customFieldAdditional;

}