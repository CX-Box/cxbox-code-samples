package org.demo.documentation.picklist.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity330PickDTO extends DataResponseDTO {

	private String customField;

	private String customFieldAdditional;

	public MyEntity330PickDTO(MyEntity331 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}
