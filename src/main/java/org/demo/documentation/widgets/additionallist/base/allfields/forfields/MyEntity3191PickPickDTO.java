package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3191PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3191PickPickDTO(MyEntity3191Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
