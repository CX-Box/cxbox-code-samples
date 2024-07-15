package org.demo.documentation.fields.hint.colorconst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample158DTO extends DataResponseDTO {

	private String customField;

	public MyExample158DTO(MyEntity158 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}