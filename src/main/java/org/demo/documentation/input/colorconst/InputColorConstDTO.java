package org.demo.documentation.input.colorconst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputColorConstDTO extends DataResponseDTO {

	private String customField;

	public InputColorConstDTO(InputColorConst entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}