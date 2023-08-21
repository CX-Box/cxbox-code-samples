package org.demo.documentation.hint.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample162DTO extends DataResponseDTO {

	private String customField;

	public MyExample162DTO(MyEntity162 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}