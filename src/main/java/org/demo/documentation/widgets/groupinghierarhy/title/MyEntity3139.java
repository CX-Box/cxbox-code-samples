package org.demo.documentation.widgets.groupinghierarhy.title;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.title.enums.CustomFieldDictionaryEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3139 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String iNFO_TEXT_EMPTY_TITLE;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
}