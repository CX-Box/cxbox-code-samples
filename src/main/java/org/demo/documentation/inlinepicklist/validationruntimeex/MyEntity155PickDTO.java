package org.demo.documentation.inlinepicklist.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity155PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity155PickDTO(org.demo.documentation.inlinepicklist.validationruntimeex.picklist.MyEntity155 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
