package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelFourEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryLevelTwoEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3155DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;
	@SearchParameter(name = "customFieldDictionaryLevelTwo", provider = EnumValueProvider.class)
	private CustomFieldDictionaryLevelTwoEnum customFieldDictionaryLevelTwo;
	@SearchParameter(name = "customFieldDictionaryLevelThree", provider = EnumValueProvider.class)
	private CustomFieldDictionaryLevelThreeEnum customFieldDictionaryLevelThree;
	@SearchParameter(name = "customFieldDictionaryLevelFour", provider = EnumValueProvider.class)
	private CustomFieldDictionaryLevelFourEnum customFieldDictionaryLevelFour;

	public MyExample3155DTO(MyEntity3155 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customFieldDictionaryLevelTwo = entity.getCustomFieldDictionaryLevelTwo();
		this.customFieldDictionaryLevelThree = entity.getCustomFieldDictionaryLevelThree();
		this.customFieldDictionaryLevelFour = entity.getCustomFieldDictionaryLevelFour();
	}
}