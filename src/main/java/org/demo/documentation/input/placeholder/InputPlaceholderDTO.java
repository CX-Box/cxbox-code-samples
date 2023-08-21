package org.demo.documentation.input.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputPlaceholderDTO extends DataResponseDTO {

	private String customField;

	public InputPlaceholderDTO(InputPlaceholder entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}