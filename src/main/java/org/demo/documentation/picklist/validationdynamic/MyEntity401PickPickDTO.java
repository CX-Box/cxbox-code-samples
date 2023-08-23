package org.demo.documentation.picklist.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity401PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity401PickPickDTO(MyEntity401Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
