package org.demo.documentation.multivalue.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity181MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity181MultivalueDTO(MyEntity181 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
