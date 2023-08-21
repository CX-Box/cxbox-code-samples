package org.demo.documentation.text.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;

@Getter
@Setter
@NoArgsConstructor
public class MyExample48DTO extends DataResponseDTO {

	@SearchParameter(name = "customField")
	private String customField;

	public MyExample48DTO(MyEntity48 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
	}

}