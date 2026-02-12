package org.demo.documentation.fields.dictionary.dictionarydictionary.icon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DictionaryValueProvider;


@Getter
@Setter
@NoArgsConstructor
public class MyExample355DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldDictionary", provider = DictionaryValueProvider.class)
	private CustomDictionary customFieldDictionary;

	private String color;

	public MyExample355DTO(MyEntity355 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
	}
}