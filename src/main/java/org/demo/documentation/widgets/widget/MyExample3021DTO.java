package org.demo.documentation.widgets.widget;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3021DTO extends DataResponseDTO {

	private String customField;

	public MyExample3021DTO(MyEntity3021 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}