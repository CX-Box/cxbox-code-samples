package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3175PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3175PickPickDTO(MyEntity3175Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
