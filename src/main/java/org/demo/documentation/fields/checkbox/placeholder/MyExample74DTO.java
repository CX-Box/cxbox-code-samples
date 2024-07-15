package org.demo.documentation.fields.checkbox.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample74DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BooleanValueProvider.class)
	private Boolean customField;

	public MyExample74DTO(MyEntity74 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}