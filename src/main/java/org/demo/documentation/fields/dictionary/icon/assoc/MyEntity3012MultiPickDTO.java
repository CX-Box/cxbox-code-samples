package org.demo.documentation.fields.dictionary.icon.assoc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3012MultiPickDTO extends DataResponseDTO {

	private CustomFieldDictionaryEnum customFieldDictionary;

	public MyEntity3012MultiPickDTO(org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi entity) {
		this.id = entity.getId().toString();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
	}

}
