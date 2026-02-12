package org.demo.documentation.widgets.groupinghierarhy.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldRadioEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3121 extends BaseEntity {
	@Column
	private String customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
	@Column
	private Boolean customFieldCheckbox;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldRadioEnum customFieldRadio;
}