package org.demo.documentation.picklist.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity131PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity131PickDTO(MyEntity131 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
