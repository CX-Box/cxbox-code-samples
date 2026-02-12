package org.demo.documentation.fields.multivaluehover.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntityMulti235PickDTO extends DataResponseDTO {

	private Double customField;

	public MyEntityMulti235PickDTO(MyEntityMulti235 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
