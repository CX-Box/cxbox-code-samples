package org.demo.documentation.widgets.property.sethidden;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum2;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity5019Pick extends BaseEntity {
	@Column
	private String customField;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum2 customFieldDictionary;
}
