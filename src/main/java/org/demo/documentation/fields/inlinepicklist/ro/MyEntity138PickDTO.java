package org.demo.documentation.fields.inlinepicklist.ro;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity138PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity138PickDTO(org.demo.documentation.fields.inlinepicklist.ro.picklist.MyEntity138 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
