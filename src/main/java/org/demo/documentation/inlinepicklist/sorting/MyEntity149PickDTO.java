package org.demo.documentation.inlinepicklist.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity149PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity149PickDTO(org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
