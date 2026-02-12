package org.demo.documentation.widgets.statsblock.icon.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4222DTO extends DataResponseDTO {

	private String customField;

	public MyExample4222DTO(MyEntity4222 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}
