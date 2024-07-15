package org.demo.documentation.fields.checkbox.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample80DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BooleanValueProvider.class)
	private Boolean customField;

	public MyExample80DTO(MyEntity80 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}