package org.demo.documentation.fields.suggestion.placeholder.forfield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3097DTO extends DataResponseDTO {

	private String customField;

	public MyExample3097DTO(MyEntity3097 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}