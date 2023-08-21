package org.demo.documentation.multivalue.validationbusinessex;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity193MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity193MultivalueDTO(MyEntity193 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
