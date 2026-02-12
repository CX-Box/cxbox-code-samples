package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fivelevel.enums.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3158 extends BaseEntity {
	@Column
	private String customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryLevelThreeEnum customFieldDictionaryLevelThree;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryLevelFourEnum customFieldDictionaryLevelFour;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryLevelFiveEnum customFieldDictionaryLevelFive;
}