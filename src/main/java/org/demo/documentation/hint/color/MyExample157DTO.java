package org.demo.documentation.hint.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample157DTO extends DataResponseDTO {

	private String customField;

	public MyExample157DTO(MyEntity157 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}