package org.demo.documentation.picklist.validationannotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity297PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity297PickDTO(MyEntity297 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
