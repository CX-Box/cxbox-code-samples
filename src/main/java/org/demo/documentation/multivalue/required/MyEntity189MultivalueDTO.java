package org.demo.documentation.multivalue.required;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity189MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity189MultivalueDTO(MyEntity189 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
