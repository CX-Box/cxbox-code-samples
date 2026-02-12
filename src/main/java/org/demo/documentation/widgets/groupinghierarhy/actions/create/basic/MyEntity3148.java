package org.demo.documentation.widgets.groupinghierarhy.actions.create.basic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.enums.CustomFieldDictionaryEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3148 extends BaseEntity {
	@Column
	private String customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
	@Column
	private String customFieldText;
}