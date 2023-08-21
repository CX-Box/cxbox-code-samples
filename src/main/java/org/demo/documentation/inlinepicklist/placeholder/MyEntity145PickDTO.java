package org.demo.documentation.inlinepicklist.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.inlinepicklist.placeholder.picklist.MyEntity145;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity145PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity145PickDTO(MyEntity145 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
