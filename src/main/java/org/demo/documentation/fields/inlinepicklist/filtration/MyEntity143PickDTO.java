package org.demo.documentation.fields.inlinepicklist.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity143PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity143PickDTO(org.demo.documentation.fields.inlinepicklist.filtration.picklist.MyEntity143 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
