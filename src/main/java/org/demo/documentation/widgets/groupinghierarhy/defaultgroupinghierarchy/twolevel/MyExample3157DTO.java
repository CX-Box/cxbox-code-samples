package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryLevelTwoEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3157DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;
	@SearchParameter(name = "customFieldDictionaryLevelTwo", provider = EnumValueProvider.class)
	private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;

	public MyExample3157DTO(MyEntity3157 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customFieldDictionaryLevelTwo = entity.getCustomFieldDictionaryLevelTwo();
	}
}