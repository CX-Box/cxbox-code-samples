package org.demo.documentation.other.savewithparent.example443.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3076DTO extends DataResponseDTO {
	private String customField;
	private String customFieldNew;

	public MyExample3076DTO(MyEntity3076OutServiceDTO entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldNew = entity.getCustomFieldNew();
	}
}