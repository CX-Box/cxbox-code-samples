package org.demo.documentation.input.required;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputRequiredDTO extends DataResponseDTO {

	private String customField;

	public InputRequiredDTO(InputRequired entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}