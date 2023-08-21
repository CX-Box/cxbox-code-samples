package org.demo.documentation.multivaluero.required;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity215MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity215MultivalueDTO(MyEntity215 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
