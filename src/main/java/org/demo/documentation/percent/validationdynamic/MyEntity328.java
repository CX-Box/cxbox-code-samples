package org.demo.documentation.percent.validationdynamic;

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
public class MyEntity328 extends BaseEntity {

	@Column
	private Long customField;

	@Column
	private Long customFieldAdditional;

}