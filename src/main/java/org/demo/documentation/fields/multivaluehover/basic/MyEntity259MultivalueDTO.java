package org.demo.documentation.fields.multivaluehover.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity259MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity259MultivalueDTO(MyEntity259 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
