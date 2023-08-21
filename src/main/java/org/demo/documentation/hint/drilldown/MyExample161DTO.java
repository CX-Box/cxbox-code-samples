package org.demo.documentation.hint.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample161DTO extends DataResponseDTO {

	private String customField;

	public MyExample161DTO(MyEntity161 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}