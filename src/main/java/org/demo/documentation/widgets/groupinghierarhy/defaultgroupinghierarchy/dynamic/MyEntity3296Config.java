package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryLevelTwoEnum;

/**
 * One row = one node of the default hierarchy, stored in DB (e.g. edited by admin in UI).
 * customFieldDictionaryLevelTwo == null means the level 1 group without children.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3296Config extends BaseEntity {

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;

	@Column
	private Boolean defaultExpanded;

}
