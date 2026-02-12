package org.demo.documentation.widgets.picklist.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3061MultiMultiMultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3061MultiMultiMultivalueDTO(org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061MultiMulti entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
