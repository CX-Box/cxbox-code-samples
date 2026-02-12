package org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields.enums.CustomFieldDictionaryEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3124 extends BaseEntity {
	@Column
	private String customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
	@Column
	private Long customFieldNumber;
	@Column
	private Long customFieldNumberOther;
}