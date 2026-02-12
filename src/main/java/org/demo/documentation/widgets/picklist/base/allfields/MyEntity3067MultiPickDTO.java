package org.demo.documentation.widgets.picklist.base.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067MultiPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3067MultiPickDTO(org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
