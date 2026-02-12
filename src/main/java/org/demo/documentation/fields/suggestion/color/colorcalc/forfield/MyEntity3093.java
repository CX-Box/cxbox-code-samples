package org.demo.documentation.fields.suggestion.color.colorcalc.forfield;

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
public class MyEntity3093 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldDate;
}