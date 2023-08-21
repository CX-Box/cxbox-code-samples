package org.demo.documentation.multivaluero.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity217MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity217MultivalueDTO(MyEntity217 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
