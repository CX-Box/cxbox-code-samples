package org.demo.documentation.multivaluero.validationruntimeex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity222MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity222MultivalueDTO(MyEntity222 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
