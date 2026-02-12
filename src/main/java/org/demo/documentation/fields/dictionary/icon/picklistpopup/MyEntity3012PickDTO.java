package org.demo.documentation.fields.dictionary.icon.picklistpopup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3012PickDTO extends DataResponseDTO {

	private CustomFieldDictionaryEnum customFieldDictionary;
	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity3012PickDTO(MyEntity3012 entity) {
		this.id = entity.getId().toString();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customField = entity.getCustomField();
	}

}
