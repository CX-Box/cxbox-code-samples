package org.demo.documentation.fields.inlinepicklist.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity151PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity151PickDTO(org.demo.documentation.fields.inlinepicklist.validationbusinessex.picklist.MyEntity151 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
