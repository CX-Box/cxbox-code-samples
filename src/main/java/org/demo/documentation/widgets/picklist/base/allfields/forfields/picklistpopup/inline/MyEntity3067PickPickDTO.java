package org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.inline;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067Pick;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3067PickPickDTO(MyEntity3067Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
