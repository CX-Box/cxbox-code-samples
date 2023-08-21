package org.demo.documentation.input.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputBasicDTO extends DataResponseDTO {

	private String customField;

	private String customFieldRO;

	public InputBasicDTO(InputBasic entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldRO = entity.getCustomFieldRO();
	}

}