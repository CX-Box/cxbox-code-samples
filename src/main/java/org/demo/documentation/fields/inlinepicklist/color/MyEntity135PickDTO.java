package org.demo.documentation.fields.inlinepicklist.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity135PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity135PickDTO(org.demo.documentation.fields.inlinepicklist.color.picklist.MyEntity135 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
