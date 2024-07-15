package org.demo.documentation.fields.input.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputColorDTO extends DataResponseDTO {

	private String customField;

	private String customFieldColor;

	public InputColorDTO(InputColor entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldColor = "#eda6a6";
	}

}