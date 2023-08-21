package org.demo.documentation.input.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class InputSortDTO extends DataResponseDTO {

	private String customField;

	public InputSortDTO(InputSort entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}