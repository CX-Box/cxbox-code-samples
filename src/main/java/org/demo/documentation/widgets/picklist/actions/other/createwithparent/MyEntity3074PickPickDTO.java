package org.demo.documentation.widgets.picklist.actions.other.createwithparent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3074PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3074PickPickDTO(MyEntity3074Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
