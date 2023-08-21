package org.demo.documentation.date.validationruntimeex;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class DateValidationRuntimeExEntityDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateValueProvider.class)
	private LocalDate customField;

	public DateValidationRuntimeExEntityDTO(DateValidationRuntimeExEntity entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}