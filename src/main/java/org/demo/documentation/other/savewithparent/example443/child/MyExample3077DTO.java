package org.demo.documentation.other.savewithparent.example443.child;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3077DTO extends DataResponseDTO {
	private String customField;
	private String parentId;

	public MyExample3077DTO(MyEntity3077OutServiceDTO entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.parentId = entity.getParentId();
	}
}