package org.demo.documentation.multivalue.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity183MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity183MultivalueDTO(MyEntity183 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
