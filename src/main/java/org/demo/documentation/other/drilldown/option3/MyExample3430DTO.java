package org.demo.documentation.other.drilldown.option3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3430DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample3430DTO(MyEntity3430 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}
}