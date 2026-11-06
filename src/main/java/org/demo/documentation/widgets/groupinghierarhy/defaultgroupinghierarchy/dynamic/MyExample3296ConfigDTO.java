package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryLevelTwoEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3296ConfigDTO extends DataResponseDTO {

	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;

	@SearchParameter(name = "customFieldDictionaryLevelTwo", provider = EnumValueProvider.class)
	private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;

	@SearchParameter(name = "defaultExpanded", provider = BooleanValueProvider.class)
	private Boolean defaultExpanded;

	public MyExample3296ConfigDTO(MyEntity3296Config entity) {
		this.id = entity.getId().toString();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customFieldDictionaryLevelTwo = entity.getCustomFieldDictionaryLevelTwo();
		this.defaultExpanded = entity.getDefaultExpanded();
	}

}
