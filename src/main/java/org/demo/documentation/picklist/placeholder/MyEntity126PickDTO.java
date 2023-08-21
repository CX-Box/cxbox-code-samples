package org.demo.documentation.picklist.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity126PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity126PickDTO(MyEntity126 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
