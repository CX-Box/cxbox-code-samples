package org.demo.documentation.multivalue.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity185MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity185MultivalueDTO(MyEntity185 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
