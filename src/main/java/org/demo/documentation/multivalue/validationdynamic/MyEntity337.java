package org.demo.documentation.multivalue.validationdynamic;

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
public class MyEntity337 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customFieldAdditional;

}