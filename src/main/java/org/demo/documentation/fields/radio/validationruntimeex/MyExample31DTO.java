package org.demo.documentation.fields.radio.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.demo.documentation.fields.radio.validationruntimeex.enums.CustomFieldEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample31DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = EnumValueProvider.class)
	private CustomFieldEnum customField;

	public MyExample31DTO(MyEntity31 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}