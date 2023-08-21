package org.demo.documentation.multivaluero.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity209MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity209MultivalueDTO(MyEntity209 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
