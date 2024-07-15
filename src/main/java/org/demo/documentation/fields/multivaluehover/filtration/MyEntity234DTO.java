package org.demo.documentation.fields.multivaluehover.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity234DTO extends DataResponseDTO {

	private String customField;

	public MyEntity234DTO(MyEntity234 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
