package org.demo.documentation.widgets.picklist.actions.delete.forpicklistpopup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3188PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3188PickPickDTO(MyEntity3188Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
