package org.demo.documentation.widgets.picklist.base.allfields.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067MultiMultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3067MultiMultivalueDTO(MyEntity3067Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
