package org.demo.documentation.fields.dictionary.icon.picklistpopup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3012 extends BaseEntity {
	@Column
	private String customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
}