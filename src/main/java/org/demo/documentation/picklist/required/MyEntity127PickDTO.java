package org.demo.documentation.picklist.required;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity127PickDTO extends DataResponseDTO {
	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity127PickDTO(MyEntity127 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
