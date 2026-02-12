package org.demo.documentation.fields.dictionary.dictionarydictionary.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DictionaryValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample106DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	@SearchParameter(name = "customFieldDictionary", provider = DictionaryValueProvider.class)
	private CustomDictionarySorting customFieldDictionary;


	@SearchParameter(name = "customFieldDictionaryExample", provider = DictionaryValueProvider.class)
	private CustomDictionarySortingExample customFieldDictionaryExample;

	public MyExample106DTO(MyEntity106 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customFieldDictionaryExample = entity.getCustomFieldDictionaryExample();
	}
}