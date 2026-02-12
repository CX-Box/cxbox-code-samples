package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryLevelTwoEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3165 extends BaseEntity {
	@Column
	private String customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryLevelThreeEnum customFieldDictionaryLevelThree;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;
}