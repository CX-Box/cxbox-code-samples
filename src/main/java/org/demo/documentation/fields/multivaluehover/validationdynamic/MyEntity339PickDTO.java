package org.demo.documentation.fields.multivaluehover.validationdynamic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity339PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity339PickDTO(MyEntity339 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
