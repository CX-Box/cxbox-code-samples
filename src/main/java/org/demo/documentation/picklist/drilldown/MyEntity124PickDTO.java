package org.demo.documentation.picklist.drilldown;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity124PickDTO extends DataResponseDTO {
	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity124PickDTO(MyEntity124 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
