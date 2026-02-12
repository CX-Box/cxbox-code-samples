package org.demo.documentation.other.savewithparent.example2.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3131DTO extends DataResponseDTO {

	private String customField;

	public MyExample3131DTO(MyEntity3131 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}