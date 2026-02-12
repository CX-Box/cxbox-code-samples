package org.demo.documentation.fields.suggestion.basic.listvalues.forsuggectionpicklistfield;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4600DTO extends DataResponseDTO {

	private String customField;

	public MyExample4600DTO(MyEntity4600OutServiceDTO entity) {
		this.id = entity.getId();
		this.customField = entity.getCustomField();
	}
}