package org.demo.documentation.multivaluero.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity211MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity211MultivalueDTO(MyEntity211 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
