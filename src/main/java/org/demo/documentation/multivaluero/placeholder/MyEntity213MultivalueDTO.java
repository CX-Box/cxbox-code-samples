package org.demo.documentation.multivaluero.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity213MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity213MultivalueDTO(MyEntity213 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
