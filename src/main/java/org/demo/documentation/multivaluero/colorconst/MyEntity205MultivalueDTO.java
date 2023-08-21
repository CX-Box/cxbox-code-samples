package org.demo.documentation.multivaluero.colorconst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity205MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity205MultivalueDTO(MyEntity205 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
