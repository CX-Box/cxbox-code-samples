package org.demo.documentation.fields.radio.required;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.radio.required.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample27DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	public MyExample27DTO(MyEntity27 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}