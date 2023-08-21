package org.demo.documentation.picklist.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity120PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity120PickDTO(MyEntity120 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
