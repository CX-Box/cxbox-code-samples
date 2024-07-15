package org.demo.documentation.fields.inlinepicklist.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity327PickDTO extends DataResponseDTO {

	private String customField;

	private String customFieldAdditional;

	public MyEntity327PickDTO(MyEntity327 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}

}
