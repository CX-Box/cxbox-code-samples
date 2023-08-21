package org.demo.documentation.inlinepicklist.required;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity147PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity147PickDTO(org.demo.documentation.inlinepicklist.required.picklist.MyEntity147 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
