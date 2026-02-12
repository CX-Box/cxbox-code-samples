package org.demo.documentation.widgets.additionalinfo.base.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3600Pick2PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3600Pick2PickDTO(MyEntity3600Pick2 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
