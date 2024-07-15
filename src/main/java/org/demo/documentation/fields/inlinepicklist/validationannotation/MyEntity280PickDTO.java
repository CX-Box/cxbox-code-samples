package org.demo.documentation.fields.inlinepicklist.validationannotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity280PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity280PickDTO(MyEntity280 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
