package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.base.allfields.enums.CustomFieldDictionaryEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3202MultiHover extends BaseEntity {
	@Column
	private String customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
}