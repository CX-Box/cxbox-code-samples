package org.demo.documentation.fields.input.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputValidationDTO extends DataResponseDTO {

	private String customField;

	public InputValidationDTO(InputValidation entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}