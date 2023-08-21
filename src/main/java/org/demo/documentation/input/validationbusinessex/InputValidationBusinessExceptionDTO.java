package org.demo.documentation.input.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputValidationBusinessExceptionDTO extends DataResponseDTO {

	private String customField;

	public InputValidationBusinessExceptionDTO(InputValidationBusinessExc entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}