package org.demo.documentation.input.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputValidationRuntimeExceptionDTO extends DataResponseDTO {

	private String customField;

	public InputValidationRuntimeExceptionDTO(InputValidationRuntimeException entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}