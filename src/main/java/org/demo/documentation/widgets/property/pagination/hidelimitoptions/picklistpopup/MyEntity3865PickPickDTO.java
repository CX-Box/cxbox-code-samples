package org.demo.documentation.widgets.property.pagination.hidelimitoptions.picklistpopup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3865PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3865PickPickDTO(MyEntity3865Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
