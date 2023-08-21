package org.demo.documentation.inlinepicklist.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity141PickDTO extends DataResponseDTO {

	private String customField;

	public MyEntity141PickDTO(org.demo.documentation.inlinepicklist.drilldown.picklist.MyEntity141 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
