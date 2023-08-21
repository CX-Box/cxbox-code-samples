package org.demo.documentation.multivaluehover.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity232MultivalueDTO extends DataResponseDTO {

	private String customField;

	public MyEntity232MultivalueDTO(MyEntity232 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
