package org.demo.documentation.multivalue.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity195MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity195MultivalueDTO(MyEntity195 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
