package org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.picklist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.picklist.base.onefield.picklistpopup.MyEntity3079Pick;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3079PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3079PickPickDTO(MyEntity3079Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
