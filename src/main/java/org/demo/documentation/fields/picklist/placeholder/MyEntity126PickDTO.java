package org.demo.documentation.fields.picklist.placeholder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyEntity126PickDTO extends DataResponseDTO {
	@SearchParameter(name = "customField")
	private String customField;

	public MyEntity126PickDTO(MyEntity126 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}
