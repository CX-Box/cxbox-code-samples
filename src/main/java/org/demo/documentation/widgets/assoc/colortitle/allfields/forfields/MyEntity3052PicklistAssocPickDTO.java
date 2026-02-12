package org.demo.documentation.widgets.assoc.colortitle.allfields.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3052PicklistAssocPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3052PicklistAssocPickDTO(MyEntity3052PicklistAssoc entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
