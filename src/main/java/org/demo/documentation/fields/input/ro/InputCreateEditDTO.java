package org.demo.documentation.fields.input.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputCreateEditDTO extends DataResponseDTO {

	private String customField;

	public InputCreateEditDTO(InputCreateEdit entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
