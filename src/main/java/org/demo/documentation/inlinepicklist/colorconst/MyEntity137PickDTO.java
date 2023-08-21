package org.demo.documentation.inlinepicklist.colorconst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity137PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity137PickDTO(org.demo.documentation.inlinepicklist.colorconst.picklist.MyEntity137 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
