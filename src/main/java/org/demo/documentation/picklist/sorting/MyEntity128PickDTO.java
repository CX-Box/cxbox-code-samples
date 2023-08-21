package org.demo.documentation.picklist.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity128PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity128PickDTO(MyEntity128 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
