package org.demo.documentation.checkbox.validationdynamic;

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
public class MyEntity289 extends BaseEntity {

	@Column
	private Boolean customField;

	@Column
	private Boolean customFieldAdditional;

}