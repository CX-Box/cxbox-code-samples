package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryLevelTwoEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3157 extends BaseEntity {
	@Column
	private String customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;
}