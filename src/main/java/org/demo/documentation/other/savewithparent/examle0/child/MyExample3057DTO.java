package org.demo.documentation.other.savewithparent.examle0.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3057DTO extends DataResponseDTO {

	private String customField;

	public MyExample3057DTO(MyEntity3057 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}