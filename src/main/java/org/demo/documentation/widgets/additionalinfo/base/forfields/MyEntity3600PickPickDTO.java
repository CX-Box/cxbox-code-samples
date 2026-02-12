package org.demo.documentation.widgets.additionalinfo.base.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3600PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3600PickPickDTO(MyEntity3600Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
