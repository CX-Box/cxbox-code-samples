package org.demo.documentation.fields.suggestion.validationdynamic.forfield;

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
public class MyEntity3118 extends BaseEntity {
	@Column
	private String customField;

	@Column
	private String customFieldAdditional;
}