package org.demo.documentation.multivaluero.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity219MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity219MultivalueDTO(MyEntity219 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
