package org.demo.documentation.multivaluero.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity201MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity201MultivalueDTO(MyEntity201 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
