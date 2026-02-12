package org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.inlinepicklist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092Pick;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3092PickPick0DTO extends DataResponseDTO {

	private String customField;

	public MyEntity3092PickPick0DTO(MyEntity3092Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
