package org.demo.documentation.inlinepicklist.validationconfirm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity153PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity153PickDTO(org.demo.documentation.inlinepicklist.validationconfirm.picklist.MyEntity153 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
