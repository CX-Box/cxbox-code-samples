package org.demo.documentation.percent.validationannotation;

import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class MyExample292DTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = BigDecimalValueProvider.class)
	@Min(value = 5, message = "The field  cannot be less than 5%.")
	private Long customField;

	public MyExample292DTO(MyEntity292 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}