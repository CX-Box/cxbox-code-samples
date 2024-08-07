package org.demo.documentation.fields.number.validationannotation;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample290DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	@Min(value = 100000, message = "The field  cannot be less than 100 000.")
	private Long customField;

	public MyExample290DTO(MyEntity290 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}