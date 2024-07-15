package org.demo.documentation.fields.dictionary.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.dictionary.placeholder.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample88DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	public MyExample88DTO(MyEntity88 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}