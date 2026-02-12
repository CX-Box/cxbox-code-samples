package org.demo.documentation.feature.meta.buildindependentmeta.setdictionarytypewithconcretevaluesfromlist;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3154
// 3154
// 3154

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3154 extends BaseEntity {
	@Column
	private String customField;
}