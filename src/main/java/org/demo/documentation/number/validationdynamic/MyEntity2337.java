package org.demo.documentation.number.validationdynamic;

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
public class MyEntity2337 extends BaseEntity {

	@Column
	private Long customField;

	@Column
	private Long customFieldAdditional;

}