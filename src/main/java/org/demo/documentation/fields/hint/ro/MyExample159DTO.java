package org.demo.documentation.fields.hint.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample159DTO extends DataResponseDTO {

	private String customField;

	public MyExample159DTO(MyEntity159 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}