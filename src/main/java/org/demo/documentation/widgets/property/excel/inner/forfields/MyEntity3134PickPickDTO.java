package org.demo.documentation.widgets.property.excel.inner.forfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity3134PickPickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity3134PickPickDTO(MyEntity3134Pick entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
