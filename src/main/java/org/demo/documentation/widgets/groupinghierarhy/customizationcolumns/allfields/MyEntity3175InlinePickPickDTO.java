package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3175InlinePickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3175InlinePickPickDTO(MyEntity3175InlinePick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
