package org.demo.documentation.multivalue.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity187MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity187MultivalueDTO(MyEntity187 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
