package org.demo.documentation.picklist.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity125PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity125PickDTO(MyEntity125 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
