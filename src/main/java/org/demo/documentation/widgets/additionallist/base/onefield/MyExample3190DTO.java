package org.demo.documentation.widgets.additionallist.base.onefield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.widgets.additionallist.base.onefield.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3190DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;

	public MyExample3190DTO(MyEntity3190 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
	}
}