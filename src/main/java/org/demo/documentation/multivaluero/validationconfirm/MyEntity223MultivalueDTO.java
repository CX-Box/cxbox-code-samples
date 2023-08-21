package org.demo.documentation.multivaluero.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity223MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity223MultivalueDTO(MyEntity223 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
