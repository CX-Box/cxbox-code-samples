package org.demo.documentation.multivalue.basic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity177MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity177MultivalueDTO(MyEntityMultivalue177 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
