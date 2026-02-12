package org.demo.documentation.fields.suggestion.validationdynamic.forfield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3118DTO extends DataResponseDTO {

	private String customField;
	private String customFieldAdditional;

	public MyExample3118DTO(MyEntity3118 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldAdditional = entity.getCustomFieldAdditional();
	}
}