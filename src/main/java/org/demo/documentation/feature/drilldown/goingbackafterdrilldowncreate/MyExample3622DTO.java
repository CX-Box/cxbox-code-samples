package org.demo.documentation.feature.drilldown.goingbackafterdrilldowncreate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3622DTO extends DataResponseDTO {

	private String customField;

	public MyExample3622DTO(MyEntity3622 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}