package org.demo.documentation.multivaluero.color;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity203MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity203MultivalueDTO(MyEntity203 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
