package org.demo.documentation.fields.dictionary.dictionarydictionary.anysorce;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample381DTO extends DataResponseDTO {

	private DictionaryType customField;

	public MyExample381DTO(MyEntity381 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}