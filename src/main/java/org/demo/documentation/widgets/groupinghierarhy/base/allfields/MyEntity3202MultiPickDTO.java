package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3202MultiPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3202MultiPickDTO(MyEntity3202Multi entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
