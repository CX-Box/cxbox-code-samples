package org.demo.documentation.datetime.validationruntimeex;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;

@Getter
@Setter
@NoArgsConstructor
public class DateTimeValidationRuntimeExDTO extends DataResponseDTO {

	@SearchParameter(name = "customField", provider = DateTimeValueProvider.class)
	private LocalDateTime customField;

	public DateTimeValidationRuntimeExDTO(DateTimeValidationRuntimeEx entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}