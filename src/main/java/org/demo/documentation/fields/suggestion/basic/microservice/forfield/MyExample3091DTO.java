package org.demo.documentation.fields.suggestion.basic.microservice.forfield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3091DTO extends DataResponseDTO {

	private String customField;
	private String customFieldDate;

	public MyExample3091DTO(MyEntity3091 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldDate = entity.getCustomFieldDate();
	}
}