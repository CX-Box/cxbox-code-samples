package org.demo.documentation.multivalue.validationannotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity199MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity199MultivalueDTO(MyEntity199 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
