package org.demo.documentation.fields.suggestion.required.forfield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3098DTO extends DataResponseDTO {

	private String customField;

	public MyExample3098DTO(MyEntity3098 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}