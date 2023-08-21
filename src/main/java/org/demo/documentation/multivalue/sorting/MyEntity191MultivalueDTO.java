package org.demo.documentation.multivalue.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity191MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity191MultivalueDTO(MyEntity191 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
