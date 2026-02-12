package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3030PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3030PickDTO(MyEntity3030 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
