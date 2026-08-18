package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3268PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3268PickPickDTO(MyEntity3268Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
