package org.demo.documentation.feature.massoperations.gh;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.StringValueProvider;
import org.demo.documentation.feature.massoperations.gh.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample6102DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = StringValueProvider.class)
	private String customField;

	@SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldCheckbox;

	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;

	public MyExample6102DTO(MyEntity6102 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldCheckbox = entity.getCustomFieldCheckbox();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
	}
}
